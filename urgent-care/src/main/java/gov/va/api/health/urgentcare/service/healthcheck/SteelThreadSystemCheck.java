package gov.va.api.health.urgentcare.service.healthcheck;

import gov.va.api.health.urgentcare.service.queenelizabeth.client.QueenElizabethClient;
import gov.va.api.health.urgentcare.service.queenelizabeth.client.QueenElizabethClient.QueenElizabethServiceException;
import gov.va.api.health.urgentcare.service.queenelizabeth.client.Query;
import gov.va.med.esr.webservices.jaxws.schemas.GetEESummaryResponse;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

@AllArgsConstructor(onConstructor = @__({@Autowired}))
@Component
@Slf4j
public class SteelThreadSystemCheck implements HealthIndicator {
  private final QueenElizabethClient client;

  @Value("${health-check.id}")
  private final String id;

  @Override
  @SneakyThrows
  public Health health() {
    if ("skip".equals(id)) {
      return Health.up().withDetail("skipped", true).build();
    }
    try {
      client.search(query());
      return Health.up().build();
    } catch (HttpServerErrorException
        | HttpClientErrorException
        | ResourceAccessException
        | QueenElizabethServiceException e) {
      return Health.down()
          .withDetail("exception", e.getClass())
          .withDetail("message", e.getMessage())
          .build();
    } catch (Exception e) {
      log.error("Failed to complete health check.", e);
      throw e;
    }
  }

  private Query<GetEESummaryResponse> query() {
    return Query.forType(GetEESummaryResponse.class).id(id).build();
  }
}
