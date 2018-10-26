
package com.travelport.refimpl.air.search.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "location", "date", "time" })
public class Arrival {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("location")
  private String location;
  @JsonProperty("date")
  private String date;
  @JsonProperty("time")
  private String time;

  /**
   * No args constructor for use in serialization
   * 
   */
  public Arrival() {
  }

  /**
   * 
   * @param time
   * @param location
   * @param date
   * @param type
   */
  public Arrival(String type, String location, String date, String time) {
    super();
    this.type = type;
    this.location = location;
    this.date = date;
    this.time = time;
  }

  @JsonProperty("@type")
  public String getType() {
    return type;
  }

  @JsonProperty("@type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("location")
  public String getLocation() {
    return location;
  }

  @JsonProperty("location")
  public void setLocation(String location) {
    this.location = location;
  }

  @JsonProperty("date")
  public String getDate() {
    return date;
  }

  @JsonProperty("date")
  public void setDate(String date) {
    this.date = date;
  }

  @JsonProperty("time")
  public String getTime() {
    return time;
  }

  @JsonProperty("time")
  public void setTime(String time) {
    this.time = time;
  }

}
