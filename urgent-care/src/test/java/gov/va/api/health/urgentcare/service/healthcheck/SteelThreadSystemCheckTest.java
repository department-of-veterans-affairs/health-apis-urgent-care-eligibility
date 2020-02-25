package gov.va.api.health.urgentcare.service.healthcheck;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import gov.va.api.health.queenelizabeth.ee.QueenElizabethService;
import gov.va.api.health.queenelizabeth.ee.exceptions.RequestFailed;
import gov.va.api.health.queenelizabeth.ee.handlers.BaseFaultSoapHandler;
import gov.va.med.esr.webservices.jaxws.schemas.GetEESummaryResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.actuate.health.Status;

public class SteelThreadSystemCheckTest {
  private static final String TEST_ICN = "123";

  private final int failureThresholdForTests = 5;

  @Mock QueenElizabethService client;

  @Mock SteelThreadSystemCheckLedger ledger;

  @Before
  public void _init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void healthCheckHappyPath() {
    SteelThreadSystemCheck test =
        new SteelThreadSystemCheck(client, ledger, TEST_ICN, failureThresholdForTests);
    when(ledger.getConsecutiveFailureCount()).thenReturn(failureThresholdForTests - 1);
    assertThat(test.health().getStatus()).isEqualTo(Status.UP);
  }

  @Test
  public void healthCheckSadPathWhenFailureThresholdExceeded() {
    SteelThreadSystemCheck test =
        new SteelThreadSystemCheck(client, ledger, TEST_ICN, failureThresholdForTests);
    when(ledger.getConsecutiveFailureCount()).thenReturn(failureThresholdForTests);
    assertThat(test.health().getStatus()).isEqualTo(Status.DOWN);
  }

  @Test
  public void healthCheckSkip() {
    SteelThreadSystemCheck test =
        new SteelThreadSystemCheck(client, ledger, "skip", failureThresholdForTests);
    when(ledger.getConsecutiveFailureCount()).thenReturn(failureThresholdForTests);
    assertThat(test.health().getStatus()).isEqualTo(Status.UP);
  }

  @Test
  public void runSteelThreadExceptionPath() {
    SteelThreadSystemCheck test =
        new SteelThreadSystemCheck(client, ledger, TEST_ICN, failureThresholdForTests);
    when(client.getEeSummary(TEST_ICN))
        .thenThrow(new IllegalArgumentException(new IllegalArgumentException("foo")));
    when(ledger.recordFailure()).thenReturn(failureThresholdForTests);

    try {
      test.runSteelThreadCheckAsynchronously();
    } catch (Exception e) {
      // Do nothing. Going to check if the failure is recorded afterwards.
    }
    verify(ledger, times(1)).recordFailure();
  }

  @Test
  public void runSteelThreadHappyPath() {
    GetEESummaryResponse getEESummaryResponse = new GetEESummaryResponse();
    when(client.getEeSummary(TEST_ICN)).thenReturn(getEESummaryResponse);
    SteelThreadSystemCheck test =
        new SteelThreadSystemCheck(client, ledger, TEST_ICN, failureThresholdForTests);
    test.runSteelThreadCheckAsynchronously();
    verify(ledger, times(1)).recordSuccess();
  }

  @Test
  public void runSteelThreadSadPath() {
    SteelThreadSystemCheck test =
        new SteelThreadSystemCheck(client, ledger, TEST_ICN, failureThresholdForTests);
    when(client.getEeSummary(TEST_ICN))
        .thenThrow(new RequestFailed(BaseFaultSoapHandler.FAULT_UNKNOWN_MESSAGE));
    when(ledger.recordFailure()).thenReturn(failureThresholdForTests);
    test.runSteelThreadCheckAsynchronously();
    verify(ledger, times(1)).recordFailure();
  }
}
