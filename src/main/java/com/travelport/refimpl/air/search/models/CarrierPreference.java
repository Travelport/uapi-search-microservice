
package com.travelport.refimpl.air.search.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "type", "carriers" })
public class CarrierPreference {

  @JsonProperty("type")
  private String type;
  @JsonProperty("carriers")
  private List<String> carriers = null;

  /**
   * No args constructor for use in serialization
   * 
   */
  public CarrierPreference() {
  }

  /**
   * 
   * @param carriers
   * @param type
   */
  public CarrierPreference(String type, List<String> carriers) {
    super();
    this.type = type;
    this.carriers = carriers;
  }

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("carriers")
  public List<String> getCarriers() {
    return carriers;
  }

  @JsonProperty("carriers")
  public void setCarriers(List<String> carriers) {
    this.carriers = carriers;
  }

}
