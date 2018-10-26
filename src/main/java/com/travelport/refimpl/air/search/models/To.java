
package com.travelport.refimpl.air.search.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "value", "type" })
public class To {

  @JsonProperty("value")
  private String value;
  @JsonProperty("type")
  private String type;

  /**
   * No args constructor for use in serialization
   * 
   */
  public To() {
  }

  /**
   * 
   * @param value
   * @param type
   */
  public To(String value, String type) {
    super();
    this.value = value;
    this.type = type;
  }

  @JsonProperty("value")
  public String getValue() {
    return value;
  }

  @JsonProperty("value")
  public void setValue(String value) {
    this.value = value;
  }

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
  }

}
