
package com.travelport.refimpl.air.search.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "CatalogOfferingsResponse" })
public class Response {

  @JsonProperty("CatalogOfferingsResponse")
  private CatalogOfferingsResponse catalogOfferingsResponse;

  /**
   * No args constructor for use in serialization
   * 
   */
  public Response() {
  }

  /**
   * 
   * @param catalogOfferingsResponse
   */
  public Response(CatalogOfferingsResponse catalogOfferingsResponse) {
    super();
    this.catalogOfferingsResponse = catalogOfferingsResponse;
  }

  @JsonProperty("CatalogOfferingsResponse")
  public CatalogOfferingsResponse getCatalogOfferingsResponse() {
    return catalogOfferingsResponse;
  }

  @JsonProperty("CatalogOfferingsResponse")
  public void setCatalogOfferingsResponse(CatalogOfferingsResponse catalogOfferingsResponse) {
    this.catalogOfferingsResponse = catalogOfferingsResponse;
  }

}
