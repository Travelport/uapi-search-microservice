
package com.travelport.refimpl.air.search.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "value", "id", "name" })
public class WarningSummary {

  @JsonProperty("value")
  private String value;
  @JsonProperty("id")
  private String id;
  @JsonProperty("name")
  private String name;

  /**
   * No args constructor for use in serialization
   * 
   */
  public WarningSummary() {
  }

  /**
   * 
   * @param id
   * @param name
   * @param value
   */
  public WarningSummary(String value, String id, String name) {
    super();
    this.value = value;
    this.id = id;
    this.name = name;
  }

  @JsonProperty("value")
  public String getValue() {
    return value;
  }

  @JsonProperty("value")
  public void setValue(String value) {
    this.value = value;
  }

  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

}
