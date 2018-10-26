
package com.travelport.refimpl.air.search.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "type", "duration" })
public class MaxLayover {

  @JsonProperty("type")
  private String type;
  @JsonProperty("duration")
  private String duration;

  /**
   * No args constructor for use in serialization
   * 
   */
  public MaxLayover() {
  }

  /**
   * 
   * @param duration
   * @param type
   */
  public MaxLayover(String type, String duration) {
    super();
    this.type = type;
    this.duration = duration;
  }

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
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
