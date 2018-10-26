
package com.travelport.refimpl.air.search.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "StatusCode", "Message", "WarningSummary" })
public class Warning {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("StatusCode")
  private Integer statusCode;
  @JsonProperty("Message")
  private String message;
  @JsonProperty("WarningSummary")
  private List<WarningSummary> warningSummary = null;

  /**
   * No args constructor for use in serialization
   * 
   */
  public Warning() {
  }

  /**
   * 
   * @param message
   * @param statusCode
   * @param type
   * @param warningSummary
   */
  public Warning(String type, Integer statusCode, String message,
      List<WarningSummary> warningSummary) {
    super();
    this.type = type;
    this.statusCode = statusCode;
    this.message = message;
    this.warningSummary = warningSummary;
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

  @JsonProperty("WarningSummary")
  public List<WarningSummary> getWarningSummary() {
    return warningSummary;
  }

  @JsonProperty("WarningSummary")
  public void setWarningSummary(List<WarningSummary> warningSummary) {
    this.warningSummary = warningSummary;
  }

}
