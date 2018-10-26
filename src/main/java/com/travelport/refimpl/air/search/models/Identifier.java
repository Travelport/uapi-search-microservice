
package com.travelport.refimpl.air.search.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "value", "authority" })
public class Identifier {

  @JsonProperty("value")
  private String value;
  @JsonProperty("authority")
  private String authority;

  /**
   * No args constructor for use in serialization
   * 
   */
  public Identifier() {
  }

  /**
   * 
   * @param authority
   * @param value
   */
  public Identifier(String value, String authority) {
    super();
    this.value = value;
    this.authority = authority;
  }

  @JsonProperty("value")
  public String getValue() {
    return value;
  }

  @JsonProperty("value")
  public void setValue(String value) {
    this.value = value;
  }

  @JsonProperty("authority")
  public String getAuthority() {
    return authority;
  }

  @JsonProperty("authority")
  public void setAuthority(String authority) {
    this.authority = authority;
  }

}
