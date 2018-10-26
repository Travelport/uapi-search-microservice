
package com.travelport.refimpl.air.search.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "value", "type", "unit" })
public class Measurement {

  @JsonProperty("value")
  private Integer value;
  @JsonProperty("type")
  private String type;
  @JsonProperty("unit")
  private String unit;

  /**
   * No args constructor for use in serialization
   * 
   */
  public Measurement() {
  }

  /**
   * 
   * @param unit
   * @param value
   * @param type
   */
  public Measurement(Integer value, String type, String unit) {
    super();
    this.value = value;
    this.type = type;
    this.unit = unit;
  }

  @JsonProperty("value")
  public Integer getValue() {
    return value;
  }

  @JsonProperty("value")
  public void setValue(Integer value) {
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

  @JsonProperty("unit")
  public String getUnit() {
    return unit;
  }

  @JsonProperty("unit")
  public void setUnit(String unit) {
    this.unit = unit;
  }

}
