package com.travelport.refimpl.air.search.responseMapper;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.travelport.refimpl.air.search.models.TermsAndConditions;
import com.travelport.schema.air_v45_0.AirPricePoint;
import com.travelport.schema.air_v45_0.AirPricingInfo;
import com.travelport.schema.air_v45_0.BaggageAllowance;
import com.travelport.schema.air_v45_0.BookingInfo;
import com.travelport.schema.air_v45_0.FareInfo;
import com.travelport.schema.air_v45_0.FlightOption;
import com.travelport.schema.air_v45_0.FlightOptionsList;
import com.travelport.schema.air_v45_0.Option;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TermsAndConditionsObjectMapperTest {

  @Autowired
  TermsAndConditionsObjectMapper tcMapper;

  AirPricePoint pricePoint = new AirPricePoint();
  FareInfo fareInfo1 = new FareInfo();
  FareInfo fareInfo2 = new FareInfo();
  Map<String, FareInfo> ppFareInfo = new HashMap<String, FareInfo>();

  @Before
  public void populateTermsAndConditionsArgs() {
    BookingInfo bookingInfo1 = new BookingInfo();
    bookingInfo1.setFareInfoRef("ref_1");
    BookingInfo bookingInfo2 = new BookingInfo();
    bookingInfo2.setFareInfoRef("ref_2");

    Option option = new Option();
    option.getBookingInfo().add(bookingInfo1);
    option.getBookingInfo().add(bookingInfo2);

    FlightOption flightOption = new FlightOption();
    flightOption.getOption().add(option);

    FlightOptionsList flightOptionsList = new FlightOptionsList();
    flightOptionsList.getFlightOption().add(flightOption);

    AirPricingInfo airPricingInfo = new AirPricingInfo();
    airPricingInfo.setFlightOptionsList(flightOptionsList);

    pricePoint.getAirPricingInfo().add(airPricingInfo);

    BaggageAllowance bag1 = new BaggageAllowance();
    BaggageAllowance bag2 = new BaggageAllowance();
    bag1.setNumberOfPieces(BigInteger.valueOf(2));
    fareInfo1.setBaggageAllowance(bag1);
    bag2.setNumberOfPieces(BigInteger.valueOf(4));
    fareInfo2.setBaggageAllowance(bag2);

    ppFareInfo.put("ref_1", fareInfo1);
    ppFareInfo.put("ref_2", fareInfo2);
  }

  @Test
  public void termsAndConditionsObjectMapperValidatingCarrierTest() {
    pricePoint.getAirPricingInfo().get(0).setPlatingCarrier("UA");
    TermsAndConditions termsAndConditions = tcMapper.mapTermsAndConditions(pricePoint, ppFareInfo);
    assertNotNull(termsAndConditions);
    assertEquals("UA", termsAndConditions.getValidatingCarrier());
    assertNull(termsAndConditions.getExpiryDate());
  }

  @Test
  public void termsAndConditionsObjectMapperExpiryDateTest() {
    pricePoint.getAirPricingInfo().get(0).setLatestTicketingTime("2018-10-04");
    TermsAndConditions termsAndConditions = tcMapper.mapTermsAndConditions(pricePoint, ppFareInfo);
    assertNotNull(termsAndConditions);
    assertEquals("2018-10-04", termsAndConditions.getExpiryDate());
    assertNull(termsAndConditions.getValidatingCarrier());
  }

  @Test
  public void termsAndConditionsObjectMapperBaggageQuantityTest() {
    TermsAndConditions termsAndConditions = tcMapper.mapTermsAndConditions(pricePoint, ppFareInfo);
    assertNotNull(termsAndConditions);
    assertNull(termsAndConditions.getExpiryDate());
    assertNull(termsAndConditions.getValidatingCarrier());
    assertNotNull(termsAndConditions.getBaggageAllowance());
    assertEquals(2, termsAndConditions.getBaggageAllowance().get(0).getBaggageItem().get(0)
        .getQuantity().intValue());
  }

}
