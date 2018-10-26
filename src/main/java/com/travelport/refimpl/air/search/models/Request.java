
package com.travelport.refimpl.air.search.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "CatalogOfferingsRequestAir" })
public class Request {

  @JsonProperty("CatalogOfferingsRequestAir")
  private CatalogOfferingsRequestAir catalogOfferingsRequestAir;

  /**
   * No args constructor for use in serialization
   * 
   */
  public Request() {
  }

  /**
   * 
   * @param catalogOfferingsRequestAir
   */
  public Request(CatalogOfferingsRequestAir catalogOfferingsRequestAir) {
    super();
    this.catalogOfferingsRequestAir = catalogOfferingsRequestAir;
  }

  @JsonProperty("CatalogOfferingsRequestAir")
  public CatalogOfferingsRequestAir getCatalogOfferingsRequestAir() {
    return catalogOfferingsRequestAir;
  }

  @JsonProperty("CatalogOfferingsRequestAir")
  public void setCatalogOfferingsRequestAir(CatalogOfferingsRequestAir catalogOfferingsRequestAir) {
    this.catalogOfferingsRequestAir = catalogOfferingsRequestAir;
  }

}
