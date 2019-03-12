package gov.va.api.health.eeclient.controller;

import gov.va.api.health.eeclient.ee.Eligibilities;
import gov.va.api.health.eeclient.ee.SoapMessageGenerator;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/api")
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class EeClientV1ApiController {

    private final Eligibilities eligibilities;

    /** Implementation of /v1/eligibilityandenrollment -- ee-api-v1.yaml*/
    @RequestMapping(
            value = "/v1/eligibilityandenrollment",
            produces = {
                    "application/xml",
                    "application/json"
            },
            method = RequestMethod.GET
    )
    @SneakyThrows
    public ResponseEntity<String> requestEligibility(
            @Valid @PathVariable("id") String id) {
        String xml = eligibilities.request(
                SoapMessageGenerator.builder()
                        .id(id)
                        .build());
        return ResponseEntity.ok().body(xml);
    }
}
