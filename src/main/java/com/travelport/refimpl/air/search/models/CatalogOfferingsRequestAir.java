
package com.travelport.refimpl.air.search.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "maxNumberOfOffersToReturn", "offersPerPage", "returnBrandedFaresInd",
    "PassengerCriteria", "SearchCriteriaFlight", "SearchModifiersAir", "PricingModifiersAir",
    "PseudoCityInfo" })
public class CatalogOfferingsRequestAir {

  @JsonProperty("maxNumberOfOffersToReturn")
  private Integer maxNumberOfOffersToReturn;
  @JsonProperty("offersPerPage")
  private Integer offersPerPage;
  @JsonProperty("returnBrandedFaresInd")
  private Boolean returnBrandedFaresInd;
  @JsonProperty("PassengerCriteria")
  private List<PassengerCriterium> passengerCriteria = null;
  @JsonProperty("SearchCriteriaFlight")
  private List<SearchCriteriaFlight> searchCriteriaFlight = null;
  @JsonProperty("SearchModifiersAir")
  private SearchModifiersAir searchModifiersAir;
  @JsonProperty("PricingModifiersAir")
  private PricingModifiersAir pricingModifiersAir;
  @JsonProperty("PseudoCityInfo")
  private PseudoCityInfo pseudoCityInfo;

  /**
   * No args constructor for use in serialization
   * 
   */
  public CatalogOfferingsRequestAir() {
  }

  /**
   * 
   * @param maxNumberOfOffersToReturn
   * @param pseudoCityInfo
   * @param offersPerPage
   * @param returnBrandedFaresInd
   * @param searchModifiersAir
   * @param passengerCriteria
   * @param pricingModifiersAir
   * @param searchCriteriaFlight
   */
  public CatalogOfferingsRequestAir(Integer maxNumberOfOffersToReturn, Integer offersPerPage,
      Boolean returnBrandedFaresInd, List<PassengerCriterium> passengerCriteria,
      List<SearchCriteriaFlight> searchCriteriaFlight, SearchModifiersAir searchModifiersAir,
      PricingModifiersAir pricingModifiersAir, PseudoCityInfo pseudoCityInfo) {
    super();
    this.maxNumberOfOffersToReturn = maxNumberOfOffersToReturn;
    this.offersPerPage = offersPerPage;
    this.returnBrandedFaresInd = returnBrandedFaresInd;
    this.passengerCriteria = passengerCriteria;
    this.searchCriteriaFlight = searchCriteriaFlight;
    this.searchModifiersAir = searchModifiersAir;
    this.pricingModifiersAir = pricingModifiersAir;
    this.pseudoCityInfo = pseudoCityInfo;
  }

  @JsonProperty("maxNumberOfOffersToReturn")
  public Integer getMaxNumberOfOffersToReturn() {
    return maxNumberOfOffersToReturn;
  }

  @JsonProperty("maxNumberOfOffersToReturn")
  public void setMaxNumberOfOffersToReturn(Integer maxNumberOfOffersToReturn) {
    this.maxNumberOfOffersToReturn = maxNumberOfOffersToReturn;
  }

  @JsonProperty("offersPerPage")
  public Integer getOffersPerPage() {
    return offersPerPage;
  }

  @JsonProperty("offersPerPage")
  public void setOffersPerPage(Integer offersPerPage) {
    this.offersPerPage = offersPerPage;
  }

  @JsonProperty("returnBrandedFaresInd")
  public Boolean getReturnBrandedFaresInd() {
    return returnBrandedFaresInd;
  }

  @JsonProperty("returnBrandedFaresInd")
  public void setReturnBrandedFaresInd(Boolean returnBrandedFaresInd) {
    this.returnBrandedFaresInd = returnBrandedFaresInd;
  }

  @JsonProperty("PassengerCriteria")
  public List<PassengerCriterium> getPassengerCriteria() {
    return passengerCriteria;
  }

  @JsonProperty("PassengerCriteria")
  public void setPassengerCriteria(List<PassengerCriterium> passengerCriteria) {
    this.passengerCriteria = passengerCriteria;
  }

  @JsonProperty("SearchCriteriaFlight")
  public List<SearchCriteriaFlight> getSearchCriteriaFlight() {
    return searchCriteriaFlight;
  }

  @JsonProperty("SearchCriteriaFlight")
  public void setSearchCriteriaFlight(List<SearchCriteriaFlight> searchCriteriaFlight) {
    this.searchCriteriaFlight = searchCriteriaFlight;
  }

  @JsonProperty("SearchModifiersAir")
  public SearchModifiersAir getSearchModifiersAir() {
    return searchModifiersAir;
  }

  @JsonProperty("SearchModifiersAir")
  public void setSearchModifiersAir(SearchModifiersAir searchModifiersAir) {
    this.searchModifiersAir = searchModifiersAir;
  }

  @JsonProperty("PricingModifiersAir")
  public PricingModifiersAir getPricingModifiersAir() {
    return pricingModifiersAir;
  }

  @JsonProperty("PricingModifiersAir")
  public void setPricingModifiersAir(PricingModifiersAir pricingModifiersAir) {
    this.pricingModifiersAir = pricingModifiersAir;
  }

  @JsonProperty("PseudoCityInfo")
  public PseudoCityInfo getPseudoCityInfo() {
    return pseudoCityInfo;
  }

  @JsonProperty("PseudoCityInfo")
  public void setPseudoCityInfo(PseudoCityInfo pseudoCityInfo) {
    this.pseudoCityInfo = pseudoCityInfo;
  }

}
