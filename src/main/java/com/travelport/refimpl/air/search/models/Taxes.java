
package com.travelport.refimpl.air.search.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "TotalTaxes" })
public class Taxes {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("TotalTaxes")
  private Double totalTaxes;

  /**
   * No args constructor for use in serialization
   * 
   */
  public Taxes() {
  }

  /**
   * 
   * @param totalTaxes
   * @param type
   */
  public Taxes(String type, Double totalTaxes) {
    super();
    this.type = type;
    this.totalTaxes = totalTaxes;
  }

  @JsonProperty("@type")
  public String getType() {
    return type;
  }

  @JsonProperty("@type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("TotalTaxes")
  public Double getTotalTaxes() {
    return totalTaxes;
  }

  @JsonProperty("TotalTaxes")
  public void setTotalTaxes(Double totalTaxes) {
    this.totalTaxes = totalTaxes;
  }

}
