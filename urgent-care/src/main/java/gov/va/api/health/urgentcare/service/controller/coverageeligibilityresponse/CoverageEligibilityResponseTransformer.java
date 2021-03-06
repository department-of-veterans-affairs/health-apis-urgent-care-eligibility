package gov.va.api.health.urgentcare.service.controller.coverageeligibilityresponse;

import static gov.va.api.health.urgentcare.service.controller.Transformers.allBlank;
import static gov.va.api.health.urgentcare.service.controller.Transformers.asDateTimeString;
import static gov.va.api.health.urgentcare.service.controller.Transformers.convertAll;
import static gov.va.api.health.urgentcare.service.controller.Transformers.ifPresent;
import static java.util.Collections.singletonList;

import gov.va.api.health.r4.api.DataAbsentReason;
import gov.va.api.health.r4.api.datatypes.CodeableConcept;
import gov.va.api.health.r4.api.datatypes.Coding;
import gov.va.api.health.r4.api.datatypes.Identifier;
import gov.va.api.health.r4.api.datatypes.Period;
import gov.va.api.health.r4.api.elements.Narrative;
import gov.va.api.health.r4.api.elements.Narrative.NarrativeStatus;
import gov.va.api.health.r4.api.elements.Reference;
import gov.va.api.health.r4.api.resources.CoverageEligibilityResponse;
import gov.va.api.health.r4.api.resources.CoverageEligibilityResponse.Insurance;
import gov.va.api.health.r4.api.resources.CoverageEligibilityResponse.Item;
import gov.va.api.health.r4.api.resources.CoverageEligibilityResponse.Outcome;
import gov.va.api.health.r4.api.resources.CoverageEligibilityResponse.Purpose;
import gov.va.api.health.r4.api.resources.CoverageEligibilityResponse.Status;
import gov.va.api.health.urgentcare.service.controller.GetEeSummaryResponseTheRemix;
import gov.va.api.health.urgentcare.service.controller.coverageeligibilityresponse.CoverageEligibilityResponseController.Transformer;
import gov.va.med.esr.webservices.jaxws.schemas.EeSummary;
import gov.va.med.esr.webservices.jaxws.schemas.VceEligibilityCollection;
import gov.va.med.esr.webservices.jaxws.schemas.VceEligibilityInfo;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.stereotype.Service;

@Service
public class CoverageEligibilityResponseTransformer implements Transformer {
  @Override
  public CoverageEligibilityResponse apply(GetEeSummaryResponseTheRemix theRemix) {
    return coverageEligibilityResponse(theRemix);
  }

  Period benefitPeriod(XMLGregorianCalendar dateTime) {
    return Period.builder().start(asDateTimeString(dateTime)).build();
  }

  CodeableConcept category(VceEligibilityInfo source) {
    if (source == null) {
      return null;
    }
    if (allBlank(source.getVceDescription(), source.getVceCode())) {
      return null;
    }
    return CodeableConcept.builder().coding(categoryCoding(source)).build();
  }

  List<Coding> categoryCoding(VceEligibilityInfo source) {
    if (source == null) {
      return null;
    }
    if (allBlank(source.getVceDescription(), source.getVceCode())) {
      return null;
    }
    return singletonList(
        Coding.builder()
            .system(null)
            .code(source.getVceCode())
            .display(source.getVceDescription())
            .build());
  }

  private CoverageEligibilityResponse coverageEligibilityResponse(
      GetEeSummaryResponseTheRemix source) {
    return CoverageEligibilityResponse.builder()
        .resourceType("CoverageEligibilityResponse")
        .text(text())
        .id(source.getIcn())
        .identifier(identifier(source.getIcn()))
        .status(Status.active)
        .purpose(singletonList(Purpose.discovery))
        .patient(Reference.builder().display("Patient/" + source.getIcn()).build())
        .created(asDateTimeString(source.getEeSummaryResponse().getInvocationDate()) + ".000-06:00")
        .request(null)
        ._request(DataAbsentReason.of(DataAbsentReason.Reason.unsupported))
        .outcome(Outcome.complete)
        .insurer(Reference.builder().display("Veterans Administration").build())
        .insurance(insurances(source.getEeSummaryResponse().getSummary()))
        .build();
  }

  List<Identifier> identifier(String icn) {
    return singletonList(
        Identifier.builder()
            .system("http://www.va.gov/FHIR/R4/coverageeligibilityresponse")
            .value(icn)
            .build());
  }

  List<Insurance> insurances(EeSummary source) {
    if (source == null
        || source.getCommunityCareEligibilityInfo() == null
        || source.getCommunityCareEligibilityInfo().getEligibilities() == null) {
      return null;
    }
    VceEligibilityCollection eligibilities =
        source.getCommunityCareEligibilityInfo().getEligibilities();
    if (eligibilities.getEligibility().isEmpty()) {
      return null;
    }
    return convertAll(
        ifPresent(eligibilities, VceEligibilityCollection::getEligibility),
        eligibilityInfo ->
            Insurance.builder()
                .coverage(null)
                ._coverage(DataAbsentReason.of(DataAbsentReason.Reason.unsupported))
                .benefitPeriod(benefitPeriod(eligibilityInfo.getVceEffectiveDate()))
                .item(item(eligibilityInfo))
                .build());
  }

  List<Item> item(VceEligibilityInfo source) {
    if (source == null) {
      return null;
    }
    if (allBlank(source.getVceCode(), source.getVceDescription())
        && source.getVceEffectiveDate() == null) {
      return null;
    }
    return singletonList(Item.builder().category(category(source)).build());
  }

  Narrative text() {
    return Narrative.builder()
        .status(NarrativeStatus.generated)
        .div(
            "<div xmlns=\"http://www.w3.org/1999/xhtml\">A human-readable rendering of the CoverageEligibilityResponse.</div>")
        .build();
  }
}
