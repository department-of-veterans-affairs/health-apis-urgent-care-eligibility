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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

@Service
@Slf4j
public class SteelThreadSystemCheck implements HealthIndicator {

    private final QueenElizabethClient client;

    private final SteelThreadSystemCheckLedger ledger;

    @Value("${health-check.id}")
    private final String id;

    private final int consecutiveFailureThreshold;

    /**
     * 'By hand' all args constructor is required to inject non-string values from our properties.
     *
     * @param consecutiveFailureThreshold - once consecutive failures meets or exceeds, report
     *     failures.
     */
    public SteelThreadSystemCheck(
            @Autowired QueenElizabethClient client,
            @Autowired SteelThreadSystemCheckLedger ledger,
            @Value("${health-check.medication-id") String id,
            @Value("${health-check.consecutive-failure-threshold}") int consecutiveFailureThreshold) {
        this.client = client;
        this.ledger = ledger;
        this.id = id;
        this.consecutiveFailureThreshold = consecutiveFailureThreshold;

    }

    @Override
    @SneakyThrows
    public Health health() {
        if ("skip".equals(id)) {
            return Health.up().withDetail("skipped", true).build();
        }

        int consecutiveFails = ledger.getConsecutiveFailureCount();

        if (consecutiveFails < consecutiveFailureThreshold) {
            return Health.up().build();
        }

        return Health.down().withDetail("failures", String.format("Error threshold of %d with %d consecutive failure(s).",
                consecutiveFailureThreshold, consecutiveFails)).build();
    }

    @Scheduled(
            fixedDelayString = "${health-check.read-frequency-ms}",
            initialDelayString = "${health-check.read-frequency-ms"
    )
    @SneakyThrows
    public void runSteelThreadCheckAsynchronously() {
        if ("skip".equals(id)) {
            return;
        }
        log.info("Performing health check.");
        try {
            client.search(query());
            ledger.recordSuccess();
        } catch (HttpServerErrorException
                | HttpClientErrorException
                | ResourceAccessException
                | QueenElizabethServiceException e) {
            int consecutiveFailures = ledger.recordFailure();
            log.error("Failed to complete health check. Failure count is " + consecutiveFailures);
        } catch (Exception e) {
            int consecutiveFailures = ledger.recordFailure();
            log.error("Failed to complete health check. Failure count is " + consecutiveFailures, e);
            throw e;
        }
    }

    private Query<GetEESummaryResponse> query() {
        return Query.forType(GetEESummaryResponse.class).id(id).build();
    }
}
