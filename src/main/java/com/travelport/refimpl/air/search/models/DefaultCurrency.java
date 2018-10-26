
package com.travelport.refimpl.air.search.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "value", "code" })
public class DefaultCurrency {

  @JsonProperty("value")
  private Object value;
  @JsonProperty("code")
  private String code;

  /**
   * No args constructor for use in serialization
   * 
   */
  public DefaultCurrency() {
  }

  /**
   * 
   * @param value
   * @param code
   */
  public DefaultCurrency(Object value, String code) {
    super();
    this.value = value;
    this.code = code;
  }

  @JsonProperty("value")
  public Object getValue() {
    return value;
  }

  @JsonProperty("value")
  public void setValue(Object value) {
    this.value = value;
  }

  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  @JsonProperty("code")
  public void setCode(String code) {
    this.code = code;
  }

}
