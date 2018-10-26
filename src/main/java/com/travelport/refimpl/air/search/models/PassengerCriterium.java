
package com.travelport.refimpl.air.search.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "value", "number", "age", "travelerGeographicLocation",
    "travelerGeographicLocationType" })
public class PassengerCriterium {

  @JsonProperty("value")
  private String value;
  @JsonProperty("number")
  private Integer number;
  @JsonProperty("age")
  private Integer age;
  @JsonProperty("travelerGeographicLocation")
  private String travelerGeographicLocation;
  @JsonProperty("travelerGeographicLocationType")
  private String travelerGeographicLocationType;

  /**
   * No args constructor for use in serialization
   * 
   */
  public PassengerCriterium() {
  }

  /**
   * 
   * @param travelerGeographicLocationType
   * @param age
   * @param travelerGeographicLocation
   * @param value
   * @param number
   */
  public PassengerCriterium(String value, Integer number, Integer age,
      String travelerGeographicLocation, String travelerGeographicLocationType) {
    super();
    this.value = value;
    this.number = number;
    this.age = age;
    this.travelerGeographicLocation = travelerGeographicLocation;
    this.travelerGeographicLocationType = travelerGeographicLocationType;
  }

  @JsonProperty("value")
  public String getValue() {
    return value;
  }

  @JsonProperty("value")
  public void setValue(String value) {
    this.value = value;
  }

  @JsonProperty("number")
  public Integer getNumber() {
    return number;
  }

  @JsonProperty("number")
  public void setNumber(Integer number) {
    this.number = number;
  }

  @JsonProperty("age")
  public Integer getAge() {
    return age;
  }

  @JsonProperty("age")
  public void setAge(Integer age) {
    this.age = age;
  }

  @JsonProperty("travelerGeographicLocation")
  public String getTravelerGeographicLocation() {
    return travelerGeographicLocation;
  }

  @JsonProperty("travelerGeographicLocation")
  public void setTravelerGeographicLocation(String travelerGeographicLocation) {
    this.travelerGeographicLocation = travelerGeographicLocation;
  }

  @JsonProperty("travelerGeographicLocationType")
  public String getTravelerGeographicLocationType() {
    return travelerGeographicLocationType;
  }

  @JsonProperty("travelerGeographicLocationType")
  public void setTravelerGeographicLocationType(String travelerGeographicLocationType) {
    this.travelerGeographicLocationType = travelerGeographicLocationType;
  }

}
