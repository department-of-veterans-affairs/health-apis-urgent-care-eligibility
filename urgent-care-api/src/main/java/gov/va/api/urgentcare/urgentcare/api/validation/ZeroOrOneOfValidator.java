package gov.va.api.urgentcare.urgentcare.api.validation;

public class ZeroOrOneOfValidator extends AbstractSetFieldCounter<ZeroOrOneOf> {

  @Override
  protected String[] fields() {
    return annotation.fields();
  }

  @Override
  protected boolean isNumberOfFieldsSetValid(int numberOfFieldsSet) {
    return numberOfFieldsSet <= 1;
  }
}
