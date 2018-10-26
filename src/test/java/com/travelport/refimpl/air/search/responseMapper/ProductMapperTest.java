package com.travelport.refimpl.air.search.responseMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.travelport.refimpl.air.search.models.FlightSegment;
import com.travelport.refimpl.air.search.models.PassengerFlight;
import com.travelport.refimpl.air.search.models.ProductOption;
import com.travelport.schema.air_v45_0.AirPricePoint;
import com.travelport.schema.air_v45_0.AirPricingInfo;
import com.travelport.schema.air_v45_0.BookingInfo;
import com.travelport.schema.air_v45_0.FareInfo;
import com.travelport.schema.air_v45_0.FlightOption;
import com.travelport.schema.air_v45_0.FlightOptionsList;
import com.travelport.schema.air_v45_0.Option;
import com.travelport.schema.air_v45_0.TypeBaseAirSegment;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMapperTest {

  @MockBean
  FlightSegmentsMapper flightSegmentsMapper;

  @MockBean
  PassengerFlightMapper passengerFlightMapper;

  @Autowired
  ProductMapper productMapper;

  AirPricePoint pricePoint = new AirPricePoint();
  Map<String, FareInfo> ppFareInfo = new HashMap<String, FareInfo>();
  Map<String, TypeBaseAirSegment> segmentsMap = new HashMap<String, TypeBaseAirSegment>();
  Map<String, com.travelport.schema.air_v45_0.Brand> brandMap = new HashMap<String, com.travelport.schema.air_v45_0.Brand>();
  Option option = new Option();

  @Before
  public void populateProductMapperArgs() throws DatatypeConfigurationException {
    BookingInfo bookingInfo1 = new BookingInfo();
    bookingInfo1.setFareInfoRef("ref_1");
    bookingInfo1.setBookingCount("7");
    BookingInfo bookingInfo2 = new BookingInfo();
    bookingInfo2.setFareInfoRef("ref_2");
    bookingInfo2.setBookingCount("3");

    option.getBookingInfo().add(bookingInfo1);
    option.getBookingInfo().add(bookingInfo2);
    option.setTravelTime(DatatypeFactory.newInstance().newDuration("PT45H50M"));

    FlightOption flightOption = new FlightOption();
    flightOption.getOption().add(option);

    FlightOptionsList flightOptionsList = new FlightOptionsList();
    flightOptionsList.getFlightOption().add(flightOption);

    AirPricingInfo airPricingInfo = new AirPricingInfo();
    airPricingInfo.setFlightOptionsList(flightOptionsList);

    pricePoint.getAirPricingInfo().add(airPricingInfo);
  }

  @Test
  public void productMapperBasicTest() {

    List<FlightSegment> flightSegmentList = new ArrayList<FlightSegment>();
    List<PassengerFlight> passengerFlightList = new ArrayList<PassengerFlight>();

    // Set up mockBean responses
    Mockito.when(
        flightSegmentsMapper.mapFlightSegments(Mockito.any(Option.class), Mockito.eq(segmentsMap)))
        .thenReturn(flightSegmentList);

    Mockito
        .when(passengerFlightMapper.mapPassengerFlight(Mockito.eq(pricePoint.getAirPricingInfo()),
            Mockito.eq(ppFareInfo), Mockito.eq(brandMap), Mockito.eq(option)))
        .thenReturn(passengerFlightList);

    // Call the function being tested
    List<ProductOption> productOptions = productMapper.mapProductOptions(pricePoint, ppFareInfo,
        segmentsMap, brandMap);

    // Asserts
    assertNotNull(productOptions);
    assertEquals("p0", productOptions.get(0).getProduct().get(0).getId());
    assertEquals("PT45H50M", productOptions.get(0).getProduct().get(0).getTotalDuration());
    assertEquals(passengerFlightList,
        productOptions.get(0).getProduct().get(0).getPassengerFlight());
    assertEquals(flightSegmentList, productOptions.get(0).getProduct().get(0).getFlightSegment());
  }

  @Test
  public void productMapperLowestAvailabilityTest() {
    // Set up mockBean responses
    Mockito.when(
        flightSegmentsMapper.mapFlightSegments(Mockito.any(Option.class), Mockito.eq(segmentsMap)))
        .thenReturn(new ArrayList<FlightSegment>());

    Mockito
        .when(passengerFlightMapper.mapPassengerFlight(Mockito.eq(pricePoint.getAirPricingInfo()),
            Mockito.eq(ppFareInfo), Mockito.eq(brandMap), Mockito.eq(option)))
        .thenReturn(new ArrayList<PassengerFlight>());

    // Call the function being tested
    List<ProductOption> productOptions = productMapper.mapProductOptions(pricePoint, ppFareInfo,
        segmentsMap, brandMap);

    // Asserts
    assertNotNull(productOptions);
    assertEquals("p0", productOptions.get(0).getProduct().get(0).getId());
    assertEquals("PT45H50M", productOptions.get(0).getProduct().get(0).getTotalDuration());
    assertEquals(3, productOptions.get(0).getProduct().get(0).getQuantity().intValue());
  }

}
