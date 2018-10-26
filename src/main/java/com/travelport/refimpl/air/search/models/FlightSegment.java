
package com.travelport.refimpl.air.search.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "id", "sequence", "connectionDuration", "boundFlightsInd", "Flight" })
public class FlightSegment {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("id")
  private String id;
  @JsonProperty("sequence")
  private Integer sequence;
  @JsonProperty("connectionDuration")
  private String connectionDuration;
  @JsonProperty("boundFlightsInd")
  private Boolean boundFlightsInd;
  @JsonProperty("Flight")
  private Flight flight;

  /**
   * No args constructor for use in serialization
   * 
   */
  public FlightSegment() {
  }

  /**
   * 
   * @param id
   * @param flight
   * @param boundFlightsInd
   * @param sequence
   * @param type
   * @param connectionDuration
   */
  public FlightSegment(String type, String id, Integer sequence, String connectionDuration,
      Boolean boundFlightsInd, Flight flight) {
    super();
    this.type = type;
    this.id = id;
    this.sequence = sequence;
    this.connectionDuration = connectionDuration;
    this.boundFlightsInd = boundFlightsInd;
    this.flight = flight;
  }

  @JsonProperty("@type")
  public String getType() {
    return type;
  }

  @JsonProperty("@type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  @JsonProperty("sequence")
  public Integer getSequence() {
    return sequence;
  }

  @JsonProperty("sequence")
  public void setSequence(Integer sequence) {
    this.sequence = sequence;
  }

  @JsonProperty("connectionDuration")
  public String getConnectionDuration() {
    return connectionDuration;
  }

  @JsonProperty("connectionDuration")
  public void setConnectionDuration(String connectionDuration) {
    this.connectionDuration = connectionDuration;
  }

  @JsonProperty("boundFlightsInd")
  public Boolean getBoundFlightsInd() {
    return boundFlightsInd;
  }

  @JsonProperty("boundFlightsInd")
  public void setBoundFlightsInd(Boolean boundFlightsInd) {
    this.boundFlightsInd = boundFlightsInd;
  }

  @JsonProperty("Flight")
  public Flight getFlight() {
    return flight;
  }

  @JsonProperty("Flight")
  public void setFlight(Flight flight) {
    this.flight = flight;
  }

}
