package gov.va.api.health.urgentcare.service.controller.coverageeligibilityresponse;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

import gov.va.api.health.urgentcare.api.datatypes.CodeableConcept;
import gov.va.api.health.urgentcare.api.datatypes.Coding;
import gov.va.api.health.urgentcare.api.datatypes.Identifier;
import gov.va.api.health.urgentcare.api.datatypes.Period;
import gov.va.api.health.urgentcare.api.elements.Narrative;
import gov.va.api.health.urgentcare.api.elements.Narrative.NarrativeStatus;
import gov.va.api.health.urgentcare.api.elements.Reference;
import gov.va.api.health.urgentcare.api.resources.CoverageEligibilityResponse;
import gov.va.api.health.urgentcare.api.resources.CoverageEligibilityResponse.Insurance;
import gov.va.api.health.urgentcare.api.resources.CoverageEligibilityResponse.Item;
import gov.va.api.health.urgentcare.api.resources.CoverageEligibilityResponse.Outcome;
import gov.va.api.health.urgentcare.api.resources.CoverageEligibilityResponse.Purpose;
import gov.va.api.health.urgentcare.api.resources.CoverageEligibilityResponse.Status;
import gov.va.api.health.urgentcare.service.controller.GetEeSummaryResponseTheRemix;
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

public class CoverageEligibilityTransformerTest {

  private final EeSampleData ee = new EeSampleData();

  private final Expected expected = new Expected();

  CoverageEligibilityResponseTransformer tx = new CoverageEligibilityResponseTransformer();

  @Test
  public void category() {
    assertThat(tx.category(ee.eligibility())).isEqualTo(expected.category());
    assertThat(tx.category(null)).isNull();
    assertThat(tx.category(new VceEligibilityInfo())).isNull();
  }

  @Test
  public void categoryCoding() {
    assertThat(tx.categoryCoding(ee.eligibility())).isEqualTo(expected.categoryCodings());
    assertThat(tx.categoryCoding(null)).isNull();
    assertThat(tx.categoryCoding(new VceEligibilityInfo())).isNull();
  }

  @Test
  public void coverageEligibilityResponse() {
    assertThat(tx.apply(ee.coverageEligibilityResponse()))
        .isEqualTo(expected.coverageEligibilityResponse());
  }

  @Test
  public void insurace() {
    EeSummary sampleEeSummary = new EeSummary();
    assertThat(tx.insurances(ee.eeSummary())).isEqualTo(expected.insurances());
    assertThat(tx.insurances(null)).isNull();
    assertThat(tx.insurances(sampleEeSummary)).isNull();
    sampleEeSummary.setCommunityCareEligibilityInfo(new CommunityCareEligibilityInfo());
    assertThat(tx.insurances(sampleEeSummary)).isNull();
    sampleEeSummary
        .getCommunityCareEligibilityInfo()
        .setEligibilities(new VceEligibilityCollection());
    assertThat(tx.insurances(sampleEeSummary)).isNull();
  }

  @Test
  public void item() {
    assertThat(tx.item(ee.eligibility())).isEqualTo(expected.items());
    assertThat(tx.item(null)).isNull();
    assertThat(tx.item(new VceEligibilityInfo())).isNull();
  }

  private static class EeSampleData {

    private DatatypeFactory datatypeFactory;

    @SneakyThrows
    private EeSampleData() {
      datatypeFactory = DatatypeFactory.newInstance();
    }

    private CommunityCareEligibilityInfo communityCareEligibilityInfo() {
      CommunityCareEligibilityInfo communityCareEligibilityInfo =
          new CommunityCareEligibilityInfo();
      communityCareEligibilityInfo.setEligibilities(eligibilities());
      return communityCareEligibilityInfo;
    }

    private GetEeSummaryResponseTheRemix coverageEligibilityResponse() {
      GetEESummaryResponse sampleCoverageEligibilityResponse = new GetEESummaryResponse();
      sampleCoverageEligibilityResponse.setSummary(eeSummary());
      sampleCoverageEligibilityResponse.setInvocationDate(dateTime());
      GetEeSummaryResponseTheRemix theRemix =
          new GetEeSummaryResponseTheRemix("123456789", sampleCoverageEligibilityResponse);
      return theRemix;
    }

    private XMLGregorianCalendar dateTime() {
      XMLGregorianCalendar gregorianCalendar = datatypeFactory.newXMLGregorianCalendar();
      gregorianCalendar.setYear(2018);
      gregorianCalendar.setMonth(11);
      gregorianCalendar.setDay(7);
      return gregorianCalendar;
    }

    private EeSummary eeSummary() {
      EeSummary eeSummary = new EeSummary();
      eeSummary.setCommunityCareEligibilityInfo(communityCareEligibilityInfo());
      return eeSummary;
    }

    private VceEligibilityCollection eligibilities() {
      VceEligibilityCollection eligibilities = new VceEligibilityCollection();
      eligibilities.getEligibility().add(eligibility());
      eligibilities.getEligibility().add(eligibility());
      return eligibilities;
    }

    private VceEligibilityInfo eligibility() {
      VceEligibilityInfo eligibility = new VceEligibilityInfo();
      eligibility.setVceCode("B");
      eligibility.setVceDescription("basic");
      eligibility.setVceEffectiveDate(dateTime());
      return eligibility;
    }
  }

  private static class Expected {

    CodeableConcept category() {
      return CodeableConcept.builder().coding(categoryCodings()).build();
    }

    List<Coding> categoryCodings() {
      return singletonList(Coding.builder().code("B").display("basic").build());
    }

    Reference coverage() {
      return Reference.builder()
          .identifier(
              Identifier.builder()
                  .system("http://www.va.gov/identifiers/patients")
                  .id("PatientPlaceholder")
                  .build())
          .build();
    }

    CoverageEligibilityResponse coverageEligibilityResponse() {
      return CoverageEligibilityResponse.builder()
          .resourceType("CoverageEligibilityResponse")
          .text(text())
          .identifier(asList(identifier()))
          .status(Status.active)
          .purpose(asList(Purpose.discovery))
          .patient(patient())
          .created("2018-11-07")
          .request(request())
          .outcome(Outcome.complete)
          .insurer(insurer())
          .insurance(insurances())
          .build();
    }

    Identifier identifier() {
      return Identifier.builder()
          .system("http://www.va.gov/FHIR/R4/coverageeligibilityresponse")
          .value("881234")
          .build();
    }

    Insurance insurance() {
      return Insurance.builder()
          .coverage(coverage())
          .benefitPeriod(Period.builder().start("2018-11-07").build())
          .item(items())
          .build();
    }

    List<Insurance> insurances() {
      List<Insurance> insurances = new LinkedList<>();
      insurances.add(insurance());
      insurances.add(insurance());
      return insurances;
    }

    Reference insurer() {
      return Reference.builder().display("Veterans Health Administration").build();
    }

    List<Item> items() {
      return singletonList(Item.builder().category(category()).build());
    }

    Reference patient() {
      return Reference.builder().display("Patient/123456789").build();
    }

    Reference request() {
      return Reference.builder().display("Requested by [placeholder]").build();
    }

    Narrative text() {
      return Narrative.builder()
          .status(NarrativeStatus.generated)
          .div(
              "<div xmlns=\"http://www.w3.org/1999/xhtml\">A human-readable rendering of the CoverageEligibilityResponse.</div>")
          .build();
    }
  }
}
