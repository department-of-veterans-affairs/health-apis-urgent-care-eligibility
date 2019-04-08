package gov.va.api.health.urgentcare.service.controller;

import gov.va.med.esr.webservices.jaxws.schemas.GetEESummaryResponse;

public class GetEeSummaryResponseTheRemix {

  String icn;

  GetEESummaryResponse eeSummaryResponse;

  public GetEeSummaryResponseTheRemix(
      String remixIcn, GetEESummaryResponse remixEeSummaryResponse) {
    icn = remixIcn;
    eeSummaryResponse = remixEeSummaryResponse;
  }

  public GetEESummaryResponse getEeSummaryResponse() {
    return eeSummaryResponse;
  }

  public String getIcn() {
    return icn;
  }
}
