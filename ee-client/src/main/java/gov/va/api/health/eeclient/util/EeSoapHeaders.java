package gov.va.api.health.eeclient.util;

import javax.xml.bind.annotation.XmlElement;

public class EeSoapHeaders {

  @XmlElement(required = true)
  protected String usernameTokenId;

  @XmlElement(required = true)
  protected String username;

  @XmlElement(required = true)
  protected String password;

  /**
   * Gets the value of the password property.
   *
   * @return possible object is {@link String }
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets the value of the password property.
   *
   * @param value allowed object is {@link String }
   */
  public void setPassword(String value) {
    this.password = value;
  }

  /**
   * Gets the value of the username property.
   *
   * @return possible object is {@link String }
   */
  public String getUsername() {
    return username;
  }

  /**
   * Sets the value of the username property.
   *
   * @param value allowed object is {@link String }
   */
  public void setUsername(String value) {
    this.username = value;
  }

  /**
   * Gets the value of the usernameTokenId property.
   *
   * @return possible object is {@link String }
   */
  public String getUsernameTokenId() {
    return usernameTokenId;
  }

  /**
   * Sets the value of the usernameTokenId property.
   *
   * @param value allowed object is {@link String }
   */
  public void setUsernameTokenId(String value) {
    this.usernameTokenId = value;
  }
}
