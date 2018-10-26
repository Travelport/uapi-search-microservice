
package com.travelport.refimpl.air.search.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "baseURI", "id", "NextStep" })
public class NextSteps {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("baseURI")
  private String baseURI;
  @JsonProperty("id")
  private String id;
  @JsonProperty("NextStep")
  private List<NextStep> nextStep = null;

  /**
   * No args constructor for use in serialization
   * 
   */
  public NextSteps() {
  }

  /**
   * 
   * @param id
   * @param type
   * @param nextStep
   * @param baseURI
   */
  public NextSteps(String type, String baseURI, String id, List<NextStep> nextStep) {
    super();
    this.type = type;
    this.baseURI = baseURI;
    this.id = id;
    this.nextStep = nextStep;
  }

  @JsonProperty("@type")
  public String getType() {
    return type;
  }

  @JsonProperty("@type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("baseURI")
  public String getBaseURI() {
    return baseURI;
  }

  @JsonProperty("baseURI")
  public void setBaseURI(String baseURI) {
    this.baseURI = baseURI;
  }

  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  @JsonProperty("NextStep")
  public List<NextStep> getNextStep() {
    return nextStep;
  }

  @JsonProperty("NextStep")
  public void setNextStep(List<NextStep> nextStep) {
    this.nextStep = nextStep;
  }

}
