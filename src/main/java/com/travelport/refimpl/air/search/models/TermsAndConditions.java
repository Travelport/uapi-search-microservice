
package com.travelport.refimpl.air.search.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "id", "termsAndConditionsRef", "validatingCarrier", "accountCodes",
    "ExpiryDate", "BaggageAllowance" })
public class TermsAndConditions {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("id")
  private String id;
  @JsonProperty("termsAndConditionsRef")
  private String termsAndConditionsRef;
  @JsonProperty("validatingCarrier")
  private String validatingCarrier;
  @JsonProperty("accountCodes")
  private List<String> accountCodes = null;
  @JsonProperty("ExpiryDate")
  private String expiryDate;
  @JsonProperty("BaggageAllowance")
  private List<BaggageAllowance> baggageAllowance = null;

  /**
   * No args constructor for use in serialization
   * 
   */
  public TermsAndConditions() {
  }

  /**
   * 
   * @param id
   * @param validatingCarrier
   * @param expiryDate
   * @param accountCodes
   * @param baggageAllowance
   * @param termsAndConditionsRef
   * @param type
   */
  public TermsAndConditions(String type, String id, String termsAndConditionsRef,
      String validatingCarrier, List<String> accountCodes, String expiryDate,
      List<BaggageAllowance> baggageAllowance) {
    super();
    this.type = type;
    this.id = id;
    this.termsAndConditionsRef = termsAndConditionsRef;
    this.validatingCarrier = validatingCarrier;
    this.accountCodes = accountCodes;
    this.expiryDate = expiryDate;
    this.baggageAllowance = baggageAllowance;
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

  @JsonProperty("termsAndConditionsRef")
  public String getTermsAndConditionsRef() {
    return termsAndConditionsRef;
  }

  @JsonProperty("termsAndConditionsRef")
  public void setTermsAndConditionsRef(String termsAndConditionsRef) {
    this.termsAndConditionsRef = termsAndConditionsRef;
  }

  @JsonProperty("validatingCarrier")
  public String getValidatingCarrier() {
    return validatingCarrier;
  }

  @JsonProperty("validatingCarrier")
  public void setValidatingCarrier(String validatingCarrier) {
    this.validatingCarrier = validatingCarrier;
  }

  @JsonProperty("accountCodes")
  public List<String> getAccountCodes() {
    return accountCodes;
  }

  @JsonProperty("accountCodes")
  public void setAccountCodes(List<String> accountCodes) {
    this.accountCodes = accountCodes;
  }

  @JsonProperty("ExpiryDate")
  public String getExpiryDate() {
    return expiryDate;
  }

  @JsonProperty("ExpiryDate")
  public void setExpiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
  }

  @JsonProperty("BaggageAllowance")
  public List<BaggageAllowance> getBaggageAllowance() {
    return baggageAllowance;
  }

  @JsonProperty("BaggageAllowance")
  public void setBaggageAllowance(List<BaggageAllowance> baggageAllowance) {
    this.baggageAllowance = baggageAllowance;
  }

}
