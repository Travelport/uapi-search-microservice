
package com.travelport.refimpl.air.search.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "id", "currencyCode", "Base", "TotalTaxes", "TotalFees", "TotalPrice",
    "VendorCurrencyTotal", "PriceBreakdown" })
public class Price {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("id")
  private String id;
  @JsonProperty("currencyCode")
  private String currencyCode;
  @JsonProperty("Base")
  private Double base;
  @JsonProperty("TotalTaxes")
  private Double totalTaxes;
  @JsonProperty("TotalFees")
  private Double totalFees;
  @JsonProperty("TotalPrice")
  private Double totalPrice;
  @JsonProperty("VendorCurrencyTotal")
  private VendorCurrencyTotal vendorCurrencyTotal;

  /**
   * No args constructor for use in serialization
   * 
   */
  public Price() {
  }

  /**
   * 
   * @param id
   * @param currencyCode
   * @param totalFees
   * @param totalTaxes
   * @param vendorCurrencyTotal
   * @param base
   * @param priceBreakdown
   * @param type
   * @param totalPrice
   */
  public Price(String type, String id, String currencyCode, Double base, Double totalTaxes,
      Double totalFees, Double totalPrice, VendorCurrencyTotal vendorCurrencyTotal) {
    super();
    this.type = type;
    this.id = id;
    this.currencyCode = currencyCode;
    this.base = base;
    this.totalTaxes = totalTaxes;
    this.totalFees = totalFees;
    this.totalPrice = totalPrice;
    this.vendorCurrencyTotal = vendorCurrencyTotal;
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

  @JsonProperty("currencyCode")
  public String getCurrencyCode() {
    return currencyCode;
  }

  @JsonProperty("currencyCode")
  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  @JsonProperty("Base")
  public Double getBase() {
    return base;
  }

  @JsonProperty("Base")
  public void setBase(Double base) {
    this.base = base;
  }

  @JsonProperty("TotalTaxes")
  public Double getTotalTaxes() {
    return totalTaxes;
  }

  @JsonProperty("TotalTaxes")
  public void setTotalTaxes(Double totalTaxes) {
    this.totalTaxes = totalTaxes;
  }

  @JsonProperty("TotalFees")
  public Double getTotalFees() {
    return totalFees;
  }

  @JsonProperty("TotalFees")
  public void setTotalFees(Double totalFees) {
    this.totalFees = totalFees;
  }

  @JsonProperty("TotalPrice")
  public Double getTotalPrice() {
    return totalPrice;
  }

  @JsonProperty("TotalPrice")
  public void setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
  }

  @JsonProperty("VendorCurrencyTotal")
  public VendorCurrencyTotal getVendorCurrencyTotal() {
    return vendorCurrencyTotal;
  }

  @JsonProperty("VendorCurrencyTotal")
  public void setVendorCurrencyTotal(VendorCurrencyTotal vendorCurrencyTotal) {
    this.vendorCurrencyTotal = vendorCurrencyTotal;
  }

}
