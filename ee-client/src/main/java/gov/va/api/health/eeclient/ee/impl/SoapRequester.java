package gov.va.api.health.eeclient.ee.impl;

import static gov.va.api.health.eeclient.util.XmlDocuments.getSoapBodyAsString;

import gov.va.api.health.eeclient.ee.EligibilityInfo;
import gov.va.api.health.eeclient.util.Checks;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SoapRequester implements EligibilityInfo {

  private final String endpointUrl;

  /** Constructor. */
  @Autowired
  public SoapRequester(@Value("${ee.endpoint.url}") String endpointUrl) {
    this.endpointUrl =
        Checks.argumentMatches(
            endpointUrl,
            "(http|https(:\\/\\/))([A-Za-z0-9\\.]+(va\\.gov))(:[0-9]+)([A-Za-z0-9\\-\\/\\_]+)");
  }

  @Override
  public String executeSoapCall(SOAPMessage soapRequestMessage) {
    SOAPMessage soapResponse = null;
    try {

      /* We want to trust all certs returned from EE. */
      HttpsURLConnection httpsUrlConnection = null;
      SSLContext sslContext = SSLContext.getInstance("SSL");
      TrustManager[] trustAll =
          new TrustManager[] {
            new X509TrustManager() {
              public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
              }

              public void checkClientTrusted(
                  java.security.cert.X509Certificate[] certs, String authType) {}

              public void checkServerTrusted(
                  java.security.cert.X509Certificate[] certs, String authType) {}
            }
          };

      sslContext.init(null, trustAll, new SecureRandom());
      HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

      HostnameVerifier allHostsValid =
          new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
              return true;
            }
          };

      URL url = new URL(endpointUrl);
      httpsUrlConnection = (HttpsURLConnection) url.openConnection();
      httpsUrlConnection.setHostnameVerifier(allHostsValid);
      httpsUrlConnection.connect();

      SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
      SOAPConnection soapConnection = soapConnectionFactory.createConnection();

      /* Lets get us that SOAP Response. */
      soapResponse = soapConnection.call(soapRequestMessage, endpointUrl);

      soapConnection.close();
      httpsUrlConnection.disconnect();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return getSoapBodyAsString(soapResponse);
  }
}
