package gov.va.api.health.urgentcare.service.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import gov.va.api.health.autoconfig.configuration.JacksonConfig;
import gov.va.api.health.queenelizabeth.ee.QueenElizabethService;
import gov.va.api.health.queenelizabeth.ee.exceptions.MissingIcnValue;
import gov.va.api.health.queenelizabeth.ee.exceptions.RequestFailed;
import gov.va.api.health.queenelizabeth.ee.handlers.BaseFaultSoapHandler;
import gov.va.api.health.urgentcare.service.controller.coverageeligibilityresponse.CoverageEligibilityResponseController;
import gov.va.api.health.urgentcare.service.controller.coverageeligibilityresponse.CoverageEligibilityResponseController.Transformer;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.ExceptionHandlerMethodResolver;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

@SuppressWarnings("DefaultAnnotationParam")
@RunWith(Parameterized.class)
public class WebExceptionHandlerTest {

  @Parameter(0)
  public HttpStatus status;

  @Parameter(1)
  public Exception exception;

  @Mock HttpServletRequest request;

  @Mock QueenElizabethService queenElizabeth;

  @Mock Transformer tx;

  @Mock Bundler bundler;

  private CoverageEligibilityResponseController controller;

  private WebExceptionHandler exceptionHandler;

  @Parameterized.Parameters(name = "{index}:{0} - {1}")
  public static List<Object[]> parameters() {
    return Arrays.asList(
        test(
            HttpStatus.BAD_REQUEST, new MissingIcnValue(QueenElizabethService.MISSING_ICN_MESSAGE)),
        test(HttpStatus.BAD_REQUEST, new ConstraintViolationException(new HashSet<>())),
        test(
            HttpStatus.INTERNAL_SERVER_ERROR,
            new RequestFailed(BaseFaultSoapHandler.FAULT_UNKNOWN_MESSAGE)),
        test(HttpStatus.INTERNAL_SERVER_ERROR, new RuntimeException()));
  }

  private static Object[] test(HttpStatus status, Exception exception) {
    return new Object[] {status, exception};
  }

  @Before
  public void _init() {
    MockitoAnnotations.initMocks(this);
    controller = new CoverageEligibilityResponseController(tx, queenElizabeth, bundler);
    exceptionHandler = new WebExceptionHandler();
  }

  private ExceptionHandlerExceptionResolver createExceptionResolver() {
    ExceptionHandlerExceptionResolver exceptionResolver =
        new ExceptionHandlerExceptionResolver() {

          @Override
          protected ServletInvocableHandlerMethod getExceptionHandlerMethod(
              HandlerMethod handlerMethod, Exception ex) {
            Method method =
                new ExceptionHandlerMethodResolver(WebExceptionHandler.class).resolveMethod(ex);
            assertThat(method).isNotNull();
            return new ServletInvocableHandlerMethod(exceptionHandler, method);
          }
        };
    exceptionResolver
        .getMessageConverters()
        .add(new MappingJackson2HttpMessageConverter(JacksonConfig.createMapper()));
    exceptionResolver.afterPropertiesSet();
    return exceptionResolver;
  }

  @Test
  @SneakyThrows
  public void expectStatus() {
    when(queenElizabeth.getEeSummary("123456789")).thenThrow(exception);
    when(request.getRequestURI()).thenReturn("/CoverageEligibilityResponse?patient=123456789");
    MockMvc mvc =
        MockMvcBuilders.standaloneSetup(controller)
            .setHandlerExceptionResolvers(createExceptionResolver())
            .setMessageConverters()
            .build();
    /*
     * Actual:
     *
     * <pre>
     * {
     *  "id": "99ea1528-1579-40c3-a99e-4b86f948a503",
     *  "resourceType": "OperationOutcome",
     *  "text": {
     *    "status": "additional",
     *    "div": "<div>Failure: /api/CoverageEligibilityResponse</div>"
     * },
     * "issue": [
     *   {
     *       "severity": "fatal",
     *       "code": "not-found",
     *       "diagnostics": "Error: NotFound Timestamp:2019-04-04T22:43:12.709Z"
     *   }
     *  ]
     * }
     * </pre>
     */
    mvc.perform(get("/CoverageEligibilityResponse?patient=123456789"))
        .andExpect(status().is(status.value()))
        .andExpect(jsonPath("text.div", containsString("/CoverageEligibilityResponse")))
        .andExpect(
            jsonPath("issue[0].diagnostics", containsString(exception.getClass().getSimpleName())));
  }
}
