
package com.travelport.refimpl.air.search.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "TotalFees" })
public class Fees {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("TotalFees")
  private Double totalFees;

  /**
   * No args constructor for use in serialization
   * 
   */
  public Fees() {
  }

  /**
   * 
   * @param totalFees
   * @param type
   */
  public Fees(String type, Double totalFees) {
    super();
    this.type = type;
    this.totalFees = totalFees;
  }

  @JsonProperty("@type")
  public String getType() {
    return type;
  }

  @JsonProperty("@type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("TotalFees")
  public Double getTotalFees() {
    return totalFees;
  }

  @JsonProperty("TotalFees")
  public void setTotalFees(Double totalFees) {
    this.totalFees = totalFees;
  }

}
