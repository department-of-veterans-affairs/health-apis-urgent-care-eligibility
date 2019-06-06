package gov.va.api.health.urgentcare.service.queenelizabeth.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import gov.va.med.esr.webservices.jaxws.schemas.GetEESummaryResponse;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

public class RestQueenElizabethClientTests {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @Mock RestTemplate mockRestTemplate;

  private RestQueenElizabethClient qeClient;

  @Before
  public void _init() {
    MockitoAnnotations.initMocks(this);
    qeClient =
        new RestQueenElizabethClient("https://ee.va.gov:9334/getEESummary/", mockRestTemplate);
  }

  @Test
  public void badRequestFor400Status() {
    thrown.expect(QueenElizabethClient.BadRequest.class);
    mockErrorResponse(
        HttpClientErrorException.create(HttpStatus.BAD_REQUEST, "BadRequest", null, null, null));
    qeClient.search(query());
  }

  private void mockErrorResponse(Exception throne) {
    when(mockRestTemplate.exchange(
            Mockito.anyString(),
            Mockito.eq(HttpMethod.GET),
            Mockito.any(HttpEntity.class),
            Mockito.any(ParameterizedTypeReference.class)))
        .thenThrow(throne);
  }

  @Test
  public void notFoundFor404Status() {
    thrown.expect(QueenElizabethClient.NotFound.class);
    mockErrorResponse(
        HttpClientErrorException.create(HttpStatus.NOT_FOUND, "NotFound", null, null, null));
    qeClient.search(query());
  }

  private Query<GetEESummaryResponse> query() {
    return Query.forType(GetEESummaryResponse.class).id("1010101010V666666").build();
  }

  @Test
  public void searchFailedForOtherStatus() {
    thrown.expect(QueenElizabethClient.SearchFailed.class);
    mockErrorResponse(
        HttpServerErrorException.create(
            HttpStatus.INTERNAL_SERVER_ERROR, "SearchFailed", null, null, null));
    qeClient.search(query());
  }

  @Test
  public void validResponseFor200Status() {
    GetEESummaryResponse eeSummaryResponse = new GetEESummaryResponse();
    ResponseEntity<GetEESummaryResponse> response = mock(ResponseEntity.class);
    when(response.getStatusCode()).thenReturn(HttpStatus.OK);
    when(response.getBody()).thenReturn(eeSummaryResponse);
    when(mockRestTemplate.exchange(
            Mockito.anyString(),
            Mockito.eq(HttpMethod.GET),
            Mockito.any(HttpEntity.class),
            Mockito.any(ParameterizedTypeReference.class)))
        .thenReturn(response);
    GetEESummaryResponse actual = qeClient.search(query());
    assertThat(actual).isSameAs(eeSummaryResponse);
    query().hashCode();
    query().equals(query());
  }
}
