package com.travelport.refimpl.air.search.requestMapper;

import org.springframework.stereotype.Component;

import com.travelport.refimpl.air.search.models.FareSelection;
import com.travelport.refimpl.air.search.models.PricingModifiersAir;
import com.travelport.schema.air_v45_0.AirPricingModifiers;
import com.travelport.schema.air_v45_0.TypeFaresIndicator;

/**
 * The Class PriceModifiersMapper.
 */
@Component
public class PriceModifiersMapper {
  
  /**
   * Map air pricing modifiers.
   *
   * @param sccChannelId the scc channel id
   * @param pricingModifiersAir the pricing modifiers air
   * @return the air pricing modifiers
   */
  public AirPricingModifiers mapAirPricingModifiers(String sccChannelId,
      PricingModifiersAir pricingModifiersAir) {
    AirPricingModifiers airPricingModifiers = new AirPricingModifiers();
    airPricingModifiers.setChannelId(sccChannelId);

    if (pricingModifiersAir != null) {
      airPricingModifiers = mapFareSelectionModifiers(airPricingModifiers, pricingModifiersAir);
      airPricingModifiers.setCurrencyType(pricingModifiersAir.getCurrencyCode());
    }

    return airPricingModifiers;
  }

  /**
   * Map fare selection modifiers.
   *
   * @param airPricingModifiers the air pricing modifiers
   * @param pricingModifiersAir the pricing modifiers air
   * @return the air pricing modifiers
   */
  private AirPricingModifiers mapFareSelectionModifiers(AirPricingModifiers airPricingModifiers,
      PricingModifiersAir pricingModifiersAir)

  {
    FareSelection fareSelection = pricingModifiersAir.getFareSelection();

    if (fareSelection != null) {
      airPricingModifiers
          .setProhibitAdvancePurchaseFares(fareSelection.getProhibitAdvancePurchaseFaresInd());
      airPricingModifiers.setProhibitMaxStayFares(fareSelection.getProhibitMaxStayFaresInd());
      airPricingModifiers.setProhibitMinStayFares(fareSelection.getProhibitMinStayFaresInd());
      airPricingModifiers.setProhibitNonRefundableFares(fareSelection.getRefundableOnlyInd());
      airPricingModifiers.setFaresIndicator(mapFaresIndicator(airPricingModifiers, fareSelection));
    }

    return airPricingModifiers;
  }

  /**
   * Map fares indicator.
   *
   * @param airPricingModifiers the air pricing modifiers
   * @param fareSelection the fare selection
   * @return the type fares indicator
   */
  private TypeFaresIndicator mapFaresIndicator(AirPricingModifiers airPricingModifiers,
      FareSelection fareSelection) {
    TypeFaresIndicator indicator = null;
    String fareType = fareSelection.getFareType();

    if (fareType != null && !fareType.isEmpty()) {
      indicator = TypeFaresIndicator.fromValue(fareType);
    }

    return indicator;
  }
}
