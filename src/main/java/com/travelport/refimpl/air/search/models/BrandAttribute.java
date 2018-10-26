
package com.travelport.refimpl.air.search.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "classification", "inclusion" })
public class BrandAttribute {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("classification")
  private String classification;
  @JsonProperty("inclusion")
  private String inclusion;

  /**
   * No args constructor for use in serialization
   * 
   */
  public BrandAttribute() {
  }

  /**
   * 
   * @param classification
   * @param type
   * @param inclusion
   */
  public BrandAttribute(String type, String classification, String inclusion) {
    super();
    this.type = type;
    this.classification = classification;
    this.inclusion = inclusion;
  }

  @JsonProperty("@type")
  public String getType() {
    return type;
  }

  @JsonProperty("@type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("classification")
  public String getClassification() {
    return classification;
  }

  @JsonProperty("classification")
  public void setClassification(String classification) {
    this.classification = classification;
  }

  @JsonProperty("inclusion")
  public String getInclusion() {
    return inclusion;
  }

  @JsonProperty("inclusion")
  public void setInclusion(String inclusion) {
    this.inclusion = inclusion;
  }

}
