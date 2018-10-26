
package com.travelport.refimpl.air.search.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "StatusCode", "Message", "ErrorSummary" })
public class Error {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("StatusCode")
  private Integer statusCode;
  @JsonProperty("Message")
  private String message;
  @JsonProperty("ErrorSummary")
  private List<ErrorSummary> errorSummary = null;

  /**
   * No args constructor for use in serialization
   * 
   */
  public Error() {
  }

  /**
   * 
   * @param message
   * @param statusCode
   * @param errorSummary
   * @param type
   */
  public Error(String type, Integer statusCode, String message, List<ErrorSummary> errorSummary) {
    super();
    this.type = type;
    this.statusCode = statusCode;
    this.message = message;
    this.errorSummary = errorSummary;
  }

  @JsonProperty("@type")
  public String getType() {
    return type;
  }

  @JsonProperty("@type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("StatusCode")
  public Integer getStatusCode() {
    return statusCode;
  }

  @JsonProperty("StatusCode")
  public void setStatusCode(Integer statusCode) {
    this.statusCode = statusCode;
  }

  @JsonProperty("Message")
  public String getMessage() {
    return message;
  }

  @JsonProperty("Message")
  public void setMessage(String message) {
    this.message = message;
  }

  @JsonProperty("ErrorSummary")
  public List<ErrorSummary> getErrorSummary() {
    return errorSummary;
  }

  @JsonProperty("ErrorSummary")
  public void setErrorSummary(List<ErrorSummary> errorSummary) {
    this.errorSummary = errorSummary;
  }

}
