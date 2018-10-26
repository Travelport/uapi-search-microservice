
package com.travelport.refimpl.air.search.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "id", "FlightRef", "distance", "stops", "duration", "carrier",
    "number", "operatingCarrier", "operatingCarrierName", "equipment", "Departure", "Arrival",
    "IntermediateStop" })
public class Flight {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("id")
  private String id;
  @JsonProperty("FlightRef")
  private String flightRef;
  @JsonProperty("distance")
  private Integer distance;
  @JsonProperty("stops")
  private Integer stops;
  @JsonProperty("duration")
  private String duration;
  @JsonProperty("carrier")
  private String carrier;
  @JsonProperty("number")
  private String number;
  @JsonProperty("operatingCarrier")
  private String operatingCarrier;
  @JsonProperty("operatingCarrierName")
  private String operatingCarrierName;
  @JsonProperty("equipment")
  private List<String> equipment = null;
  @JsonProperty("Departure")
  private Departure departure;
  @JsonProperty("Arrival")
  private Arrival arrival;
  @JsonProperty("IntermediateStop")
  private List<IntermediateStop> intermediateStop = null;

  /**
   * No args constructor for use in serialization
   * 
   */
  public Flight() {
  }

  /**
   * 
   * @param operatingCarrier
   * @param flightRef
   * @param operatingCarrierName
   * @param departure
   * @param number
   * @param equipment
   * @param type
   * @param id
   * @param stops
   * @param distance
   * @param duration
   * @param intermediateStop
   * @param arrival
   * @param carrier
   */
  public Flight(String type, String id, String flightRef, Integer distance, Integer stops,
      String duration, String carrier, String number, String operatingCarrier,
      String operatingCarrierName, List<String> equipment, Departure departure, Arrival arrival,
      List<IntermediateStop> intermediateStop) {
    super();
    this.type = type;
    this.id = id;
    this.flightRef = flightRef;
    this.distance = distance;
    this.stops = stops;
    this.duration = duration;
    this.carrier = carrier;
    this.number = number;
    this.operatingCarrier = operatingCarrier;
    this.operatingCarrierName = operatingCarrierName;
    this.equipment = equipment;
    this.departure = departure;
    this.arrival = arrival;
    this.intermediateStop = intermediateStop;
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

  @JsonProperty("FlightRef")
  public String getFlightRef() {
    return flightRef;
  }

  @JsonProperty("FlightRef")
  public void setFlightRef(String flightRef) {
    this.flightRef = flightRef;
  }

  @JsonProperty("distance")
  public Integer getDistance() {
    return distance;
  }

  @JsonProperty("distance")
  public void setDistance(Integer distance) {
    this.distance = distance;
  }

  @JsonProperty("stops")
  public Integer getStops() {
    return stops;
  }

  @JsonProperty("stops")
  public void setStops(Integer stops) {
    this.stops = stops;
  }

  @JsonProperty("duration")
  public String getDuration() {
    return duration;
  }

  @JsonProperty("duration")
  public void setDuration(String duration) {
    this.duration = duration;
  }

  @JsonProperty("carrier")
  public String getCarrier() {
    return carrier;
  }

  @JsonProperty("carrier")
  public void setCarrier(String carrier) {
    this.carrier = carrier;
  }

  @JsonProperty("number")
  public String getNumber() {
    return number;
  }

  @JsonProperty("number")
  public void setNumber(String number) {
    this.number = number;
  }

  @JsonProperty("operatingCarrier")
  public String getOperatingCarrier() {
    return operatingCarrier;
  }

  @JsonProperty("operatingCarrier")
  public void setOperatingCarrier(String operatingCarrier) {
    this.operatingCarrier = operatingCarrier;
  }

  @JsonProperty("operatingCarrierName")
  public String getOperatingCarrierName() {
    return operatingCarrierName;
  }

  @JsonProperty("operatingCarrierName")
  public void setOperatingCarrierName(String operatingCarrierName) {
    this.operatingCarrierName = operatingCarrierName;
  }

  @JsonProperty("equipment")
  public List<String> getEquipment() {
    return equipment;
  }

  @JsonProperty("equipment")
  public void setEquipment(List<String> equipment) {
    this.equipment = equipment;
  }

  @JsonProperty("Departure")
  public Departure getDeparture() {
    return departure;
  }

  @JsonProperty("Departure")
  public void setDeparture(Departure departure) {
    this.departure = departure;
  }

  @JsonProperty("Arrival")
  public Arrival getArrival() {
    return arrival;
  }

  @JsonProperty("Arrival")
  public void setArrival(Arrival arrival) {
    this.arrival = arrival;
  }

  @JsonProperty("IntermediateStop")
  public List<IntermediateStop> getIntermediateStop() {
    return intermediateStop;
  }

  @JsonProperty("IntermediateStop")
  public void setIntermediateStop(List<IntermediateStop> intermediateStop) {
    this.intermediateStop = intermediateStop;
  }

}
