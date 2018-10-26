
package com.travelport.refimpl.air.search.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "id", "CatalogOfferingRef", "ProductOptions", "Price",
    "TermsAndConditions" })
public class CatalogOffering {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("id")
  private String id;
  @JsonProperty("CatalogOfferingRef")
  private String catalogOfferingRef;
  @JsonProperty("ProductOptions")
  private List<ProductOption> productOptions = null;
  @JsonProperty("Price")
  private Price price;
  @JsonProperty("TermsAndConditions")
  private TermsAndConditions termsAndConditions;

  /**
   * No args constructor for use in serialization
   * 
   */
  public CatalogOffering() {
  }

  /**
   * 
   * @param id
   * @param price
   * @param catalogOfferingRef
   * @param type
   * @param termsAndConditions
   * @param productOptions
   */
  public CatalogOffering(String type, String id, String catalogOfferingRef,
      List<ProductOption> productOptions, Price price, TermsAndConditions termsAndConditions) {
    super();
    this.type = type;
    this.id = id;
    this.catalogOfferingRef = catalogOfferingRef;
    this.productOptions = productOptions;
    this.price = price;
    this.termsAndConditions = termsAndConditions;
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

  @JsonProperty("CatalogOfferingRef")
  public String getCatalogOfferingRef() {
    return catalogOfferingRef;
  }

  @JsonProperty("CatalogOfferingRef")
  public void setCatalogOfferingRef(String catalogOfferingRef) {
    this.catalogOfferingRef = catalogOfferingRef;
  }

  @JsonProperty("ProductOptions")
  public List<ProductOption> getProductOptions() {
    return productOptions;
  }

  @JsonProperty("ProductOptions")
  public void setProductOptions(List<ProductOption> productOptions) {
    this.productOptions = productOptions;
  }

  @JsonProperty("Price")
  public Price getPrice() {
    return price;
  }

  @JsonProperty("Price")
  public void setPrice(Price price) {
    this.price = price;
  }

  @JsonProperty("TermsAndConditions")
  public TermsAndConditions getTermsAndConditions() {
    return termsAndConditions;
  }

  @JsonProperty("TermsAndConditions")
  public void setTermsAndConditions(TermsAndConditions termsAndConditions) {
    this.termsAndConditions = termsAndConditions;
  }

}
