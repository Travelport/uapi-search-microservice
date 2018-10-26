
package com.travelport.refimpl.air.search.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "id", "productRef", "totalDuration", "Quantity", "FlightSegment",
    "PassengerFlight" })
public class Product {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("id")
  private String id;
  @JsonProperty("productRef")
  private String productRef;
  @JsonProperty("totalDuration")
  private String totalDuration;
  @JsonProperty("Quantity")
  private Integer quantity;
  @JsonProperty("FlightSegment")
  private List<FlightSegment> flightSegment = null;
  @JsonProperty("PassengerFlight")
  private List<PassengerFlight> passengerFlight = null;

  /**
   * No args constructor for use in serialization
   * 
   */
  public Product() {
  }

  /**
   * 
   * @param id
   * @param totalDuration
   * @param flightSegment
   * @param quantity
   * @param productRef
   * @param type
   * @param passengerFlight
   */
  public Product(String type, String id, String productRef, String totalDuration, Integer quantity,
      List<FlightSegment> flightSegment, List<PassengerFlight> passengerFlight) {
    super();
    this.type = type;
    this.id = id;
    this.productRef = productRef;
    this.totalDuration = totalDuration;
    this.quantity = quantity;
    this.flightSegment = flightSegment;
    this.passengerFlight = passengerFlight;
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

  @JsonProperty("productRef")
  public String getProductRef() {
    return productRef;
  }

  @JsonProperty("productRef")
  public void setProductRef(String productRef) {
    this.productRef = productRef;
  }

  @JsonProperty("totalDuration")
  public String getTotalDuration() {
    return totalDuration;
  }

  @JsonProperty("totalDuration")
  public void setTotalDuration(String totalDuration) {
    this.totalDuration = totalDuration;
  }

  @JsonProperty("Quantity")
  public Integer getQuantity() {
    return quantity;
  }

  @JsonProperty("Quantity")
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  @JsonProperty("FlightSegment")
  public List<FlightSegment> getFlightSegment() {
    return flightSegment;
  }

  @JsonProperty("FlightSegment")
  public void setFlightSegment(List<FlightSegment> flightSegment) {
    this.flightSegment = flightSegment;
  }

  @JsonProperty("PassengerFlight")
  public List<PassengerFlight> getPassengerFlight() {
    return passengerFlight;
  }

  @JsonProperty("PassengerFlight")
  public void setPassengerFlight(List<PassengerFlight> passengerFlight) {
    this.passengerFlight = passengerFlight;
  }

}
