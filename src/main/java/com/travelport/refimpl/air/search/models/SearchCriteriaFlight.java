
package com.travelport.refimpl.air.search.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "departureDate", "departureTime", "sequence", "From", "To" })
public class SearchCriteriaFlight {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("departureDate")
  private String departureDate;
  @JsonProperty("departureTime")
  private String departureTime;
  @JsonProperty("sequence")
  private Integer sequence;
  @JsonProperty("From")
  private From from;
  @JsonProperty("To")
  private To to;

  /**
   * No args constructor for use in serialization
   * 
   */
  public SearchCriteriaFlight() {
  }

  /**
   * 
   * @param to
   * @param departureDate
   * @param sequence
   * @param departureTime
   * @param from
   * @param type
   */
  public SearchCriteriaFlight(String type, String departureDate, String departureTime,
      Integer sequence, From from, To to) {
    super();
    this.type = type;
    this.departureDate = departureDate;
    this.departureTime = departureTime;
    this.sequence = sequence;
    this.from = from;
    this.to = to;
  }

  @JsonProperty("@type")
  public String getType() {
    return type;
  }

  @JsonProperty("@type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("departureDate")
  public String getDepartureDate() {
    return departureDate;
  }

  @JsonProperty("departureDate")
  public void setDepartureDate(String departureDate) {
    this.departureDate = departureDate;
  }

  @JsonProperty("departureTime")
  public String getDepartureTime() {
    return departureTime;
  }

  @JsonProperty("departureTime")
  public void setDepartureTime(String departureTime) {
    this.departureTime = departureTime;
  }

  @JsonProperty("sequence")
  public Integer getSequence() {
    return sequence;
  }

  @JsonProperty("sequence")
  public void setSequence(Integer sequence) {
    this.sequence = sequence;
  }

  @JsonProperty("From")
  public From getFrom() {
    return from;
  }

  @JsonProperty("From")
  public void setFrom(From from) {
    this.from = from;
  }

  @JsonProperty("To")
  public To getTo() {
    return to;
  }

  @JsonProperty("To")
  public void setTo(To to) {
    this.to = to;
  }

}
