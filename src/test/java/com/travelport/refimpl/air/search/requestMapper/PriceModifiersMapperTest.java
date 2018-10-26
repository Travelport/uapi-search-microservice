package com.travelport.refimpl.air.search.requestMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.travelport.refimpl.air.search.models.FareSelection;
import com.travelport.refimpl.air.search.models.PricingModifiersAir;
import com.travelport.refimpl.air.search.requestMapper.PriceModifiersMapper;
import com.travelport.schema.air_v45_0.AirPricingModifiers;
import com.travelport.schema.air_v45_0.TypeFaresIndicator;

public class PriceModifiersMapperTest {

  private static final PriceModifiersMapper MAPPER = new PriceModifiersMapper();

  @Test
  public void testMapAirPricingModifiersWithNoModifiers() {
    PricingModifiersAir req = new PricingModifiersAir();

    final AirPricingModifiers result = MAPPER.mapAirPricingModifiers(null, req);

    assertNull(result.getChannelId());
    assertNull(result.getCurrencyType());
    assertEquals(false, result.isProhibitAdvancePurchaseFares());
    assertEquals(false, result.isProhibitMaxStayFares());
    assertEquals(false, result.isProhibitMinStayFares());
    assertEquals(false, result.isProhibitNonRefundableFares());
    assertNull(result.getFaresIndicator());
  }

  @Test
  public void testMapAirPricingModifiersWithChannelId() {
    PricingModifiersAir req = new PricingModifiersAir();
    String channelId = "TEST";

    final AirPricingModifiers result = MAPPER.mapAirPricingModifiers(channelId, req);

    assertEquals(channelId, result.getChannelId());
    assertNull(result.getCurrencyType());
    assertEquals(false, result.isProhibitAdvancePurchaseFares());
    assertEquals(false, result.isProhibitMaxStayFares());
    assertEquals(false, result.isProhibitMinStayFares());
    assertEquals(false, result.isProhibitNonRefundableFares());
    assertNull(result.getFaresIndicator());
  }

  @Test
  public void testMapAirPricingModifiersWithCurrencyType() {
    PricingModifiersAir req = new PricingModifiersAir();
    req.setCurrencyCode("XXX");

    final AirPricingModifiers result = MAPPER.mapAirPricingModifiers(null, req);

    assertNull(result.getChannelId());
    assertEquals(req.getCurrencyCode(), result.getCurrencyType());
    assertEquals(false, result.isProhibitAdvancePurchaseFares());
    assertEquals(false, result.isProhibitMaxStayFares());
    assertEquals(false, result.isProhibitMinStayFares());
    assertEquals(false, result.isProhibitNonRefundableFares());
    assertNull(result.getFaresIndicator());
  }

  @Test
  public void testMapAirPricingModifiersWithProhibitAdvancePurchase() {
    PricingModifiersAir req = new PricingModifiersAir();
    FareSelection fareSelection = new FareSelection();
    fareSelection.setProhibitAdvancePurchaseFaresInd(true);
    req.setFareSelection(fareSelection);

    final AirPricingModifiers result = MAPPER.mapAirPricingModifiers(null, req);

    assertNull(result.getChannelId());
    assertNull(result.getCurrencyType());
    assertEquals(fareSelection.getProhibitAdvancePurchaseFaresInd(),
        result.isProhibitAdvancePurchaseFares());
    assertEquals(false, result.isProhibitMaxStayFares());
    assertEquals(false, result.isProhibitMinStayFares());
    assertEquals(false, result.isProhibitNonRefundableFares());
    assertNull(result.getFaresIndicator());
  }

  @Test
  public void testMapAirPricingModifiersWithMaxStayFares() {
    PricingModifiersAir req = new PricingModifiersAir();
    FareSelection fareSelection = new FareSelection();
    fareSelection.setProhibitMaxStayFaresInd(true);
    req.setFareSelection(fareSelection);

    final AirPricingModifiers result = MAPPER.mapAirPricingModifiers(null, req);

    assertNull(result.getChannelId());
    assertNull(result.getCurrencyType());
    assertEquals(false, result.isProhibitAdvancePurchaseFares());
    assertEquals(fareSelection.getProhibitMaxStayFaresInd(), result.isProhibitMaxStayFares());
    assertEquals(false, result.isProhibitMinStayFares());
    assertEquals(false, result.isProhibitNonRefundableFares());
    assertNull(result.getFaresIndicator());
  }

  @Test
  public void testMapAirPricingModifiersWithMinStayFares() {
    PricingModifiersAir req = new PricingModifiersAir();
    FareSelection fareSelection = new FareSelection();
    fareSelection.setProhibitMinStayFaresInd(true);
    req.setFareSelection(fareSelection);

    final AirPricingModifiers result = MAPPER.mapAirPricingModifiers(null, req);

    assertNull(result.getChannelId());
    assertNull(result.getCurrencyType());
    assertEquals(false, result.isProhibitAdvancePurchaseFares());
    assertEquals(false, result.isProhibitMaxStayFares());
    assertEquals(fareSelection.getProhibitMinStayFaresInd(), result.isProhibitMinStayFares());
    assertEquals(false, result.isProhibitNonRefundableFares());
    assertNull(result.getFaresIndicator());
  }

  @Test
  public void testMapAirPricingModifiersWithNonRefundableFares() {
    PricingModifiersAir req = new PricingModifiersAir();
    FareSelection fareSelection = new FareSelection();
    fareSelection.setRefundableOnlyInd(true);
    req.setFareSelection(fareSelection);

    final AirPricingModifiers result = MAPPER.mapAirPricingModifiers(null, req);

    assertNull(result.getChannelId());
    assertNull(result.getCurrencyType());
    assertEquals(false, result.isProhibitAdvancePurchaseFares());
    assertEquals(false, result.isProhibitMaxStayFares());
    assertEquals(false, result.isProhibitMinStayFares());
    assertEquals(fareSelection.getRefundableOnlyInd(), result.isProhibitNonRefundableFares());
    assertNull(result.getFaresIndicator());
  }

  @Test
  public void testMapAirPricingModifiersWithFaresIndicator() {
    PricingModifiersAir req = new PricingModifiersAir();
    FareSelection fareSelection = new FareSelection();
    fareSelection.setFareType("PrivateFaresOnly");
    req.setFareSelection(fareSelection);

    final AirPricingModifiers result = MAPPER.mapAirPricingModifiers(null, req);

    assertNull(result.getChannelId());
    assertNull(result.getCurrencyType());
    assertEquals(false, result.isProhibitAdvancePurchaseFares());
    assertEquals(false, result.isProhibitMaxStayFares());
    assertEquals(false, result.isProhibitMinStayFares());
    assertEquals(false, result.isProhibitNonRefundableFares());
    assertEquals(TypeFaresIndicator.PRIVATE_FARES_ONLY, result.getFaresIndicator());
  }
}
