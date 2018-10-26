
package com.travelport.refimpl.air.search.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "CatalogOfferings", "transactionId", "traceId", "Result", "ReferenceList" })
public class CatalogOfferingsResponse {

  @JsonProperty("CatalogOfferings")
  private CatalogOfferings catalogOfferings;
  @JsonProperty("transactionId")
  private String transactionId;
  @JsonProperty("traceId")
  private String traceId;
  @JsonProperty("Result")
  private Result result;
  @JsonProperty("ReferenceList")
  private List<ReferenceList> referenceList = null;

  /**
   * No args constructor for use in serialization
   * 
   */
  public CatalogOfferingsResponse() {
  }

  /**
   * @param result
   * @param transactionId
   * @param referenceList
   * @param traceId
   * @param catalogOfferings
   */
  public CatalogOfferingsResponse(CatalogOfferings catalogOfferings, String transactionId,
      String traceId, Result result, List<ReferenceList> referenceList) {
    super();
    this.catalogOfferings = catalogOfferings;
    this.transactionId = transactionId;
    this.traceId = traceId;
    this.result = result;
    this.referenceList = referenceList;
  }

  @JsonProperty("CatalogOfferings")
  public CatalogOfferings getCatalogOfferings() {
    return catalogOfferings;
  }

  @JsonProperty("CatalogOfferings")
  public void setCatalogOfferings(CatalogOfferings catalogOfferings) {
    this.catalogOfferings = catalogOfferings;
  }

  @JsonProperty("transactionId")
  public String getTransactionId() {
    return transactionId;
  }

  @JsonProperty("transactionId")
  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  @JsonProperty("traceId")
  public String getTraceId() {
    return traceId;
  }

  @JsonProperty("traceId")
  public void setTraceId(String traceId) {
    this.traceId = traceId;
  }

  @JsonProperty("Result")
  public Result getResult() {
    return result;
  }

  @JsonProperty("Result")
  public void setResult(Result result) {
    this.result = result;
  }

  @JsonProperty("ReferenceList")
  public List<ReferenceList> getReferenceList() {
    return referenceList;
  }

  @JsonProperty("ReferenceList")
  public void setReferenceList(List<ReferenceList> referenceList) {
    this.referenceList = referenceList;
  }

}
