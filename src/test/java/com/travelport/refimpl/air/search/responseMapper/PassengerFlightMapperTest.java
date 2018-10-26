package com.travelport.refimpl.air.search.responseMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.travelport.refimpl.air.search.models.PassengerFlight;
import com.travelport.schema.air_v45_0.AirPricingInfo;
import com.travelport.schema.air_v45_0.BookingInfo;
import com.travelport.schema.air_v45_0.Brand;
import com.travelport.schema.air_v45_0.FareInfo;
import com.travelport.schema.air_v45_0.FlightOption;
import com.travelport.schema.air_v45_0.FlightOptionsList;
import com.travelport.schema.air_v45_0.Option;
import com.travelport.schema.air_v45_0.PassengerType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PassengerFlightMapperTest {

  @MockBean
  BrandMapper brandMapper;

  @Autowired
  PassengerFlightMapper passengerFlightMapper;

  Map<String, Brand> brandMap = new HashMap<String, Brand>();
  FareInfo fareInfo1 = new FareInfo();
  FareInfo fareInfo2 = new FareInfo();
  Map<String, FareInfo> ppFareInfo = new HashMap<String, FareInfo>();
  List<AirPricingInfo> airPricingInfoList = new ArrayList<AirPricingInfo>();
  Option option = new Option();

  @Before
  public void populatePassengerFlightMapperArgs() {
    BookingInfo bookingInfo1 = new BookingInfo();
    bookingInfo1.setFareInfoRef("ref_1");
    bookingInfo1.setCabinClass("Economy");
    bookingInfo1.setBookingCode("G");

    BookingInfo bookingInfo2 = new BookingInfo();
    bookingInfo2.setFareInfoRef("ref_2");
    bookingInfo2.setCabinClass("Economy");
    bookingInfo2.setBookingCode("F");

    option.getBookingInfo().add(bookingInfo1);
    option.getBookingInfo().add(bookingInfo2);

    FlightOption flightOption = new FlightOption();
    flightOption.getOption().add(option);

    FlightOptionsList flightOptionsList = new FlightOptionsList();
    flightOptionsList.getFlightOption().add(flightOption);

    PassengerType adult = new PassengerType();
    adult.setCode("ADT");

    AirPricingInfo airPricingInfo = new AirPricingInfo();
    airPricingInfo.setFlightOptionsList(flightOptionsList);
    airPricingInfo.getPassengerType().add(adult);
    airPricingInfoList.add(airPricingInfo);

    fareInfo1.setFareBasis("FOO_CODE1");
    fareInfo2.setFareBasis("FOO_CODE2");

    ppFareInfo.put("ref_1", fareInfo1);
    ppFareInfo.put("ref_2", fareInfo2);
  }

  @Test
  public void passengerFlightMapperTest() {
    List<PassengerFlight> passengerFlights = passengerFlightMapper
        .mapPassengerFlight(airPricingInfoList, ppFareInfo, brandMap, option);
    assertNotNull(passengerFlights);
    assertEquals(1, passengerFlights.size());
    assertEquals("ADT", passengerFlights.get(0).getPassengerTypeCode());
    assertEquals(1, passengerFlights.get(0).getPassengerQuantity().intValue());
    assertEquals("FOO_CODE1", passengerFlights.get(0).getFlightProduct().get(0).getFareBasisCode());
    assertEquals(false, passengerFlights.get(0).getFlightProduct().get(0).getPrivateFareInd());
    assertEquals("G", passengerFlights.get(0).getFlightProduct().get(0).getClassOfService());
    assertEquals("Economy", passengerFlights.get(0).getFlightProduct().get(0).getCabin());
  }

}
