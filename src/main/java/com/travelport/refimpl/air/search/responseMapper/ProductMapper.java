package com.travelport.refimpl.air.search.responseMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travelport.refimpl.air.search.models.Product;
import com.travelport.refimpl.air.search.models.ProductOption;
import com.travelport.schema.air_v45_0.AirPricePoint;
import com.travelport.schema.air_v45_0.AirPricingInfo;
import com.travelport.schema.air_v45_0.BookingInfo;
import com.travelport.schema.air_v45_0.FareInfo;
import com.travelport.schema.air_v45_0.FlightOption;
import com.travelport.schema.air_v45_0.Option;
import com.travelport.schema.air_v45_0.TypeBaseAirSegment;

/**
 * The Class ProductMapper.
 */
@Component
public class ProductMapper {

  /** The flight segments mapper. */
  @Autowired
  FlightSegmentsMapper flightSegmentsMapper;

  /** The passenger flight mapper. */
  @Autowired
  PassengerFlightMapper passengerFlightMapper;

  /**
   * Map product options.
   *
   * @param pricePoint the price point
   * @param ppFareInfo the pp fare info
   * @param segmentsMap the segments map
   * @param brandMap the brand map
   * @return the list
   */
  public List<ProductOption> mapProductOptions(AirPricePoint pricePoint,
      Map<String, FareInfo> ppFareInfo, Map<String, TypeBaseAirSegment> segmentsMap,
      Map<String, com.travelport.schema.air_v45_0.Brand> brandMap) {
    // TripServices::List<ProductOption> == UAPI::List<FlightOption>
    List<ProductOption> productOptions = new ArrayList<ProductOption>();
    List<AirPricingInfo> airPricingInfoList = pricePoint.getAirPricingInfo();
    int flightOptionIterator = 1;

    for (FlightOption flightOption : airPricingInfoList.get(0).getFlightOptionsList()
        .getFlightOption()) {
      ProductOption productOption = new ProductOption();
      productOption.setType("ProductOptions");
      productOption.setSequence(flightOptionIterator++);
      productOption.setProduct(
          mapProducts(flightOption, airPricingInfoList, ppFareInfo, segmentsMap, brandMap));
      productOptions.add(productOption);
    }

    return productOptions;
  }

  /**
   * Map products.
   *
   * @param flightOption the flight option
   * @param airPricingInfoList the air pricing info list
   * @param ppFareInfo the pp fare info
   * @param segmentsMap the segments map
   * @param brandMap the brand map
   * @return the list
   */
  private List<Product> mapProducts(FlightOption flightOption,
      List<AirPricingInfo> airPricingInfoList, Map<String, FareInfo> ppFareInfo,
      Map<String, TypeBaseAirSegment> segmentsMap,
      Map<String, com.travelport.schema.air_v45_0.Brand> brandMap) {
    List<Product> products = new ArrayList<Product>();
    int optionIterator = 0;

    // TripServices::Product == UAPI::Option
    for (Option flight : flightOption.getOption()) {
      Product product = mapProduct(flight, segmentsMap, ppFareInfo, brandMap, airPricingInfoList);
      product.setId("p" + optionIterator++);
      products.add(product);
    }

    return products;
  }

  /**
   * Map product.
   *
   * @param flight the flight
   * @param segmentsMap the segments map
   * @param ppFareInfo the pp fare info
   * @param brandMap the brand map
   * @param airPricingInfoList the air pricing info list
   * @return the product
   */
  private Product mapProduct(Option flight, Map<String, TypeBaseAirSegment> segmentsMap,
      Map<String, FareInfo> ppFareInfo, Map<String, com.travelport.schema.air_v45_0.Brand> brandMap,
      List<AirPricingInfo> airPricingInfoList) {
    Product product = new Product();

    product.setTotalDuration(flight.getTravelTime().toString());
    product.setType("ProductAir");
    product.setQuantity(getLowestAvailableQuantity(flight.getBookingInfo()));
    product.setFlightSegment(flightSegmentsMapper.mapFlightSegments(flight, segmentsMap));
    product.setPassengerFlight(
        passengerFlightMapper.mapPassengerFlight(airPricingInfoList, ppFareInfo, brandMap, flight));

    return product;
  }

  /**
   * Gets the lowest available quantity.
   *
   * @param bookingInfoList the booking info list
   * @return the lowest available quantity
   */
  private Integer getLowestAvailableQuantity(List<BookingInfo> bookingInfoList) {
    Integer quantity = 0;

    for (BookingInfo bookingInfo : bookingInfoList) {
      Integer legQuantity = Integer.valueOf(bookingInfo.getBookingCount());
      if (quantity == 0 || legQuantity < quantity) {
        quantity = legQuantity;
      }
    }

    return quantity;
  }

}
