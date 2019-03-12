package gov.va.api.health.eeclient.ee;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import javax.xml.soap.SOAPException;

/** The primary interface for sending requests to the EE Service. */
@Component
public interface Eligibilities {
    String request(SoapMessageGenerator soapMessageGenerator);

    class EligibilitiesException extends RuntimeException {
        EligibilitiesException(String message, Throwable cause) {
            super(message, cause);
        }

        EligibilitiesException(String message) {
            super(message);
        }
    }

    class MissingIcnValue extends EligibilitiesException {
        @SneakyThrows
        public MissingIcnValue(SoapMessageGenerator soapMessageGenerator) {
            super(soapMessageGenerator.createGetEESummarySoapRequest().toString());
        }
    }

    class RequestFailed extends EligibilitiesException {
        @SneakyThrows
        public RequestFailed(SoapMessageGenerator soapMessageGenerator, Exception cause) {
            super(soapMessageGenerator.createGetEESummarySoapRequest().toString(), cause);
        }

        @SneakyThrows
        public RequestFailed(SoapMessageGenerator soapMessageGenerator, String message) {
            super(soapMessageGenerator.createGetEESummarySoapRequest().toString() + " Reason: " + message);
        }
    }

    class UnknownIdentityInSearchParameter extends EligibilitiesException {
        @SneakyThrows
        public UnknownIdentityInSearchParameter(SoapMessageGenerator soapMessageGenerator, Exception cause) {
            super(soapMessageGenerator.createGetEESummarySoapRequest().toString(), cause);
        }
    }
}
