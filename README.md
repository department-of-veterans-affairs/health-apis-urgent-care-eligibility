# health-apis-urgent-care-eligibility

This API is a [Spring Boot](https://spring.io/projects/spring-boot) microservice that returns all eligibilities of a specific veteran.  This information is returned as a FHIR R4 [CoverageEligibilityResponse](https://www.hl7.org/fhir/r4/coverageeligibilityresponse.html) resource.

The Urgent Care Eligibility API uses the `hand-of-queen-elizabeth QueenElizabethService` to call the Eligibility and Enrollment `getEESummary` SOAP Service for patient a desired ICN.  This service call returns an instance of `GetEESummaryResponse` whose data is transformed by the `CoverageEligibilityResponseTransformer` to populate a `CoverageEligibilityResponse` resource.  A `GetEESummaryResponse` object encapsulates XML returned from E&E.  An example of XML that might be unmarshalled into a `GetEESummaryResponse` object returned by the `QueenElizabethService` is as follows:

```
<communityCareEligibilityInfo>
   <eligibilities>
      <eligibility>
         <vceDescription>Urgent Care</vceDescription>
         <vceEffectiveDate>2019-04-27T21:06:00.000-05:00</vceEffectiveDate>
         <vceCode>U</vceCode>
      </eligibility>
   </eligibilities>
</communityCareEligibilityInfo>
```



It is possible to get multiple eligibilities back from E&E for a veteran.  All possible eligibilities that can be returned are listed below:

G	Grandfathered  
N	State No Full-Service VA  
U	Urgent Care  
B	Basic  
H	Hardship  
X	Ineligible  



Sample Requests:

```
curl -H "Authorization: Bearer fakeToken" https://example.com/services/fhir/v0/r4/CoverageEligibilityResponse?patient=1008679665V880686
```

If running locally using SOAPUI or MOCKEE:
```
localhost:9090/CoverageEligibilityResponse?patient=1008679665V880686
```


Sample Response:

```
 {
    "resourceType": "Bundle",
    "type": "searchset",
    "total": "1",
    "link": [
        {
            "relation": "first",
            "url": "https://example.com/services/fhir/v0/r4/CoverageEligibilityResponse?patient=1008679665V880686&page=1&_count=15"
        },
        {
            "relation": "self",
            "url": "https://example.com/services/fhir/v0/r4/CoverageEligibilityResponse?patient=1008679665V880686&page=1&_count=15"
        },
        {
            "relation": "last",
            "url": "https://example.com/services/fhir/v0/r4/CoverageEligibilityResponse?patient=1008679665V880686&page=1&_count=15"
        }
    ],
    "entry": [
        {
            "resource": {
                "id": "1008679665V880686",
                "resourceType": "CoverageEligibilityResponse",
                "text": {
                    "status": "generated",
                    "div": "<div xmlns=\"http://www.w3.org/1999/xhtml\">A human-readable rendering of the CoverageEligibilityResponse.</div>"
                },
                "identifier": [
                    {
                        "system": "http://www.va.gov/FHIR/R4/coverageeligibilityresponse",
                        "value": "1008679665V880686"
                    }
                ],
                "status": "active",
                "purpose": [
                    "discovery"
                ],
                "patient": {
                    "display": "Patient/1008679665V880686"
                },
                "created": "2019-06-05T08:26:24.000-06:00",
                "_request": {
                    "extension": [
                        {
                            "url": "https://hl7.org/fhir/extension-data-absent-reason.html",
                            "valueCode": "unsupported"
                        }
                    ]
                },
                "outcome": "complete",
                "insurer": {
                    "display": "Veterans Administration"
                },
                "insurance": [
                    {
                        "_coverage": {
                            "extension": [
                                {
                                    "url": "https://hl7.org/fhir/extension-data-absent-reason.html",
                                    "valueCode": "unsupported"
                                }
                            ]
                        },
                        "benefitPeriod": {
                            "start": "2019-04-27T21:06:00.000-05:00"
                        },
                        "item": [
                            {
                                "category": {
                                    "coding": [
                                        {
                                            "code": "U",
                                            "display": "Urgent Care"
                                        }
                                    ]
                                }
                            }
                        ]
                    }
                ]
            },
            "search": {
                "mode": "match"
            }
        }
    ]
}

```

