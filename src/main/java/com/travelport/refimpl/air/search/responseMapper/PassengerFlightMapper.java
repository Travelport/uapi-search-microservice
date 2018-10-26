package com.travelport.refimpl.air.search.responseMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travelport.refimpl.air.search.models.FlightProduct;
import com.travelport.refimpl.air.search.models.PassengerFlight;
import com.travelport.schema.air_v45_0.AirPricingInfo;
import com.travelport.schema.air_v45_0.BookingInfo;
import com.travelport.schema.air_v45_0.FareInfo;
import com.travelport.schema.air_v45_0.Option;

/**
 * The Class PassengerFlightMapper.
 */
@Component
public class PassengerFlightMapper {

  /** The brand mapper. */
  @Autowired
  BrandMapper brandMapper;

  /**
   * Map passenger flight.
   *
   * @param airPricingInfoList the air pricing info list
   * @param ppFareInfo the pp fare info
   * @param brandMap the brand map
   * @param flight the flight
   * @return the list
   */
  public List<PassengerFlight> mapPassengerFlight(List<AirPricingInfo> airPricingInfoList,
      Map<String, FareInfo> ppFareInfo, Map<String, com.travelport.schema.air_v45_0.Brand> brandMap,
      Option flight) {
    List<PassengerFlight> passengerFlights = new ArrayList<PassengerFlight>();

    for (AirPricingInfo airPricingInfo : airPricingInfoList) {
      PassengerFlight passengerFlight = new PassengerFlight();
      passengerFlight.setType("PassengerFlight");
      passengerFlight.setPassengerQuantity(airPricingInfo.getPassengerType().size());
      passengerFlight.setPassengerTypeCode(airPricingInfo.getPassengerType().get(0).getCode());
      passengerFlight
          .setFlightProduct(mapFlightProduct(airPricingInfo, ppFareInfo, brandMap, flight));

      passengerFlights.add(passengerFlight);
    }

    return passengerFlights;
  }

  /**
   * Map flight product.
   *
   * @param airPricingInfo the air pricing info
   * @param ppFareInfo the pp fare info
   * @param brandMap the brand map
   * @param flight the flight
   * @return the list
   */
  private List<FlightProduct> mapFlightProduct(AirPricingInfo airPricingInfo,
      Map<String, FareInfo> ppFareInfo, Map<String, com.travelport.schema.air_v45_0.Brand> brandMap,
      Option flight) {
    List<FlightProduct> flightProducts = new ArrayList<FlightProduct>();
    Integer sequenceIterator = 1;

    for (BookingInfo bookingInfo : flight.getBookingInfo()) {
      FlightProduct flightProduct = new FlightProduct();
      FareInfo fareInfo = ppFareInfo.get(bookingInfo.getFareInfoRef());
      List<Integer> segmentSequence = new ArrayList<Integer>();

      flightProduct.setType("FlightProduct");
      flightProduct.setClassOfService(bookingInfo.getBookingCode());
      flightProduct.setCabin(bookingInfo.getCabinClass());
      flightProduct.setFareBasisCode(fareInfo.getFareBasis());
      flightProduct.setPrivateFareInd(fareInfo.getPrivateFare() != null);
      segmentSequence.add(sequenceIterator++);
      flightProduct.setSegmentSequence(segmentSequence);
      flightProduct.setBrand(brandMapper.mapBrand(fareInfo, brandMap));

      flightProducts.add(flightProduct);
    }

    return flightProducts;
  }

}
