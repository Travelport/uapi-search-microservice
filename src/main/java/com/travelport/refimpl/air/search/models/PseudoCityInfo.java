
package com.travelport.refimpl.air.search.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "value", "providerCode" })
public class PseudoCityInfo {

  @JsonProperty("value")
  private String value;
  @JsonProperty("providerCode")
  private String providerCode;

  /**
   * No args constructor for use in serialization
   * 
   */
  public PseudoCityInfo() {
  }

  /**
   * 
   * @param value
   * @param providerCode
   */
  public PseudoCityInfo(String value, String providerCode) {
    super();
    this.value = value;
    this.providerCode = providerCode;
  }

  @JsonProperty("value")
  public String getValue() {
    return value;
  }

  @JsonProperty("value")
  public void setValue(String value) {
    this.value = value;
  }

  @JsonProperty("providerCode")
  public String getProviderCode() {
    return providerCode;
  }

  @JsonProperty("providerCode")
  public void setProviderCode(String providerCode) {
    this.providerCode = providerCode;
  }

}
