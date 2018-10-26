package com.travelport.refimpl.air.search.responseMapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.travelport.refimpl.air.search.models.Price;
import com.travelport.refimpl.air.search.models.PriceBreakdown;
import com.travelport.refimpl.air.search.models.PriceDetail;
import com.travelport.schema.air_v45_0.AirPricePoint;
import com.travelport.schema.air_v45_0.AirPricingInfo;
import com.travelport.schema.air_v45_0.PassengerType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PriceMapperTest {

  @Autowired
  PriceMapper priceMapper;

  AirPricePoint pricePoint = new AirPricePoint();

  @Before
  public void populatePriceMapperArgs() {
    PassengerType adult = new PassengerType();
    adult.setCode("ADT");

    PassengerType child = new PassengerType();
    child.setCode("CHD");

    AirPricingInfo adultInfo = new AirPricingInfo();
    adultInfo.getPassengerType().add(adult);
    adultInfo.setApproximateBasePrice("USD30.00");
    adultInfo.setApproximateTotalPrice("USD40.00");
    adultInfo.setApproximateTaxes("USD10.00");
    adultInfo.setApproximateFees("USD0.00");

    AirPricingInfo childInfo = new AirPricingInfo();
    childInfo.getPassengerType().add(child);
    childInfo.setApproximateBasePrice("USD30.00");
    childInfo.setApproximateTotalPrice("USD40.00");
    childInfo.setApproximateTaxes("USD10.00");
    childInfo.setApproximateFees("USD0.00");

    pricePoint.getAirPricingInfo().add(adultInfo);
    pricePoint.getAirPricingInfo().add(childInfo);

    pricePoint.setApproximateBasePrice("USD60.00");
    pricePoint.setApproximateTaxes("USD20.00");
    pricePoint.setApproximateTotalPrice("USD80.00");
    pricePoint.setApproximateFees("USD0.00");
  }

  @Test
  public void priceMapperBasicTest() {
    Price price = priceMapper.mapPrice(pricePoint, null);
    assertNotNull(price);
    assertEquals("USD", price.getCurrencyCode());
    assertEquals("Price", price.getType());
    assertEquals(Double.valueOf(60.00), price.getBase());
    assertEquals(Double.valueOf(80.00), price.getTotalPrice());
    assertEquals(Double.valueOf(20.00), price.getTotalTaxes());
    assertEquals(Double.valueOf(0.00), price.getTotalFees());
  }

  @Test
  public void priceMapperDetailsTest() {
    Price price = priceMapper.mapPrice(pricePoint, "detail");
    PriceDetail priceDetail = (PriceDetail) price;
    List<PriceBreakdown> priceBreakdowns = priceDetail.getPriceBreakdown();
    assertNotNull(price);
    assertNotNull(priceBreakdowns);
    assertEquals("USD", price.getCurrencyCode());
    assertEquals("PriceDetail", price.getType());
    assertEquals(Double.valueOf(80.00), price.getTotalPrice());
    assertEquals(Double.valueOf(20.00), price.getTotalTaxes());
    assertEquals(Double.valueOf(0.00), price.getTotalFees());
    assertEquals(2, priceBreakdowns.size());

    assertEquals("ADT", priceBreakdowns.get(0).getRequestedPassengerType());
    assertEquals(Double.valueOf(30.00), priceBreakdowns.get(0).getAmount().getBase());
    assertEquals(Double.valueOf(40.00), priceBreakdowns.get(0).getAmount().getTotal());
    assertEquals(Double.valueOf(10.00),
        priceBreakdowns.get(0).getAmount().getTaxes().getTotalTaxes());
    assertEquals(Double.valueOf(0.00), priceBreakdowns.get(0).getAmount().getFees().getTotalFees());

    assertEquals("CHD", priceBreakdowns.get(1).getRequestedPassengerType());
    assertEquals(Double.valueOf(30.00), priceBreakdowns.get(1).getAmount().getBase());
    assertEquals(Double.valueOf(40.00), priceBreakdowns.get(1).getAmount().getTotal());
    assertEquals(Double.valueOf(10.00),
        priceBreakdowns.get(1).getAmount().getTaxes().getTotalTaxes());
    assertEquals(Double.valueOf(0.00), priceBreakdowns.get(1).getAmount().getFees().getTotalFees());
  }

}
