package gov.va.api.health.urgentcare.service.controller;

import gov.va.med.esr.webservices.jaxws.schemas.GetEESummaryResponse;

public class GetEeSummaryResponseTheRemix {

  private String icn;

  private GetEESummaryResponse eeSummaryResponse;

  public GetEESummaryResponse getEeSummaryResponse() {
    return eeSummaryResponse;
  }

  public void setEeSummaryResponse(GetEESummaryResponse eeSummaryResponse) {
    this.eeSummaryResponse = eeSummaryResponse;
  }

  public String getIcn() {
    return icn;
  }

  public void setIcn(String icn) {
    this.icn = icn;
  }
}
