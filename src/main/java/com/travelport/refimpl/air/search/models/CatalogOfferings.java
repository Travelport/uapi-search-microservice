
package com.travelport.refimpl.air.search.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "Identifier", "DefaultCurrency", "CatalogOffering", "transactionId",
    "traceId", "Result", "NextSteps", "ReferenceList" })
public class CatalogOfferings {

  @JsonProperty("id")
  private String id;
  @JsonProperty("Identifier")
  private Identifier identifier;
  @JsonProperty("DefaultCurrency")
  private DefaultCurrency defaultCurrency;
  @JsonProperty("CatalogOffering")
  private List<CatalogOffering> catalogOffering = null;

  /**
   * No args constructor for use in serialization
   * 
   */
  public CatalogOfferings() {
  }

  /**
   * 
   * @param id
   * @param defaultCurrency
   * @param catalogOffering
   * @param identifier
   */
  public CatalogOfferings(String id, Identifier identifier, DefaultCurrency defaultCurrency,
      List<CatalogOffering> catalogOffering) {
    super();
    this.id = id;
    this.identifier = identifier;
    this.defaultCurrency = defaultCurrency;
    this.catalogOffering = catalogOffering;
  }

  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  @JsonProperty("Identifier")
  public Identifier getIdentifier() {
    return identifier;
  }

  @JsonProperty("Identifier")
  public void setIdentifier(Identifier identifier) {
    this.identifier = identifier;
  }

  @JsonProperty("DefaultCurrency")
  public DefaultCurrency getDefaultCurrency() {
    return defaultCurrency;
  }

  @JsonProperty("DefaultCurrency")
  public void setDefaultCurrency(DefaultCurrency defaultCurrency) {
    this.defaultCurrency = defaultCurrency;
  }

  @JsonProperty("CatalogOffering")
  public List<CatalogOffering> getCatalogOffering() {
    return catalogOffering;
  }

  @JsonProperty("CatalogOffering")
  public void setCatalogOffering(List<CatalogOffering> catalogOffering) {
    this.catalogOffering = catalogOffering;
  }

}
