package gov.va.api.health.urgentcare.service.healthcheck;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import gov.va.api.health.urgentcare.service.queenelizabeth.client.QueenElizabethClient;
import gov.va.api.health.urgentcare.service.queenelizabeth.client.Query;
import gov.va.med.esr.webservices.jaxws.schemas.GetEESummaryResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.actuate.health.Status;

public class SteelThreadSystemCheckTest {

    private final int failureThresholdForTests = 5;

    @Mock
    QueenElizabethClient client;

    @Mock
    SteelThreadSystemCheckLedger ledger;

    @Before
    public void _init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void healthCheckHappyPath() {
        GetEESummaryResponse root = new GetEESummaryResponse();
        SteelThreadSystemCheck test = new SteelThreadSystemCheck(client, ledger, "123", failureThresholdForTests);
        when(ledger.getConsecutiveFailureCount()).thenReturn(failureThresholdForTests - 1);
        assertThat(test.health().getStatus()).isEqualTo(Status.UP);
    }

    @Test
    public void healthCheckSadPathWhenFailureThresholdExceeded() {
        SteelThreadSystemCheck test = new SteelThreadSystemCheck(client, ledger, "123", failureThresholdForTests);
        when(ledger.getConsecutiveFailureCount()).thenReturn(failureThresholdForTests);
        assertThat(test.health().getStatus()).isEqualTo(Status.DOWN);
    }

    @Test
    public void healthCheckSkip() {
        SteelThreadSystemCheck test = new SteelThreadSystemCheck(client, ledger, "skip", failureThresholdForTests);
        when(ledger.getConsecutiveFailureCount()).thenReturn(failureThresholdForTests);
        assertThat(test.health().getStatus()).isEqualTo(Status.UP);
    }

    @Test
    public void runSteelThreadExceptionPath() {
        SteelThreadSystemCheck test = new SteelThreadSystemCheck(client, ledger, "123", failureThresholdForTests);
        when(client.search(Mockito.any())).thenThrow(new IllegalArgumentException(new IllegalArgumentException("foo")));
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
        when(client.search(Mockito.any())).thenReturn(getEESummaryResponse);
        SteelThreadSystemCheck test = new SteelThreadSystemCheck(client, ledger, "123", failureThresholdForTests);
        test.runSteelThreadCheckAsynchronously();
        verify(ledger, times(1)).recordSuccess();
    }

    @Test
    public void runSteelThreadSadPath() {
        SteelThreadSystemCheck test = new SteelThreadSystemCheck(client, ledger, "123", failureThresholdForTests);
        when(client.search(Mockito.any())).thenThrow(
                new QueenElizabethClient.SearchFailed(
                        Query.forType(GetEESummaryResponse.class).build()));
        when(ledger.recordFailure()).thenReturn(failureThresholdForTests);
        test.runSteelThreadCheckAsynchronously();
        verify(ledger, times(1)).recordFailure();
    }
}
