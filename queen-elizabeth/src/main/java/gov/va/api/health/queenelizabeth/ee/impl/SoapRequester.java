package gov.va.api.health.queenelizabeth.ee.impl;

import static gov.va.api.health.queenelizabeth.util.XmlDocuments.getSoapBodyAsString;

import gov.va.api.health.queenelizabeth.ee.Eligibilities;
import gov.va.api.health.queenelizabeth.ee.EligibilityInfo;
import gov.va.api.health.queenelizabeth.util.Checks;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import lombok.SneakyThrows;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SoapRequester implements EligibilityInfo {

  private final String endpointUrl;

  private final String eeTruststorePath;

  private final String eeTruststorePassword;

  /** Constructor. */
  @Autowired
  public SoapRequester(
      @Value("${ee.endpoint.url}") String endpointUrl,
      @Value("${ee.truststore.path}") String eeTruststorePath,
      @Value("${ee.truststore.password}") String eeTruststorePassword) {
    this.endpointUrl =
        Checks.argumentMatches(
            endpointUrl,
            "(http|https(:\\/\\/))([A-Za-z0-9\\.]+(va\\.gov))(:[0-9]+)([A-Za-z0-9\\-\\/\\_]+)");
    this.eeTruststorePath = eeTruststorePath;
    this.eeTruststorePassword = eeTruststorePassword;
  }

  @Override
  public String executeSoapCall(SOAPMessage soapRequestMessage) {
    try {
      /* In E&E we trust. */
      HttpsURLConnection httpsUrlConnection = openHttpsConnection();
      SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
      SOAPConnection soapConnection = soapConnectionFactory.createConnection();
      /* Lets get us a SOAP Response. */
      SOAPMessage soapResponse = soapConnection.call(soapRequestMessage, endpointUrl);
      soapConnection.close();
      httpsUrlConnection.disconnect();
      return getSoapBodyAsString(soapResponse);
    } catch (SOAPException e) {
      throw new Eligibilities.RequestFailed(soapRequestMessage, "Failed to send/receive from EE");
    }
  }

  @SneakyThrows
  private SSLContext getSslContext() {
    /* Load the truststore that contains the ee certs. */
    InputStream truststoreInputStream =
        getClass().getClassLoader().getResourceAsStream(FilenameUtils.getName(eeTruststorePath));
    KeyStore ts = KeyStore.getInstance("JKS");
    ts.load(truststoreInputStream, eeTruststorePassword.toCharArray());
    TrustManagerFactory trustManagerFactory =
        TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    trustManagerFactory.init(ts);
    /* Initialize the ssl context using the truststore. */
    SSLContext sslContext = SSLContext.getInstance("TLS");
    sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());
    truststoreInputStream.close();
    return sslContext;
  }

  @SneakyThrows
  private HttpsURLConnection openHttpsConnection() {
    /* HTTPS connection with the EE service. */
    HttpsURLConnection.setDefaultSSLSocketFactory(getSslContext().getSocketFactory());
    URL eeUrl = new URL(endpointUrl);
    if (!eeUrl.getProtocol().equals("https")) {
      throw new Eligibilities.RequestFailed("E&E Url received is not https.");
    }
    InetAddress inetAddress = InetAddress.getByName(eeUrl.getHost());
    if (inetAddress.isAnyLocalAddress()
        || inetAddress.isLoopbackAddress()
        || inetAddress.isLinkLocalAddress()) {
      throw new Eligibilities.RequestFailed("E&E Url received is a local address.");
    }
    HttpsURLConnection httpsUrlConnection = (HttpsURLConnection) eeUrl.openConnection();
    httpsUrlConnection.connect();
    return httpsUrlConnection;
  }
}
