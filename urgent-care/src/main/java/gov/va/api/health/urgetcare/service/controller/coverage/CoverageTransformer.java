package gov.va.api.health.urgetcare.service.controller.coverage;

import static gov.va.api.health.urgetcare.service.controller.Transformers.allBlank;
import static gov.va.api.health.urgetcare.service.controller.Transformers.asDateTimeString;
import static gov.va.api.health.urgetcare.service.controller.Transformers.convertAll;
import static gov.va.api.health.urgetcare.service.controller.Transformers.ifPresent;
import static java.util.Collections.singletonList;

import gov.va.api.health.urgentcare.api.datatypes.CodeableConcept;
import gov.va.api.health.urgentcare.api.datatypes.Coding;
import gov.va.api.health.urgentcare.api.datatypes.Period;
import gov.va.api.health.urgentcare.api.resources.Coverage;
import gov.va.api.health.urgentcare.api.resources.Coverage.CoverageClass;
import gov.va.api.health.urgentcare.api.resources.Coverage.Status;
import gov.va.api.health.urgetcare.service.controller.coverage.CoverageController.Transformer;
import gov.va.med.esr.webservices.jaxws.schemas.GetEESummaryResponse;
import gov.va.med.esr.webservices.jaxws.schemas.VceEligibilityCollection;
import gov.va.med.esr.webservices.jaxws.schemas.VceEligibilityInfo;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.stereotype.Service;

@Service
public class CoverageTransformer implements Transformer {

  @Override
  public Coverage apply(GetEESummaryResponse eeSummaryResponse) {
    return coverage(eeSummaryResponse);
  }

  CodeableConcept classType(VceEligibilityInfo source) {
    if (source == null || allBlank(source.getVceCode(), source.getVceDescription())) {
      return null;
    }
    return CodeableConcept.builder().coding(classTypeCodings(source)).build();
  }

  List<Coding> classTypeCodings(VceEligibilityInfo source) {
    return singletonList(
        Coding.builder().code(source.getVceCode()).display(source.getVceDescription()).build());
  }

  private Coverage coverage(GetEESummaryResponse source) {
    return Coverage.builder()
        .coverageClass(
            coverageClass(source.getSummary().getCommunityCareEligibilityInfo().getEligibilities()))
        .status(Status.active)
        .period(period(source.getInvocationDate()))
        .build();
  }

  List<CoverageClass> coverageClass(VceEligibilityCollection optionalSource) {
    if (optionalSource == null || optionalSource.getEligibility().isEmpty()) {
      return null;
    }
    return convertAll(
        ifPresent(optionalSource, VceEligibilityCollection::getEligibility),
        eligibilityInfo -> CoverageClass.builder().type(classType(eligibilityInfo)).build());
  }

  Period period(XMLGregorianCalendar source) {
    if (source == null
        || allBlank(
            source.getDay(),
            source.getEon(),
            source.getEonAndYear(),
            source.getFractionalSecond(),
            source.getHour(),
            source.getMillisecond(),
            source.getMinute(),
            source.getMonth(),
            source.getSecond(),
            source.getTimezone(),
            source.getXMLSchemaType(),
            source.getYear())) {
      return null;
    }
    return Period.builder().start(asDateTimeString(source)).build();
  }
}
