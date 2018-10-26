
package com.travelport.refimpl.air.search.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "value", "amount", "currencyCode" })
public class VendorCurrencyTotal {

  @JsonProperty("value")
  private Object value;
  @JsonProperty("amount")
  private Integer amount;
  @JsonProperty("currencyCode")
  private String currencyCode;

  /**
   * No args constructor for use in serialization
   * 
   */
  public VendorCurrencyTotal() {
  }

  /**
   * 
   * @param amount
   * @param currencyCode
   * @param value
   */
  public VendorCurrencyTotal(Object value, Integer amount, String currencyCode) {
    super();
    this.value = value;
    this.amount = amount;
    this.currencyCode = currencyCode;
  }

  @JsonProperty("value")
  public Object getValue() {
    return value;
  }

  @JsonProperty("value")
  public void setValue(Object value) {
    this.value = value;
  }

  @JsonProperty("amount")
  public Integer getAmount() {
    return amount;
  }

  @JsonProperty("amount")
  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  @JsonProperty("currencyCode")
  public String getCurrencyCode() {
    return currencyCode;
  }

  @JsonProperty("currencyCode")
  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

}
