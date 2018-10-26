
package com.travelport.refimpl.air.search.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "quantity", "baggageType", "Measurement" })
public class BaggageItem {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("quantity")
  private Integer quantity;
  @JsonProperty("baggageType")
  private String baggageType;
  @JsonProperty("Measurement")
  private List<Measurement> measurement = null;

  /**
   * No args constructor for use in serialization
   * 
   */
  public BaggageItem() {
  }

  /**
   * 
   * @param baggageType
   * @param quantity
   * @param type
   * @param measurement
   */
  public BaggageItem(String type, Integer quantity, String baggageType,
      List<Measurement> measurement) {
    super();
    this.type = type;
    this.quantity = quantity;
    this.baggageType = baggageType;
    this.measurement = measurement;
  }

  @JsonProperty("@type")
  public String getType() {
    return type;
  }

  @JsonProperty("@type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("quantity")
  public Integer getQuantity() {
    return quantity;
  }

  @JsonProperty("quantity")
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  @JsonProperty("baggageType")
  public String getBaggageType() {
    return baggageType;
  }

  @JsonProperty("baggageType")
  public void setBaggageType(String baggageType) {
    this.baggageType = baggageType;
  }

  @JsonProperty("Measurement")
  public List<Measurement> getMeasurement() {
    return measurement;
  }

  @JsonProperty("Measurement")
  public void setMeasurement(List<Measurement> measurement) {
    this.measurement = measurement;
  }

}
