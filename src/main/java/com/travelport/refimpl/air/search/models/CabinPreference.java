
package com.travelport.refimpl.air.search.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "type", "cabins" })
public class CabinPreference {

  @JsonProperty("type")
  private String type;
  @JsonProperty("cabins")
  private List<String> cabins = null;

  /**
   * No args constructor for use in serialization
   * 
   */
  public CabinPreference() {
  }

  /**
   * 
   * @param cabins
   * @param type
   */
  public CabinPreference(String type, List<String> cabins) {
    super();
    this.type = type;
    this.cabins = cabins;
  }

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("cabins")
  public List<String> getCabins() {
    return cabins;
  }

  @JsonProperty("cabins")
  public void setCabins(List<String> cabins) {
    this.cabins = cabins;
  }

}
