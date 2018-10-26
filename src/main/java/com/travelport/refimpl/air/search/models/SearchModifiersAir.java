
package com.travelport.refimpl.air.search.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "excludeGround", "prohibitChangeOfAirportInd", "FlightType",
    "CarrierPreference", "CabinPreference", "MaxLayover", "MaxConnectionDuration",
    "MaxOvernightDuration" })
public class SearchModifiersAir {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("excludeGround")
  private Boolean excludeGround;
  @JsonProperty("prohibitChangeOfAirportInd")
  private Boolean prohibitChangeOfAirportInd;
  @JsonProperty("FlightType")
  private FlightType flightType;
  @JsonProperty("CarrierPreference")
  private CarrierPreference carrierPreference;
  @JsonProperty("CabinPreference")
  private List<CabinPreference> cabinPreference = null;
  @JsonProperty("MaxLayover")
  private List<MaxLayover> maxLayover = null;
  @JsonProperty("MaxConnectionDuration")
  private String maxConnectionDuration;
  @JsonProperty("MaxOvernightDuration")
  private String maxOvernightDuration;

  /**
   * No args constructor for use in serialization
   * 
   */
  public SearchModifiersAir() {
  }

  /**
   * 
   * @param prohibitChangeOfAirportInd
   * @param excludeGround
   * @param cabinPreference
   * @param maxOvernightDuration
   * @param flightType
   * @param maxLayover
   * @param carrierPreference
   * @param maxConnectionDuration
   * @param type
   */
  public SearchModifiersAir(String type, Boolean excludeGround, Boolean prohibitChangeOfAirportInd,
      FlightType flightType, CarrierPreference carrierPreference,
      List<CabinPreference> cabinPreference, List<MaxLayover> maxLayover,
      String maxConnectionDuration, String maxOvernightDuration) {
    super();
    this.type = type;
    this.excludeGround = excludeGround;
    this.prohibitChangeOfAirportInd = prohibitChangeOfAirportInd;
    this.flightType = flightType;
    this.carrierPreference = carrierPreference;
    this.cabinPreference = cabinPreference;
    this.maxLayover = maxLayover;
    this.maxConnectionDuration = maxConnectionDuration;
    this.maxOvernightDuration = maxOvernightDuration;
  }

  @JsonProperty("@type")
  public String getType() {
    return type;
  }

  @JsonProperty("@type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("excludeGround")
  public Boolean getExcludeGround() {
    return excludeGround;
  }

  @JsonProperty("excludeGround")
  public void setExcludeGround(Boolean excludeGround) {
    this.excludeGround = excludeGround;
  }

  @JsonProperty("prohibitChangeOfAirportInd")
  public Boolean getProhibitChangeOfAirportInd() {
    return prohibitChangeOfAirportInd;
  }

  @JsonProperty("prohibitChangeOfAirportInd")
  public void setProhibitChangeOfAirportInd(Boolean prohibitChangeOfAirportInd) {
    this.prohibitChangeOfAirportInd = prohibitChangeOfAirportInd;
  }

  @JsonProperty("FlightType")
  public FlightType getFlightType() {
    return flightType;
  }

  @JsonProperty("FlightType")
  public void setFlightType(FlightType flightType) {
    this.flightType = flightType;
  }

  @JsonProperty("CarrierPreference")
  public CarrierPreference getCarrierPreference() {
    return carrierPreference;
  }

  @JsonProperty("CarrierPreference")
  public void setCarrierPreference(CarrierPreference carrierPreference) {
    this.carrierPreference = carrierPreference;
  }

  @JsonProperty("CabinPreference")
  public List<CabinPreference> getCabinPreference() {
    return cabinPreference;
  }

  @JsonProperty("CabinPreference")
  public void setCabinPreference(List<CabinPreference> cabinPreference) {
    this.cabinPreference = cabinPreference;
  }

  @JsonProperty("MaxLayover")
  public List<MaxLayover> getMaxLayover() {
    return maxLayover;
  }

  @JsonProperty("MaxLayover")
  public void setMaxLayover(List<MaxLayover> maxLayover) {
    this.maxLayover = maxLayover;
  }

  @JsonProperty("MaxConnectionDuration")
  public String getMaxConnectionDuration() {
    return maxConnectionDuration;
  }

  @JsonProperty("MaxConnectionDuration")
  public void setMaxConnectionDuration(String maxConnectionDuration) {
    this.maxConnectionDuration = maxConnectionDuration;
  }

  @JsonProperty("MaxOvernightDuration")
  public String getMaxOvernightDuration() {
    return maxOvernightDuration;
  }

  @JsonProperty("MaxOvernightDuration")
  public void setMaxOvernightDuration(String maxOvernightDuration) {
    this.maxOvernightDuration = maxOvernightDuration;
  }

}
