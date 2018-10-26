
package com.travelport.refimpl.air.search.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "code", "supplierCode" })
public class Account {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("code")
  private List<String> code = null;
  @JsonProperty("supplierCode")
  private String supplierCode;

  /**
   * No args constructor for use in serialization
   * 
   */
  public Account() {
  }

  /**
   * 
   * @param supplierCode
   * @param code
   * @param type
   */
  public Account(String type, List<String> code, String supplierCode) {
    super();
    this.type = type;
    this.code = code;
    this.supplierCode = supplierCode;
  }

  @JsonProperty("@type")
  public String getType() {
    return type;
  }

  @JsonProperty("@type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("code")
  public List<String> getCode() {
    return code;
  }

  @JsonProperty("code")
  public void setCode(List<String> code) {
    this.code = code;
  }

  @JsonProperty("supplierCode")
  public String getSupplierCode() {
    return supplierCode;
  }

  @JsonProperty("supplierCode")
  public void setSupplierCode(String supplierCode) {
    this.supplierCode = supplierCode;
  }

}
