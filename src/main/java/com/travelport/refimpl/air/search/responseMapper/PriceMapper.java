package com.travelport.refimpl.air.search.responseMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.travelport.refimpl.air.search.models.Amount;
import com.travelport.refimpl.air.search.models.Fees;
import com.travelport.refimpl.air.search.models.Price;
import com.travelport.refimpl.air.search.models.PriceBreakdown;
import com.travelport.refimpl.air.search.models.PriceDetail;
import com.travelport.refimpl.air.search.models.Taxes;
import com.travelport.schema.air_v45_0.AirPricePoint;
import com.travelport.schema.air_v45_0.AirPricingInfo;

/**
 * The Class PriceMapper.
 */
@Component
public class PriceMapper {

  /**
   * Map price.
   *
   * @param pricePoint the price point
   * @param view the view
   * @return the price
   */
  public Price mapPrice(AirPricePoint pricePoint, String view) {
    PriceDetail price = new PriceDetail();

    price.setType("Price");
    price.setBase(Double.valueOf(pricePoint.getApproximateBasePrice().substring(3)));
    price.setCurrencyCode(pricePoint.getApproximateBasePrice().substring(0, 3));
    price.setTotalTaxes(Double.valueOf(pricePoint.getApproximateTaxes().substring(3)));
    if (pricePoint.getApproximateFees() != null) {
      price.setTotalFees(Double.valueOf(pricePoint.getApproximateFees().substring(3)));
    }
    price.setTotalPrice(Double.valueOf(pricePoint.getApproximateTotalPrice().substring(3)));
    if (view != null && view.equals("detail")) {
      price.setType("PriceDetail");
      price.setPriceBreakdown(mapPriceBreakdowns(pricePoint));
    }

    return (Price) price;
  }

  /**
   * Map price breakdowns.
   *
   * @param pricePoint the price point
   * @return the list
   */
  private List<PriceBreakdown> mapPriceBreakdowns(AirPricePoint pricePoint) {
    List<PriceBreakdown> priceBreakdowns = new ArrayList<PriceBreakdown>();

    for (AirPricingInfo airPricingInfo : pricePoint.getAirPricingInfo()) {
      PriceBreakdown priceBreakdown = new PriceBreakdown();
      priceBreakdown.setType("PriceBreakdownAir");
      priceBreakdown.setQuantity(airPricingInfo.getPassengerType().size());
      priceBreakdown.setRequestedPassengerType(airPricingInfo.getPassengerType().get(0).getCode());
      priceBreakdown.setAmount(mapAmount(airPricingInfo));
      priceBreakdowns.add(priceBreakdown);
    }

    return priceBreakdowns;
  }

  /**
   * Map amount.
   *
   * @param airPricingInfo the air pricing info
   * @return the amount
   */
  private Amount mapAmount(AirPricingInfo airPricingInfo) {
    Amount amount = new Amount();

    amount.setType("Amount");
    amount.setBase(Double.valueOf(airPricingInfo.getApproximateBasePrice().substring(3)));
    amount.setTotal(Double.valueOf(airPricingInfo.getApproximateTotalPrice().substring(3)));
    amount.setTaxes(mapTaxes(airPricingInfo));
    amount.setFees(mapFees(airPricingInfo));

    return amount;
  }

  /**
   * Map taxes.
   *
   * @param airPricingInfo the air pricing info
   * @return the taxes
   */
  private Taxes mapTaxes(AirPricingInfo airPricingInfo) {
    Taxes taxes = new Taxes();

    if (airPricingInfo.getApproximateTaxes() != null) {
      if (airPricingInfo.getApproximateTaxes() != null) {
        taxes.setType("Taxes");
        taxes.setTotalTaxes(Double.valueOf(airPricingInfo.getApproximateTaxes().substring(3)));
      }
    } else if (airPricingInfo.getTaxes() != null) {
      if (airPricingInfo.getTaxes() != null) {
        taxes.setType("Taxes");
        taxes.setTotalTaxes(Double.valueOf(airPricingInfo.getTaxes().substring(3)));
      }
    }

    return taxes;
  }

  /**
   * Map fees.
   *
   * @param airPricingInfo the air pricing info
   * @return the fees
   */
  private Fees mapFees(AirPricingInfo airPricingInfo) {
    Fees fees = new Fees();

    if (airPricingInfo.getApproximateFees() != null) {
      if (airPricingInfo.getApproximateFees() != null) {
        fees.setType("Fees");
        fees.setTotalFees(Double.valueOf(airPricingInfo.getApproximateFees().substring(3)));
      }
    } else if (airPricingInfo.getFees() != null) {
      if (airPricingInfo.getFees() != null) {
        fees.setType("Fees");
        fees.setTotalFees(Double.valueOf(airPricingInfo.getFees().substring(3)));
      }
    }

    return fees;
  }

}
