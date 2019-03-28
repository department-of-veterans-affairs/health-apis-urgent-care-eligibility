package gov.va.api.health.urgentcare.service.healthcheck;

import static org.assertj.core.api.Assertions.assertThat;
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
  @Mock QueenElizabethClient client;

  @Before
  public void _init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void healthCheckHappyPath() {
    GetEESummaryResponse root = new GetEESummaryResponse();
    SteelThreadSystemCheck test = new SteelThreadSystemCheck(client, "123");
    when(client.search(Mockito.any())).thenReturn(root);
    assertThat(test.health().getStatus()).isEqualTo(Status.UP);
  }

  @Test
  public void healthCheckSadPath() {
    SteelThreadSystemCheck test = new SteelThreadSystemCheck(client, "123");
    when(client.search(Mockito.any()))
        .thenThrow(
            new QueenElizabethClient.SearchFailed(
                Query.forType(GetEESummaryResponse.class).id("1008547368V529417").build()));
    assertThat(test.health().getStatus()).isEqualTo(Status.DOWN);
  }
}
