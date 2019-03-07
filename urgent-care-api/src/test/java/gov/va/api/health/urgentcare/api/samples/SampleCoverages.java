package gov.va.api.health.urgentcare.api.samples;

import static java.util.Collections.singletonList;

import gov.va.api.health.urgentcare.api.resources.Coverage;
import gov.va.api.health.urgentcare.api.resources.Coverage.CostToBeneficiary;
import gov.va.api.health.urgentcare.api.resources.Coverage.EncounterClass;
import gov.va.api.health.urgentcare.api.resources.Coverage.Exception;
import gov.va.api.health.urgentcare.api.resources.Coverage.Status;
import java.util.Arrays;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@NoArgsConstructor(staticName = "get")
public class SampleCoverages {

  @Delegate SampleDataTypes dataTypes = SampleDataTypes.get();

  public CostToBeneficiary costToBeneficiary() {
    return CostToBeneficiary.builder()
        .type(codeableConcept())
        .valueQuantity(simpleQuantity())
        .exception(singletonList(exception()))
        .build();
  }

  public Coverage coverage() {
    return Coverage.builder()
        .id("1324")
        .resourceType("Coverage")
        .meta(meta())
        .implicitRules("https://HelloRules.com")
        .language("Hello language")
        .text(narrative())
        .contained(singletonList(resource()))
        .extension(Arrays.asList(extension(), extension()))
        .modifierExtension(
            Arrays.asList(extension(), extensionWithQuantity(), extensionWithRatio()))
        .identifier(singletonList(identifier()))
        .status(Status.active)
        .type(codeableConcept())
        .policyHolder(reference())
        .subscriber(reference())
        .subscriberId("Hello subscriberId")
        .beneficiary(reference())
        .dependent("Hello dependent")
        .relationship(codeableConcept())
        .period(period())
        .payor(singletonList(reference()))
        .encounterClass(singletonList(encounterClass()))
        .order("1")
        .network("Hello network")
        .costToBeneficiary(singletonList(costToBeneficiary()))
        .subrogation("true")
        .contract(singletonList(reference()))
        .build();
  }

  public EncounterClass encounterClass() {
    return EncounterClass.builder()
        .type(codeableConcept())
        .value("Hello value")
        .name("Hello name")
        .build();
  }

  public Exception exception() {
    return Exception.builder().type(codeableConcept()).period(period()).build();
  }
}
