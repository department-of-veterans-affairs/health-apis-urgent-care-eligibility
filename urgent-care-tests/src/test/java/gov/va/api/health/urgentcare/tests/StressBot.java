package gov.va.api.health.urgentcare.tests;

import gov.va.api.health.sentinel.LabBot;
import gov.va.api.health.sentinel.LabBot.LabBotUserResult;
import gov.va.api.health.sentinel.LabBot.LabBotUserResult.LabBotUserResultBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

/** Bot with functionality for repetitive requests (e.g. load/stress testing) */
@Slf4j
@Builder
public class StressBot {

  private final int concurrentRequests;

  private final int maximumRuntime;

  @NotNull private final String configFile;

  private void awaitResults(ExecutorService ex, List<Future<?>> futures) {
    ex.shutdown();
    try {
      if (!ex.awaitTermination(maximumRuntime, TimeUnit.MINUTES)) {
        log.info("Maximum runtime has been exceeded; cancelling remaining tasks");
      }
    } catch (InterruptedException e) {
      log.error("Unexpected interruption while waiting for requests to complete", e);
      throw new IllegalStateException(e);
    }
    /*
     * Proceed when all tasks are complete or when X minutes have been exceeded.
     *
     * Attempt to cancel any remaining tasks and fail the test if any unexpected
     * exceptions are thrown.
     */
    int errors =
        futures
            .stream()
            .mapToInt(
                f -> {
                  try {
                    if (!f.isDone()) {
                      f.cancel(true);
                    }
                    f.get();
                    return 0;
                  } catch (CancellationException e) {
                    return 0;
                  } catch (Exception e) {
                    log.error(e.getMessage());
                    return 1;
                  }
                })
            .sum();
    if (errors > 0) {
      throw new AssertionError("Thread processing had " + errors + " unexpected errors");
    }
  }

  /**
   * Given request details, execute and return results.
   *
   * @param request The request to execute.
   * @return a list of results.
   */
  public List<LabBotUserResult> request(StressBotRequest request) {
    LabBot labBot =
        LabBot.builder()
            .userIds(request.userIds())
            .scopes(request.scopes())
            .configFile(configFile)
            .build();
    List<LabBotUserResult> tokens = labBot.tokens();
    for (LabBotUserResult token : tokens) {
      if (token.tokenExchange().isError()) {
        throw new AssertionError("Token exchange not successful for " + token.user().id());
      }
    }
    List<LabBotUserResult> results = new CopyOnWriteArrayList<>();
    List<Future<?>> futures =
        new ArrayList<>(tokens.size() * request.urls.size() * request.times());
    ExecutorService ex = Executors.newFixedThreadPool(concurrentRequests);
    for (LabBotUserResult token : tokens) {
      for (String url : request.urls) {
        for (int i = 0; i < request.times(); i++) {
          futures.add(
              ex.submit(
                  () -> {
                    LabBotUserResultBuilder result =
                        LabBotUserResult.builder()
                            .user(token.user())
                            .tokenExchange(token.tokenExchange());
                    try {
                      result.response(
                          labBot.request(
                              url.replace("{icn}", token.tokenExchange().patient()),
                              token.tokenExchange().accessToken()));
                    } catch (Exception e) {
                      log.error("Request failure: {}", e.getMessage(), e.getCause());
                      result.response(e.getClass().getName() + ": " + e.getMessage());
                    } finally {
                      results.add(result.build());
                    }
                  }));
        }
      }
    }
    awaitResults(ex, futures);
    return results;
  }

  @Value
  @Builder
  static class StressBotRequest {

    /** The user IDs for which to execute this request. */
    @NotNull private List<String> userIds;

    /** The scopes to use for this request. */
    @NotNull private List<String> scopes;

    /** The path to use for the requests, must contain {icn} to be replaced with the patient icn. */
    @Singular @NotEmpty private List<String> urls;

    /** The number of times to execute this request. */
    private int times;
  }
}
