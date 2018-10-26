
package com.travelport.refimpl.air.search.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "passengerQuantity", "passengerTypeCode", "FlightProduct" })
public class PassengerFlight {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("passengerQuantity")
  private Integer passengerQuantity;
  @JsonProperty("passengerTypeCode")
  private String passengerTypeCode;
  @JsonProperty("FlightProduct")
  private List<FlightProduct> flightProduct = null;

  /**
   * No args constructor for use in serialization
   * 
   */
  public PassengerFlight() {
  }

  /**
   * 
   * @param passengerTypeCode
   * @param flightProduct
   * @param type
   * @param passengerQuantity
   */
  public PassengerFlight(String type, Integer passengerQuantity, String passengerTypeCode,
      List<FlightProduct> flightProduct) {
    super();
    this.type = type;
    this.passengerQuantity = passengerQuantity;
    this.passengerTypeCode = passengerTypeCode;
    this.flightProduct = flightProduct;
  }

  @JsonProperty("@type")
  public String getType() {
    return type;
  }

  @JsonProperty("@type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("passengerQuantity")
  public Integer getPassengerQuantity() {
    return passengerQuantity;
  }

  @JsonProperty("passengerQuantity")
  public void setPassengerQuantity(Integer passengerQuantity) {
    this.passengerQuantity = passengerQuantity;
  }

  @JsonProperty("passengerTypeCode")
  public String getPassengerTypeCode() {
    return passengerTypeCode;
  }

  @JsonProperty("passengerTypeCode")
  public void setPassengerTypeCode(String passengerTypeCode) {
    this.passengerTypeCode = passengerTypeCode;
  }

  @JsonProperty("FlightProduct")
  public List<FlightProduct> getFlightProduct() {
    return flightProduct;
  }

  @JsonProperty("FlightProduct")
  public void setFlightProduct(List<FlightProduct> flightProduct) {
    this.flightProduct = flightProduct;
  }

}
