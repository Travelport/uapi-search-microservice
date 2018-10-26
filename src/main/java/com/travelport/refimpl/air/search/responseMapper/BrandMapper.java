package com.travelport.refimpl.air.search.responseMapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.travelport.refimpl.air.search.models.Brand;
import com.travelport.schema.air_v45_0.FareInfo;

/**
 * The Class BrandMapper.
 */
@Component
public class BrandMapper {

  /**
   * Map brand.
   *
   * @param fareInfo the fare info
   * @param brandMap the brand map
   * @return the brand
   */
  public Brand mapBrand(FareInfo fareInfo,
      Map<String, com.travelport.schema.air_v45_0.Brand> brandMap) {
    Brand brand = null;
    com.travelport.schema.air_v45_0.Brand uapiBrand = fareInfo.getBrand();

    if (uapiBrand != null) {
      brand = new Brand();
      brand.setType("Brand");
      if (uapiBrand.getBrandTier() != null) {
        brand.setTier(Integer.valueOf(uapiBrand.getBrandTier()));
      }
      brand.setId(uapiBrand.getBrandID());
      brand.setBrandRef(uapiBrand.getKey());
      brand.setName(mapBrandName(uapiBrand.getBrandID(), brandMap));
    }

    return brand;
  }

  /**
   * Map brand name.
   *
   * @param brandId the brand id
   * @param brandMap the brand map
   * @return the string
   */
  private String mapBrandName(String brandId,
      Map<String, com.travelport.schema.air_v45_0.Brand> brandMap) {
    String brandName = null;
    com.travelport.schema.air_v45_0.Brand uapiBrand = brandMap.get(brandId);

    if (uapiBrand != null) {
      brandName = uapiBrand.getName();
    }

    return brandName;
  }
}
