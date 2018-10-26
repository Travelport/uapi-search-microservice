
package com.travelport.refimpl.air.search.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "@type", "id", "sequence", "ProductOptionsRef", "Product" })
public class ProductOption {

  @JsonProperty("@type")
  private String type;
  @JsonProperty("id")
  private String id;
  @JsonProperty("sequence")
  private Integer sequence;
  @JsonProperty("ProductOptionsRef")
  private String productOptionsRef;
  @JsonProperty("Product")
  private List<Product> product = null;

  /**
   * No args constructor for use in serialization
   * 
   */
  public ProductOption() {
  }

  /**
   * 
   * @param product
   * @param id
   * @param productOptionsRef
   * @param sequence
   * @param type
   */
  public ProductOption(String type, String id, Integer sequence, String productOptionsRef,
      List<Product> product) {
    super();
    this.type = type;
    this.id = id;
    this.sequence = sequence;
    this.productOptionsRef = productOptionsRef;
    this.product = product;
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

  @JsonProperty("sequence")
  public Integer getSequence() {
    return sequence;
  }

  @JsonProperty("sequence")
  public void setSequence(Integer sequence) {
    this.sequence = sequence;
  }

  @JsonProperty("ProductOptionsRef")
  public String getProductOptionsRef() {
    return productOptionsRef;
  }

  @JsonProperty("ProductOptionsRef")
  public void setProductOptionsRef(String productOptionsRef) {
    this.productOptionsRef = productOptionsRef;
  }

  @JsonProperty("Product")
  public List<Product> getProduct() {
    return product;
  }

  @JsonProperty("Product")
  public void setProduct(List<Product> product) {
    this.product = product;
  }

}
