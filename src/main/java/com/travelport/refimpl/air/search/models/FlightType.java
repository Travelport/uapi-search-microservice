
package com.travelport.refimpl.air.search.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "connectionType", "excludeInterlineConnectionsInd" })
public class FlightType {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("connectionType")
  private String connectionType;
  @JsonProperty("excludeInterlineConnectionsInd")
  private Boolean excludeInterlineConnectionsInd;

  /**
   * No args constructor for use in serialization
   * 
   */
  public FlightType() {
  }

  /**
   * 
   * @param excludeInterlineConnectionsInd
   * @param connectionType
   * @param type
   */
  public FlightType(String type, String connectionType, Boolean excludeInterlineConnectionsInd) {
    super();
    this.type = type;
    this.connectionType = connectionType;
    this.excludeInterlineConnectionsInd = excludeInterlineConnectionsInd;
  }

  @JsonProperty("@type")
  public String getType() {
    return type;
  }

  @JsonProperty("@type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("connectionType")
  public String getConnectionType() {
    return connectionType;
  }

  @JsonProperty("connectionType")
  public void setConnectionType(String connectionType) {
    this.connectionType = connectionType;
  }

  @JsonProperty("excludeInterlineConnectionsInd")
  public Boolean getExcludeInterlineConnectionsInd() {
    return excludeInterlineConnectionsInd;
  }

  @JsonProperty("excludeInterlineConnectionsInd")
  public void setExcludeInterlineConnectionsInd(Boolean excludeInterlineConnectionsInd) {
    this.excludeInterlineConnectionsInd = excludeInterlineConnectionsInd;
  }

}
