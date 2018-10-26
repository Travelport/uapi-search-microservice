
package com.travelport.refimpl.air.search.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "quantity", "requestedPassengerType", "Amount" })
public class PriceBreakdown {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("quantity")
  private Integer quantity;
  @JsonProperty("requestedPassengerType")
  private String requestedPassengerType;
  @JsonProperty("Amount")
  private Amount amount;

  /**
   * No args constructor for use in serialization
   * 
   */
  public PriceBreakdown() {
  }

  /**
   * 
   * @param amount
   * @param requestedPassengerType
   * @param quantity
   * @param type
   */
  public PriceBreakdown(String type, Integer quantity, String requestedPassengerType,
      Amount amount) {
    super();
    this.type = type;
    this.quantity = quantity;
    this.requestedPassengerType = requestedPassengerType;
    this.amount = amount;
  }

  @JsonProperty("@type")
  public String getType() {
    return type;
  }

  @JsonProperty("@type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("quantity")
  public Integer getQuantity() {
    return quantity;
  }

  @JsonProperty("quantity")
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  @JsonProperty("requestedPassengerType")
  public String getRequestedPassengerType() {
    return requestedPassengerType;
  }

  @JsonProperty("requestedPassengerType")
  public void setRequestedPassengerType(String requestedPassengerType) {
    this.requestedPassengerType = requestedPassengerType;
  }

  @JsonProperty("Amount")
  public Amount getAmount() {
    return amount;
  }

  @JsonProperty("Amount")
  public void setAmount(Amount amount) {
    this.amount = amount;
  }

}
