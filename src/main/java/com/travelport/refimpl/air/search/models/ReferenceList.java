
package com.travelport.refimpl.air.search.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "id", "Flight" })
public class ReferenceList {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("id")
  private String id;
  @JsonProperty("Flight")
  private List<Flight> flight = null;

  /**
   * No args constructor for use in serialization
   * 
   */
  public ReferenceList() {
  }

  /**
   * 
   * @param id
   * @param flight
   * @param type
   */
  public ReferenceList(String type, String id, List<Flight> flight) {
    super();
    this.type = type;
    this.id = id;
    this.flight = flight;
  }

  @JsonProperty("@type")
  public String getType() {
    return type;
  }

  @JsonProperty("@type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  @JsonProperty("Flight")
  public List<Flight> getFlight() {
    return flight;
  }

  @JsonProperty("Flight")
  public void setFlight(List<Flight> flight) {
    this.flight = flight;
  }

}
