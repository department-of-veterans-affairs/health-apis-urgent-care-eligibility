package gov.va.api.health.urgentcare.api.swaggerexamples;

import static java.util.Arrays.asList;

import gov.va.api.health.urgentcare.api.bundle.AbstractBundle.BundleType;
import gov.va.api.health.urgentcare.api.bundle.AbstractEntry.Search;
import gov.va.api.health.urgentcare.api.bundle.AbstractEntry.SearchMode;
import gov.va.api.health.urgentcare.api.bundle.BundleLink;
import gov.va.api.health.urgentcare.api.bundle.BundleLink.LinkRelation;
import gov.va.api.health.urgentcare.api.datatypes.CodeableConcept;
import gov.va.api.health.urgentcare.api.datatypes.Period;
import gov.va.api.health.urgentcare.api.elements.Reference;
import gov.va.api.health.urgentcare.api.resources.Coverage;
import gov.va.api.health.urgentcare.api.resources.Coverage.Bundle;
import gov.va.api.health.urgentcare.api.resources.Coverage.CoverageClass;
import gov.va.api.health.urgentcare.api.resources.Coverage.Entry;
import gov.va.api.health.urgentcare.api.resources.Coverage.Status;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SwaggerCoverage {
  static final Bundle SWAGGER_EXAMPLE_COVERAGE_BUNDLE =
      Bundle.builder()
          .resourceType("Bundle")
          .type(BundleType.searchset)
          .total(String.valueOf(1))
          .link(
              asList(
                  BundleLink.builder()
                      .relation(LinkRelation.self)
                      .url(
                          "https://dev-api.va.gov/services/argonaut/v0/Coverage?patient=1017283148V813263&page=1&_count=15")
                      .build(),
                  BundleLink.builder()
                      .relation(LinkRelation.self)
                      .url(
                          "https://dev-api.va.gov/services/argonaut/v0/Coverage?patient=1017283148V813263&page=1&_count=15")
                      .build(),
                  BundleLink.builder()
                      .relation(LinkRelation.self)
                      .url(
                          "https://dev-api.va.gov/services/argonaut/v0/Coverage?patient=1017283148V813263&page=1&_count=15")
                      .build()))
          .entry(
              asList(
                  Entry.builder()
                      .fullUrl(
                          "https://dev-api.va.gov/services/argonaut/v0/Coverage/1008547368V529417")
                      .resource(
                          Coverage.builder()
                              .status(Status.active)
                              .coverageClass(
                                  asList(
                                      CoverageClass.builder()
                                          .type(
                                              CodeableConcept.builder()
                                                  .text(
                                                      "Mileage eligibility for the Veterans Choice Program")
                                                  .build())
                                          .value("M")
                                          .build()))
                              .beneficiary(
                                  Reference.builder().reference("1008547368V529417").build())
                              .period(
                                  Period.builder().start("2019-02-21T23:44:32.000-06:00").build())
                              .build())
                      .search(Search.builder().mode(SearchMode.match).build())
                      .build()))
          .build();
}
