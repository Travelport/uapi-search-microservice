
package com.travelport.refimpl.air.search.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "status", "Error", "Warning" })
public class Result {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("status")
  private String status;
  @JsonProperty("Error")
  private List<Error> error = null;
  @JsonProperty("Warning")
  private List<Warning> warning = null;

  /**
   * No args constructor for use in serialization
   * 
   */
  public Result() {
  }

  /**
   * 
   * @param error
   * @param status
   * @param type
   * @param warning
   */
  public Result(String type, String status, List<Error> error, List<Warning> warning) {
    super();
    this.type = type;
    this.status = status;
    this.error = error;
    this.warning = warning;
  }

  @JsonProperty("@type")
  public String getType() {
    return type;
  }

  @JsonProperty("@type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  @JsonProperty("status")
  public void setStatus(String status) {
    this.status = status;
  }

  @JsonProperty("Error")
  public List<Error> getError() {
    return error;
  }

  @JsonProperty("Error")
  public void setError(List<Error> error) {
    this.error = error;
  }

  @JsonProperty("Warning")
  public List<Warning> getWarning() {
    return warning;
  }

  @JsonProperty("Warning")
  public void setWarning(List<Warning> warning) {
    this.warning = warning;
  }

}
