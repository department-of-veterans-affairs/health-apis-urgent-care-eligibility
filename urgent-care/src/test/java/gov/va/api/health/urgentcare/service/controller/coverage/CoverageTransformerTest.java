package gov.va.api.health.urgentcare.service.controller.coverage;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

import gov.va.api.health.urgentcare.api.datatypes.CodeableConcept;
import gov.va.api.health.urgentcare.api.datatypes.Coding;
import gov.va.api.health.urgentcare.api.datatypes.Period;
import gov.va.api.health.urgentcare.api.resources.Coverage;
import gov.va.api.health.urgentcare.api.resources.Coverage.CoverageClass;
import gov.va.api.health.urgentcare.api.resources.Coverage.Status;
import gov.va.med.esr.webservices.jaxws.schemas.CommunityCareEligibilityInfo;
import gov.va.med.esr.webservices.jaxws.schemas.EeSummary;
import gov.va.med.esr.webservices.jaxws.schemas.GetEESummaryResponse;
import gov.va.med.esr.webservices.jaxws.schemas.VceEligibilityCollection;
import gov.va.med.esr.webservices.jaxws.schemas.VceEligibilityInfo;
import java.util.LinkedList;
import java.util.List;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import lombok.SneakyThrows;
import org.junit.Test;

public class CoverageTransformerTest {

  private final CoverageTransformer tx = new CoverageTransformer();

  private final EeSampleData ee = new EeSampleData();

  private final Expected expected = new Expected();

  @Test
  public void classType() {
    assertThat(tx.classType(ee.eligibility())).isEqualTo(expected.classType());
    assertThat(tx.classType(null)).isNull();
    assertThat(tx.classType(new VceEligibilityInfo())).isNull();
  }

  @Test
  public void classTypeCoding() {
    assertThat(tx.classTypeCodings(ee.eligibility())).isEqualTo(expected.classTypeCoding());
    assertThat(tx.classTypeCodings(null)).isNull();
    assertThat(tx.classTypeCodings(new VceEligibilityInfo())).isNull();
  }

  @Test
  public void coverage() {
    assertThat(tx.apply(ee.coverage())).isEqualTo(expected.coverage());
  }

  @Test
  public void coverageClass() {
    assertThat(tx.coverageClass(ee.communityCareEligibilityInfo().getEligibilities()))
        .isEqualTo(expected.coverageClasses());
    assertThat(tx.coverageClass(new VceEligibilityCollection())).isNull();
    assertThat(tx.coverageClass(null)).isNull();
  }

  @Test
  public void period() {
    assertThat(tx.period(ee.invocationDate())).isEqualTo(expected.period());
    assertThat(tx.period(null)).isNull();
  }

  private static class EeSampleData {

    private DatatypeFactory datatypeFactory;

    @SneakyThrows
    private EeSampleData() {
      datatypeFactory = DatatypeFactory.newInstance();
    }

    CommunityCareEligibilityInfo communityCareEligibilityInfo() {
      CommunityCareEligibilityInfo communityCareEligibility = new CommunityCareEligibilityInfo();
      communityCareEligibility.setEligibilities(eligibilities());
      return communityCareEligibility;
    }

    GetEESummaryResponse coverage() {
      GetEESummaryResponse summaryResponse = new GetEESummaryResponse();
      summaryResponse.setSummary(eeSummary());
      summaryResponse.setInvocationDate(invocationDate());
      return summaryResponse;
    }

    EeSummary eeSummary() {
      EeSummary eeSummary = new EeSummary();
      eeSummary.setCommunityCareEligibilityInfo(communityCareEligibilityInfo());
      return eeSummary;
    }

    VceEligibilityCollection eligibilities() {
      VceEligibilityCollection eligibilities = new VceEligibilityCollection();
      eligibilities.getEligibility().add(eligibility());
      eligibilities.getEligibility().add(eligibility());
      return eligibilities;
    }

    VceEligibilityInfo eligibility() {
      VceEligibilityInfo eligibility = new VceEligibilityInfo();
      eligibility.setVceCode("M");
      eligibility.setVceDescription("Mileage eligibility for the Veterans Choice Program");
      return eligibility;
    }

    XMLGregorianCalendar invocationDate() {
      XMLGregorianCalendar gregorianCalendar = datatypeFactory.newXMLGregorianCalendar();
      gregorianCalendar.setYear(2018);
      gregorianCalendar.setMonth(11);
      gregorianCalendar.setDay(7);
      return gregorianCalendar;
    }
  }

  private static class Expected {

    CodeableConcept classType() {
      return CodeableConcept.builder().coding(classTypeCoding()).build();
    }

    List<Coding> classTypeCoding() {
      return singletonList(Coding.builder().code("plan").build());
    }

    Coverage coverage() {
      return Coverage.builder()
          .coverageClass(coverageClasses())
          .period(period())
          .status(Status.active)
          .build();
    }

    CoverageClass coverageClass() {
      return CoverageClass.builder()
          .type(classType())
          .value("M")
          .name("Mileage eligibility for the Veterans Choice Program")
          .build();
    }

    List<CoverageClass> coverageClasses() {
      List<CoverageClass> coverageClasses = new LinkedList<>();
      coverageClasses.add(coverageClass());
      coverageClasses.add(coverageClass());
      return coverageClasses;
    }

    Period period() {
      return Period.builder().start("2018-11-07").build();
    }
  }
}
