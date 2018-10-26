
package com.travelport.refimpl.air.search.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "passengerTypeCodes", "ProductRef", "BaggageItem" })
public class BaggageAllowance {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("passengerTypeCodes")
  private List<String> passengerTypeCodes = null;
  @JsonProperty("ProductRef")
  private List<String> productRef = null;
  @JsonProperty("BaggageItem")
  private List<BaggageItem> baggageItem = null;

  /**
   * No args constructor for use in serialization
   * 
   */
  public BaggageAllowance() {
  }

  /**
   * 
   * @param baggageItem
   * @param passengerTypeCodes
   * @param productRef
   * @param type
   */
  public BaggageAllowance(String type, List<String> passengerTypeCodes, List<String> productRef,
      List<BaggageItem> baggageItem) {
    super();
    this.type = type;
    this.passengerTypeCodes = passengerTypeCodes;
    this.productRef = productRef;
    this.baggageItem = baggageItem;
  }

  @JsonProperty("@type")
  public String getType() {
    return type;
  }

  @JsonProperty("@type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("passengerTypeCodes")
  public List<String> getPassengerTypeCodes() {
    return passengerTypeCodes;
  }

  @JsonProperty("passengerTypeCodes")
  public void setPassengerTypeCodes(List<String> passengerTypeCodes) {
    this.passengerTypeCodes = passengerTypeCodes;
  }

  @JsonProperty("ProductRef")
  public List<String> getProductRef() {
    return productRef;
  }

  @JsonProperty("ProductRef")
  public void setProductRef(List<String> productRef) {
    this.productRef = productRef;
  }

  @JsonProperty("BaggageItem")
  public List<BaggageItem> getBaggageItem() {
    return baggageItem;
  }

  @JsonProperty("BaggageItem")
  public void setBaggageItem(List<BaggageItem> baggageItem) {
    this.baggageItem = baggageItem;
  }

}
