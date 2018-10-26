
package com.travelport.refimpl.air.search.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "fareType", "validatingCarrier", "overrideCarrier",
    "prohibitMinStayFaresInd", "prohibitMaxStayFaresInd", "refundableOnlyInd",
    "prohibitAdvancePurchaseFaresInd" })
public class FareSelection {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("fareType")
  private String fareType;
  @JsonProperty("validatingCarrier")
  private String validatingCarrier;
  @JsonProperty("overrideCarrier")
  private String overrideCarrier;
  @JsonProperty("prohibitMinStayFaresInd")
  private Boolean prohibitMinStayFaresInd;
  @JsonProperty("prohibitMaxStayFaresInd")
  private Boolean prohibitMaxStayFaresInd;
  @JsonProperty("refundableOnlyInd")
  private Boolean refundableOnlyInd;
  @JsonProperty("prohibitAdvancePurchaseFaresInd")
  private Boolean prohibitAdvancePurchaseFaresInd;

  /**
   * No args constructor for use in serialization
   * 
   */
  public FareSelection() {
  }

  /**
   * 
   * @param overrideCarrier
   * @param validatingCarrier
   * @param refundableOnlyInd
   * @param fareType
   * @param prohibitMinStayFaresInd
   * @param prohibitMaxStayFaresInd
   * @param type
   * @param prohibitAdvancePurchaseFaresInd
   */
  public FareSelection(String type, String fareType, String validatingCarrier,
      String overrideCarrier, Boolean prohibitMinStayFaresInd, Boolean prohibitMaxStayFaresInd,
      Boolean refundableOnlyInd, Boolean prohibitAdvancePurchaseFaresInd) {
    super();
    this.type = type;
    this.fareType = fareType;
    this.validatingCarrier = validatingCarrier;
    this.overrideCarrier = overrideCarrier;
    this.prohibitMinStayFaresInd = prohibitMinStayFaresInd;
    this.prohibitMaxStayFaresInd = prohibitMaxStayFaresInd;
    this.refundableOnlyInd = refundableOnlyInd;
    this.prohibitAdvancePurchaseFaresInd = prohibitAdvancePurchaseFaresInd;
  }

  @JsonProperty("@type")
  public String getType() {
    return type;
  }

  @JsonProperty("@type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("fareType")
  public String getFareType() {
    return fareType;
  }

  @JsonProperty("fareType")
  public void setFareType(String fareType) {
    this.fareType = fareType;
  }

  @JsonProperty("validatingCarrier")
  public String getValidatingCarrier() {
    return validatingCarrier;
  }

  @JsonProperty("validatingCarrier")
  public void setValidatingCarrier(String validatingCarrier) {
    this.validatingCarrier = validatingCarrier;
  }

  @JsonProperty("overrideCarrier")
  public String getOverrideCarrier() {
    return overrideCarrier;
  }

  @JsonProperty("overrideCarrier")
  public void setOverrideCarrier(String overrideCarrier) {
    this.overrideCarrier = overrideCarrier;
  }

  @JsonProperty("prohibitMinStayFaresInd")
  public Boolean getProhibitMinStayFaresInd() {
    return prohibitMinStayFaresInd;
  }

  @JsonProperty("prohibitMinStayFaresInd")
  public void setProhibitMinStayFaresInd(Boolean prohibitMinStayFaresInd) {
    this.prohibitMinStayFaresInd = prohibitMinStayFaresInd;
  }

  @JsonProperty("prohibitMaxStayFaresInd")
  public Boolean getProhibitMaxStayFaresInd() {
    return prohibitMaxStayFaresInd;
  }

  @JsonProperty("prohibitMaxStayFaresInd")
  public void setProhibitMaxStayFaresInd(Boolean prohibitMaxStayFaresInd) {
    this.prohibitMaxStayFaresInd = prohibitMaxStayFaresInd;
  }

  @JsonProperty("refundableOnlyInd")
  public Boolean getRefundableOnlyInd() {
    return refundableOnlyInd;
  }

  @JsonProperty("refundableOnlyInd")
  public void setRefundableOnlyInd(Boolean refundableOnlyInd) {
    this.refundableOnlyInd = refundableOnlyInd;
  }

  @JsonProperty("prohibitAdvancePurchaseFaresInd")
  public Boolean getProhibitAdvancePurchaseFaresInd() {
    return prohibitAdvancePurchaseFaresInd;
  }

  @JsonProperty("prohibitAdvancePurchaseFaresInd")
  public void setProhibitAdvancePurchaseFaresInd(Boolean prohibitAdvancePurchaseFaresInd) {
    this.prohibitAdvancePurchaseFaresInd = prohibitAdvancePurchaseFaresInd;
  }

}
