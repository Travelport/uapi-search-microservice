
package com.travelport.refimpl.air.search.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "Account" })
public class FareModifiers {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("Account")
  private List<Account> account = null;

  /**
   * No args constructor for use in serialization
   * 
   */
  public FareModifiers() {
  }

  /**
   * 
   * @param account
   * @param type
   */
  public FareModifiers(String type, List<Account> account) {
    super();
    this.type = type;
    this.account = account;
  }

  @JsonProperty("@type")
  public String getType() {
    return type;
  }

  @JsonProperty("@type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("Account")
  public List<Account> getAccount() {
    return account;
  }

  @JsonProperty("Account")
  public void setAccount(List<Account> account) {
    this.account = account;
  }

}
