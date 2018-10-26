package com.travelport.refimpl.air.search.responseMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.travelport.refimpl.air.search.models.BaggageAllowance;
import com.travelport.refimpl.air.search.models.BaggageItem;
import com.travelport.refimpl.air.search.models.TermsAndConditions;
import com.travelport.schema.air_v45_0.AirPricePoint;
import com.travelport.schema.air_v45_0.BookingInfo;
import com.travelport.schema.air_v45_0.FareInfo;
import com.travelport.schema.air_v45_0.FlightOption;
import com.travelport.schema.air_v45_0.Option;

/**
 * The Class TermsAndConditionsObjectMapper.
 */
@Component
public class TermsAndConditionsObjectMapper {

  /**
   * Map terms and conditions.
   *
   * @param pricePoint the price point
   * @param ppFareInfo the pp fare info
   * @return the terms and conditions
   */
  public TermsAndConditions mapTermsAndConditions(AirPricePoint pricePoint,
      Map<String, FareInfo> ppFareInfo) {
    TermsAndConditions termsAndConditions = new TermsAndConditions();

    termsAndConditions.setType("TermsAndConditions");
    termsAndConditions
        .setExpiryDate(pricePoint.getAirPricingInfo().get(0).getLatestTicketingTime());
    termsAndConditions
        .setValidatingCarrier(pricePoint.getAirPricingInfo().get(0).getPlatingCarrier());
    termsAndConditions.setBaggageAllowance(mapBaggageAllowances(pricePoint, ppFareInfo));

    return termsAndConditions;
  }

  /**
   * Map baggage allowances.
   *
   * @param pricePoint the price point
   * @param ppFareInfo the pp fare info
   * @return the list
   */
  private List<BaggageAllowance> mapBaggageAllowances(AirPricePoint pricePoint,
      Map<String, FareInfo> ppFareInfo) {
    List<BaggageAllowance> baggageAllowances = new ArrayList<BaggageAllowance>();
    BaggageAllowance baggage = new BaggageAllowance();
    baggage.setType("BaggageAllowance");
    baggage.setBaggageItem(mapBaggageItems(pricePoint, ppFareInfo));

    if (baggage.getBaggageItem() != null) {
      baggage.setProductRef(mapProductRef(
          pricePoint.getAirPricingInfo().get(0).getFlightOptionsList().getFlightOption()));
      baggageAllowances.add(baggage);
    }

    return baggage.getBaggageItem() != null ? baggageAllowances : null;
  }

  /**
   * Map baggage items.
   *
   * @param pricePoint the price point
   * @param ppFareInfo the pp fare info
   * @return the list
   */
  private List<BaggageItem> mapBaggageItems(AirPricePoint pricePoint,
      Map<String, FareInfo> ppFareInfo) {
    List<BaggageItem> baggageItems = null;
    int baggageQuantity = mapBaggageQuantity(pricePoint, ppFareInfo);

    if (baggageQuantity != -1) {
      BaggageItem baggageItem = new BaggageItem();
      baggageItems = new ArrayList<BaggageItem>();
      baggageItem.setType("BaggageItem");
      baggageItem.setQuantity(baggageQuantity);
      baggageItems.add(baggageItem);
    }

    return baggageItems;
  }

  /**
   * Map baggage quantity.
   *
   * @param pricePoint the price point
   * @param ppFareInfo the pp fare info
   * @return the int
   */
  private int mapBaggageQuantity(AirPricePoint pricePoint, Map<String, FareInfo> ppFareInfo) {
    int baggageQuantity = -1;

    FlightOptionLoop: for (FlightOption flightOption : pricePoint.getAirPricingInfo().get(0)
        .getFlightOptionsList().getFlightOption()) {
      Option option = flightOption.getOption().get(0);
      for (BookingInfo bookingInfo : option.getBookingInfo()) {
        baggageQuantity = getLesserBaggageQuantity(ppFareInfo.get(bookingInfo.getFareInfoRef()),
            baggageQuantity);
        if (baggageQuantity == -1) {
          break FlightOptionLoop;
        }
      }
    }
    return baggageQuantity;
  }

  /**
   * Gets the lesser baggage quantity.
   *
   * @param fareInfo the fare info
   * @param baggageQuantity the baggage quantity
   * @return the lesser baggage quantity
   */
  private int getLesserBaggageQuantity(FareInfo fareInfo, int baggageQuantity) {
    // If there is no baggageAllowance in the fareInfo, exit with -1
    if (fareInfo.getBaggageAllowance() == null
        || fareInfo.getBaggageAllowance().getNumberOfPieces() == null) {
      baggageQuantity = -1;
    } else if (fareInfo.getBaggageAllowance().getNumberOfPieces().intValue() < baggageQuantity
        || baggageQuantity == -1) {
      baggageQuantity = fareInfo.getBaggageAllowance().getNumberOfPieces().intValue();
    }
    return baggageQuantity;
  }

  /**
   * Map product ref.
   *
   * @param flightOptions the flight options
   * @return the list
   */
  private List<String> mapProductRef(List<FlightOption> flightOptions) {
    List<String> productRef = new ArrayList<String>();
    int nProducts = flightOptions.size();
    int iterator = 0;

    while (iterator < nProducts) {
      productRef.add("p" + iterator++);
    }

    return productRef;
  }
}
