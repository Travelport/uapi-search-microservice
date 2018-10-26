
package com.travelport.refimpl.air.search.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "value", "duration" })
public class IntermediateStop {

  @JsonProperty("value")
  private String value;
  @JsonProperty("duration")
  private String duration;

  /**
   * No args constructor for use in serialization
   * 
   */
  public IntermediateStop() {
  }

  /**
   * 
   * @param duration
   * @param value
   */
  public IntermediateStop(String value, String duration) {
    super();
    this.value = value;
    this.duration = duration;
  }

  @JsonProperty("value")
  public String getValue() {
    return value;
  }

  @JsonProperty("value")
  public void setValue(String value) {
    this.value = value;
  }

  @JsonProperty("duration")
  public String getDuration() {
    return duration;
  }

  @JsonProperty("duration")
  public void setDuration(String duration) {
    this.duration = duration;
  }

}
