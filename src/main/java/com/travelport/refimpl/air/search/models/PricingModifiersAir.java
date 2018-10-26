
package com.travelport.refimpl.air.search.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "currencyCode", "FareModifiers", "FareSelection" })
public class PricingModifiersAir {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("currencyCode")
  private String currencyCode;
  @JsonProperty("FareModifiers")
  private FareModifiers fareModifiers;
  @JsonProperty("FareSelection")
  private FareSelection fareSelection;

  /**
   * No args constructor for use in serialization
   * 
   */
  public PricingModifiersAir() {
  }

  /**
   * 
   * @param currencyCode
   * @param fareSelection
   * @param fareModifiers
   * @param type
   */
  public PricingModifiersAir(String type, String currencyCode, FareModifiers fareModifiers,
      FareSelection fareSelection) {
    super();
    this.type = type;
    this.currencyCode = currencyCode;
    this.fareModifiers = fareModifiers;
    this.fareSelection = fareSelection;
  }

  @JsonProperty("@type")
  public String getType() {
    return type;
  }

  @JsonProperty("@type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("currencyCode")
  public String getCurrencyCode() {
    return currencyCode;
  }

  @JsonProperty("currencyCode")
  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  @JsonProperty("FareModifiers")
  public FareModifiers getFareModifiers() {
    return fareModifiers;
  }

  @JsonProperty("FareModifiers")
  public void setFareModifiers(FareModifiers fareModifiers) {
    this.fareModifiers = fareModifiers;
  }

  @JsonProperty("FareSelection")
  public FareSelection getFareSelection() {
    return fareSelection;
  }

  @JsonProperty("FareSelection")
  public void setFareSelection(FareSelection fareSelection) {
    this.fareSelection = fareSelection;
  }

}
