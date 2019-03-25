package gov.va.api.health.urgentcare.api.swaggerexamples;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

import gov.va.api.health.urgentcare.api.bundle.AbstractBundle.BundleType;
import gov.va.api.health.urgentcare.api.bundle.BundleLink;
import gov.va.api.health.urgentcare.api.bundle.BundleLink.LinkRelation;
import gov.va.api.health.urgentcare.api.datatypes.CodeableConcept;
import gov.va.api.health.urgentcare.api.datatypes.Coding;
import gov.va.api.health.urgentcare.api.datatypes.Period;
import gov.va.api.health.urgentcare.api.elements.Reference;
import gov.va.api.health.urgentcare.api.resources.CoverageEligibilityResponse;
import gov.va.api.health.urgentcare.api.resources.CoverageEligibilityResponse.Benefit;
import gov.va.api.health.urgentcare.api.resources.CoverageEligibilityResponse.Bundle;
import gov.va.api.health.urgentcare.api.resources.CoverageEligibilityResponse.CoverageEligibilityResponseError;
import gov.va.api.health.urgentcare.api.resources.CoverageEligibilityResponse.Entry;
import gov.va.api.health.urgentcare.api.resources.CoverageEligibilityResponse.Insurance;
import gov.va.api.health.urgentcare.api.resources.CoverageEligibilityResponse.Item;
import gov.va.api.health.urgentcare.api.resources.CoverageEligibilityResponse.Outcome;
import gov.va.api.health.urgentcare.api.resources.CoverageEligibilityResponse.Purpose;
import gov.va.api.health.urgentcare.api.resources.CoverageEligibilityResponse.Status;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SwaggerCoverageEligibilityResponse {
  static final Bundle SWAGGER_EXAMPLE_COVERAGEELIGIBILITYRESPONSE_BUNDLE =
      Bundle.builder()
          .resourceType("Bundle")
          .type(BundleType.searchset)
          .total(String.valueOf(1))
          .link(
              asList(
                  BundleLink.builder()
                      .relation(LinkRelation.self)
                      .url(
                          "https://dev-api.va.gov/services/argonaut/v0/CoverageEligibilityResponse?patient=1017283148V813263&page=1&_count=15")
                      .build(),
                  BundleLink.builder()
                      .relation(LinkRelation.self)
                      .url(
                          "https://dev-api.va.gov/services/argonaut/v0/CoverageEligibilityResponse?patient=1017283148V813263&page=1&_count=15")
                      .build(),
                  BundleLink.builder()
                      .relation(LinkRelation.self)
                      .url(
                          "https://dev-api.va.gov/services/argonaut/v0/CoverageEligibilityResponse?patient=1017283148V813263&page=1&_count=15")
                      .build()))
          .entry(
              asList(
                  Entry.builder()
                      .fullUrl(
                          "https://dev-api.va.gov/services/argonaut/v0/CoverageEligibilityResponse/1008547368V529417")
                      .resource(
                          CoverageEligibilityResponse.builder()
                              .status(Status.active)
                              .purpose(singletonList(Purpose.benefits))
                              .patient(
                                  Reference.builder()
                                      .reference("1008547368V529417")
                                      .display("Patient")
                                      .build())
                              .created("2019-02-21T23:44:32.000-06:00")
                              .request(
                                  Reference.builder()
                                      .reference("DATA ABSENT REASON")
                                      .display("CoverageEligibilityRequest")
                                      .build())
                              .outcome(Outcome.complete)
                              .insurer(
                                  Reference.builder()
                                      .reference("1008547368V529417")
                                      .display("Organization")
                                      .build())
                              .insurance(
                                  singletonList(
                                      Insurance.builder()
                                          .coverage(
                                              Reference.builder()
                                                  .reference("1008547368V529417")
                                                  .display("Coverage")
                                                  .build())
                                          .inforce("true")
                                          .benefitPeriod(
                                              Period.builder()
                                                  .start("2019-02-21T23:44:32.000-06:00")
                                                  .end("2019-02-22T23:44:32.000-06:00")
                                                  .build())
                                          .item(
                                              singletonList(
                                                  Item.builder()
                                                      .benefit(
                                                          singletonList(
                                                              Benefit.builder()
                                                                  .type(
                                                                      CodeableConcept.builder()
                                                                          .coding(
                                                                              singletonList(
                                                                                  Coding.builder()
                                                                                      .code(
                                                                                          "benefit")
                                                                                      .display(
                                                                                          "Benefit")
                                                                                      .build()))
                                                                          .build())
                                                                  .build()))
                                                      .build()))
                                          .build()))
                              .error(
                                  singletonList(
                                      CoverageEligibilityResponseError.builder()
                                          .code(
                                              CodeableConcept.builder()
                                                  .coding(
                                                      singletonList(
                                                          Coding.builder()
                                                              .code("a001")
                                                              .display("Missing Identifier")
                                                              .build()))
                                                  .build())
                                          .build()))
                              .build())
                      .build()))
          .build();
}
