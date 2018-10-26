
package com.travelport.refimpl.air.search.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "value", "id", "action", "method", "description" })
public class NextStep {

  @JsonProperty("value")
  private String value;
  @JsonProperty("id")
  private String id;
  @JsonProperty("action")
  private String action;
  @JsonProperty("method")
  private String method;
  @JsonProperty("description")
  private String description;

  /**
   * No args constructor for use in serialization
   * 
   */
  public NextStep() {
  }

  /**
   * 
   * @param id
   * @param description
   * @param action
   * @param value
   * @param method
   */
  public NextStep(String value, String id, String action, String method, String description) {
    super();
    this.value = value;
    this.id = id;
    this.action = action;
    this.method = method;
    this.description = description;
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

  @JsonProperty("action")
  public String getAction() {
    return action;
  }

  @JsonProperty("action")
  public void setAction(String action) {
    this.action = action;
  }

  @JsonProperty("method")
  public String getMethod() {
    return method;
  }

  @JsonProperty("method")
  public void setMethod(String method) {
    this.method = method;
  }

  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  @JsonProperty("description")
  public void setDescription(String description) {
    this.description = description;
  }

}
