
package com.travelport.refimpl.air.search.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "segmentSequence", "classOfService", "cabin", "fareBasisCode",
    "privateFareInd", "Brand" })
public class FlightProduct {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("segmentSequence")
  private List<Integer> segmentSequence = null;
  @JsonProperty("classOfService")
  private String classOfService;
  @JsonProperty("cabin")
  private String cabin;
  @JsonProperty("fareBasisCode")
  private String fareBasisCode;
  @JsonProperty("privateFareInd")
  private Boolean privateFareInd;
  @JsonProperty("Brand")
  private Brand brand;

  /**
   * No args constructor for use in serialization
   * 
   */
  public FlightProduct() {
  }

  /**
   * 
   * @param fareBasisCode
   * @param cabin
   * @param segmentSequence
   * @param brand
   * @param classOfService
   * @param type
   * @param privateFareInd
   */
  public FlightProduct(String type, List<Integer> segmentSequence, String classOfService,
      String cabin, String fareBasisCode, Boolean privateFareInd, Brand brand) {
    super();
    this.type = type;
    this.segmentSequence = segmentSequence;
    this.classOfService = classOfService;
    this.cabin = cabin;
    this.fareBasisCode = fareBasisCode;
    this.privateFareInd = privateFareInd;
    this.brand = brand;
  }

  @JsonProperty("@type")
  public String getType() {
    return type;
  }

  @JsonProperty("@type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("segmentSequence")
  public List<Integer> getSegmentSequence() {
    return segmentSequence;
  }

  @JsonProperty("segmentSequence")
  public void setSegmentSequence(List<Integer> segmentSequence) {
    this.segmentSequence = segmentSequence;
  }

  @JsonProperty("classOfService")
  public String getClassOfService() {
    return classOfService;
  }

  @JsonProperty("classOfService")
  public void setClassOfService(String classOfService) {
    this.classOfService = classOfService;
  }

  @JsonProperty("cabin")
  public String getCabin() {
    return cabin;
  }

  @JsonProperty("cabin")
  public void setCabin(String cabin) {
    this.cabin = cabin;
  }

  @JsonProperty("fareBasisCode")
  public String getFareBasisCode() {
    return fareBasisCode;
  }

  @JsonProperty("fareBasisCode")
  public void setFareBasisCode(String fareBasisCode) {
    this.fareBasisCode = fareBasisCode;
  }

  @JsonProperty("privateFareInd")
  public Boolean getPrivateFareInd() {
    return privateFareInd;
  }

  @JsonProperty("privateFareInd")
  public void setPrivateFareInd(Boolean privateFareInd) {
    this.privateFareInd = privateFareInd;
  }

  @JsonProperty("Brand")
  public Brand getBrand() {
    return brand;
  }

  @JsonProperty("Brand")
  public void setBrand(Brand brand) {
    this.brand = brand;
  }

}
