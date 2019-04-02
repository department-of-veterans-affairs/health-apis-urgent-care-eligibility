package gov.va.api.health.urgentcare.service.controller.coverageeligibilityresponse;

import static gov.va.api.health.urgentcare.service.controller.Transformers.allBlank;
import static gov.va.api.health.urgentcare.service.controller.Transformers.asDateTimeString;
import static gov.va.api.health.urgentcare.service.controller.Transformers.convertAll;
import static gov.va.api.health.urgentcare.service.controller.Transformers.ifPresent;
import static gov.va.api.health.urgentcare.service.controller.Transformers.isBlank;
import static java.util.Collections.singletonList;

import gov.va.api.health.urgentcare.api.datatypes.Identifier;
import gov.va.api.health.urgentcare.api.datatypes.Period;
import gov.va.api.health.urgentcare.api.elements.Narrative;
import gov.va.api.health.urgentcare.api.elements.Narrative.NarrativeStatus;
import gov.va.api.health.urgentcare.api.elements.Reference;
import gov.va.api.health.urgentcare.api.resources.CoverageEligibilityResponse;
import gov.va.api.health.urgentcare.api.resources.CoverageEligibilityResponse.Insurance;
import gov.va.api.health.urgentcare.api.resources.CoverageEligibilityResponse.Outcome;
import gov.va.api.health.urgentcare.api.resources.CoverageEligibilityResponse.Purpose;
import gov.va.api.health.urgentcare.api.resources.CoverageEligibilityResponse.Status;
import gov.va.api.health.urgentcare.service.controller.coverageeligibilityresponse.CoverageEligibilityResponseController.Transformer;
import gov.va.med.esr.webservices.jaxws.schemas.EeSummary;
import gov.va.med.esr.webservices.jaxws.schemas.GetEESummaryResponse;
import gov.va.med.esr.webservices.jaxws.schemas.VceEligibilityCollection;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.stereotype.Service;

@Service
public class CoverageEligibilityResponseTransformer implements Transformer {

  @Override
  public CoverageEligibilityResponse apply(GetEESummaryResponse eeSummaryResponse) {
    return coverageEligibilityResponse(eeSummaryResponse);
  }

  Period benefitPeriod(XMLGregorianCalendar dateTime) {
    return Period.builder().start(asDateTimeString(dateTime)).build();
  }

  Reference coverage(String code, String description) {
    if (allBlank(code, description)) {
      return null;
    }
    if (isBlank(code)) {
      return Reference.builder().display(description).build();
    }
    if (isBlank(description)) {
      return Reference.builder().display(code).build();
    }
    return Reference.builder().display(code + " - " + description).build();
  }

  private CoverageEligibilityResponse coverageEligibilityResponse(GetEESummaryResponse source) {
    return CoverageEligibilityResponse.builder()
        .resourceType("CoverageEligibilityResponse")
        .text(text())
        .identifier(identifier())
        .status(Status.active)
        .purpose(singletonList(Purpose.discovery))
        .patient(Reference.builder().display("Patient/").build())
        .created(asDateTimeString(source.getInvocationDate()))
        .request(
            Reference.builder()
                .display("[Devise display text for notional request without resource reference]")
                .build())
        .outcome(Outcome.complete)
        .insurer(Reference.builder().display("Veterans Health Administration").build())
        .insurance(insurances(source.getSummary()))
        .build();
  }

  List<Identifier> identifier() {
    return singletonList(
        Identifier.builder()
            .system("http://www.va.gov/FHIR/R4/coverageeligibilityresponse")
            .value("881234")
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
                .coverage(
                    coverage(eligibilityInfo.getVceCode(), eligibilityInfo.getVceDescription()))
                .benefitPeriod(benefitPeriod(eligibilityInfo.getVceEffectiveDate()))
                .build());
  }

  Narrative text() {
    return Narrative.builder()
        .status(NarrativeStatus.generated)
        .div(
            "<div xmlns=\"http://www.w3.org/1999/xhtml\">A human-readable rendering of the CoverageEligibilityResponse.</div>")
        .build();
  }
}
