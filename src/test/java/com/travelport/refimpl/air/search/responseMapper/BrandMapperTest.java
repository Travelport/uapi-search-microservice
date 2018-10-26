package com.travelport.refimpl.air.search.responseMapper;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.travelport.refimpl.air.search.models.Brand;
import com.travelport.schema.air_v45_0.FareInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BrandMapperTest {

  @Autowired
  BrandMapper brandMapper;

  FareInfo fareInfo = new FareInfo();
  Map<String, com.travelport.schema.air_v45_0.Brand> brandMap = new HashMap<String, com.travelport.schema.air_v45_0.Brand>();

  @Before
  public void populateBrandMapperArgs() {
    com.travelport.schema.air_v45_0.Brand uapiBrand = new com.travelport.schema.air_v45_0.Brand();
    uapiBrand.setBrandTier("0001");
    uapiBrand.setBrandID("12345");
    uapiBrand.setKey("ABCDE");
    fareInfo.setBrand(uapiBrand);
    uapiBrand.setName("Premium Economy");
    brandMap.put("12345", uapiBrand);
  }

  @Test
  public void brandMapperNullTest() {
    FareInfo fareInfo_nullBrand = new FareInfo();
    Brand brand = brandMapper.mapBrand(fareInfo_nullBrand, brandMap);
    assertNull(brand);
  }

  @Test
  public void brandMapperTest() {
    Brand brand = brandMapper.mapBrand(fareInfo, brandMap);
    assertNotNull(brand);
    assertEquals("12345", brand.getId());
    assertEquals(1, brand.getTier().intValue());
    assertEquals("ABCDE", brand.getBrandRef());
    assertEquals("Premium Economy", brand.getName());
  }

}
