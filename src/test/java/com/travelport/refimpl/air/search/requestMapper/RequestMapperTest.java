package com.travelport.refimpl.air.search.requestMapper;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.travelport.refimpl.air.search.models.CarrierPreference;
import com.travelport.refimpl.air.search.models.CatalogOfferingsRequestAir;
import com.travelport.refimpl.air.search.models.From;
import com.travelport.refimpl.air.search.models.PassengerCriterium;
import com.travelport.refimpl.air.search.models.PseudoCityInfo;
import com.travelport.refimpl.air.search.models.Request;
import com.travelport.refimpl.air.search.models.SearchCriteriaFlight;
import com.travelport.refimpl.air.search.models.SearchModifiersAir;
import com.travelport.refimpl.air.search.models.To;
import com.travelport.schema.air_v45_0.AirPricingModifiers;
import com.travelport.schema.air_v45_0.AirSearchModifiers;
import com.travelport.schema.air_v45_0.LowFareSearchReq;
import com.travelport.schema.air_v45_0.SearchAirLeg;
import com.travelport.schema.common_v45_0.SearchPassenger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RequestMapperTest {

  @MockBean
  PriceModifiersMapper priceModMapper;

  @MockBean
  SearchModifiersMapper searchModMapper;

  @MockBean
  AirLegMapper airLegMapper;

  @MockBean
  SearchPassengerMapper passengerMapper;

  @Autowired
  RequestMapper requestMapper;

  // Dummy data to be used by the service
  PassengerCriterium passenger = new PassengerCriterium("ADT", 1, null, null, null);

  List<PassengerCriterium> passengerCriteria = new ArrayList<PassengerCriterium>(
      Arrays.asList(passenger));

  SearchCriteriaFlight flight = new SearchCriteriaFlight("SearchCriteriaFlight", "2018-09-29", null,
      null, new From("DEN", null), new To("LAX", null));

  List<SearchCriteriaFlight> flights = new ArrayList<SearchCriteriaFlight>(Arrays.asList(flight));

  CarrierPreference carrierPreference = new CarrierPreference("Prohibited", Arrays.asList("WN"));

  SearchModifiersAir searchModifiersAir = new SearchModifiersAir("SearchModifiersAir", null, null,
      null, carrierPreference, null, null, null, null);

  CatalogOfferingsRequestAir catalogOfferingsRequestAir = new CatalogOfferingsRequestAir(null, 5,
      null, passengerCriteria, flights, searchModifiersAir, null, new PseudoCityInfo("OMW", null));

  Request dummyRequest = new Request(catalogOfferingsRequestAir);

  @Test
  public void requestMapperNSCCAndChannelIDTest() {

    // Set up mocked class responses
    when(priceModMapper.mapAirPricingModifiers("scc_Channel_Id",
        catalogOfferingsRequestAir.getPricingModifiersAir())).thenReturn(new AirPricingModifiers());
    when(searchModMapper.mapSearchModifiers(5, searchModifiersAir))
        .thenReturn(new AirSearchModifiers());
    when(passengerMapper.mapSearchPassengers(passengerCriteria))
        .thenReturn(new ArrayList<SearchPassenger>());
    when(airLegMapper.mapSearchAirLegs(flights)).thenReturn(new ArrayList<SearchAirLeg>());

    // Make call that is being tested
    LowFareSearchReq lfsRequest = requestMapper.mapLowFareSearchReq(dummyRequest, "scc_type",
        "scc_Channel_Id");

    // Asserts
    assertNotNull(lfsRequest);
    assertEquals(false, lfsRequest.isSolutionResult());
    assertEquals("UAPI", lfsRequest.getBillingPointOfSaleInfo().getOriginApplication());
    assertEquals("scc_type", lfsRequest.getNSCC());
    Assert.isInstanceOf(AirPricingModifiers.class, lfsRequest.getAirPricingModifiers());
  }

  @Test
  public void requestMapperNSCCTest() {

    // Set up mocked class responses
    when(priceModMapper.mapAirPricingModifiers(null, null)).thenReturn(null);
    when(searchModMapper.mapSearchModifiers(5, searchModifiersAir))
        .thenReturn(new AirSearchModifiers());
    when(passengerMapper.mapSearchPassengers(passengerCriteria))
        .thenReturn(new ArrayList<SearchPassenger>());
    when(airLegMapper.mapSearchAirLegs(flights)).thenReturn(new ArrayList<SearchAirLeg>());

    // Make call that is being tested
    LowFareSearchReq lfsRequest = requestMapper.mapLowFareSearchReq(dummyRequest, "scc_type", null);

    // Asserts
    assertNotNull(lfsRequest);
    assertEquals(false, lfsRequest.isSolutionResult());
    assertEquals("UAPI", lfsRequest.getBillingPointOfSaleInfo().getOriginApplication());
    assertEquals("scc_type", lfsRequest.getNSCC());
    assertNull(lfsRequest.getAirPricingModifiers());
  }

  @Test
  public void requestMapperChannelIDTest() {

    // Set up mocked class responses
    when(priceModMapper.mapAirPricingModifiers("scc_Channel_Id",
        catalogOfferingsRequestAir.getPricingModifiersAir())).thenReturn(new AirPricingModifiers());
    when(searchModMapper.mapSearchModifiers(5, searchModifiersAir))
        .thenReturn(new AirSearchModifiers());
    when(passengerMapper.mapSearchPassengers(passengerCriteria))
        .thenReturn(new ArrayList<SearchPassenger>());
    when(airLegMapper.mapSearchAirLegs(flights)).thenReturn(new ArrayList<SearchAirLeg>());

    // Make call that is being tested
    LowFareSearchReq lfsRequest = requestMapper.mapLowFareSearchReq(dummyRequest, null,
        "scc_Channel_Id");

    // Asserts
    assertNotNull(lfsRequest);
    assertEquals(false, lfsRequest.isSolutionResult());
    assertEquals("UAPI", lfsRequest.getBillingPointOfSaleInfo().getOriginApplication());
    assertNull(lfsRequest.getNSCC());
    Assert.isInstanceOf(AirPricingModifiers.class, lfsRequest.getAirPricingModifiers());
  }

  @Test
  public void requestMapperBasicTest() {

    // Set up mocked class responses
    when(priceModMapper.mapAirPricingModifiers(null, null)).thenReturn(null);
    when(searchModMapper.mapSearchModifiers(5, searchModifiersAir))
        .thenReturn(new AirSearchModifiers());
    when(passengerMapper.mapSearchPassengers(passengerCriteria))
        .thenReturn(new ArrayList<SearchPassenger>());
    when(airLegMapper.mapSearchAirLegs(flights)).thenReturn(new ArrayList<SearchAirLeg>());

    // Make call that is being tested
    LowFareSearchReq lfsRequest = requestMapper.mapLowFareSearchReq(dummyRequest, null, null);

    // Asserts
    assertNotNull(lfsRequest);
    assertEquals(false, lfsRequest.isSolutionResult());
    assertEquals("UAPI", lfsRequest.getBillingPointOfSaleInfo().getOriginApplication());
    assertNull(lfsRequest.getNSCC());
    assertNull(lfsRequest.getAirPricingModifiers());
  }

}
