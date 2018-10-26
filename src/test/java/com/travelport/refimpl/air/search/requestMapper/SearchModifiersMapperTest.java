package com.travelport.refimpl.air.search.requestMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigInteger;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.travelport.refimpl.air.search.models.CabinPreference;
import com.travelport.refimpl.air.search.models.CarrierPreference;
import com.travelport.refimpl.air.search.models.FlightType;
import com.travelport.refimpl.air.search.models.SearchModifiersAir;
import com.travelport.schema.air_v45_0.AirSearchModifiers;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchModifiersMapperTest {

  @Autowired
  SearchModifiersMapper searchModifiersMapper;

  @Test
  public void searchModifiersMapperCarrierPreferenceTest() {

    // Dummy data to be used by the service
    CarrierPreference carrierPreference = new CarrierPreference("Prohibited", Arrays.asList("WN"));
    SearchModifiersAir searchModifiersAir = new SearchModifiersAir("SearchModifiersAir", null, null,
        null, carrierPreference, null, null, null, null);

    // Call the test class
    AirSearchModifiers airSearchModifiers = searchModifiersMapper.mapSearchModifiers(5,
        searchModifiersAir);

    // Asserts
    assertNotNull(airSearchModifiers);
    assertEquals(5, airSearchModifiers.getMaxSolutions().intValue());
    assertEquals("WN", airSearchModifiers.getProhibitedCarriers().getCarrier().get(0).getCode());

    assertNull(airSearchModifiers.getPermittedCarriers());
    assertNull(airSearchModifiers.getPreferredCarriers());
    assertNull(airSearchModifiers.getPermittedCabins());
    assertNull(airSearchModifiers.getPreferredCabins());
    assertNull(airSearchModifiers.getMaxLayoverDuration());
    assertNull(airSearchModifiers.getMaxConnectionTime());
    assertEquals(false, airSearchModifiers.isExcludeGroundTransportation());
    assertNull(airSearchModifiers.getFlightType());
  }

  @Test
  public void searchModifiersMapperCabinPreferenceTest() {

    CabinPreference cabinPref = new CabinPreference();
    cabinPref.setCabins(Arrays.asList("A", "B", "C"));
    cabinPref.setType("Permitted");
    SearchModifiersAir searchModifiersAir = new SearchModifiersAir("SearchModifiersAir", null, null,
        null, null, Arrays.asList(cabinPref), null, null, null);

    // Call the test class
    AirSearchModifiers airSearchModifiers = searchModifiersMapper.mapSearchModifiers(null,
        searchModifiersAir);

    // Asserts
    assertNotNull(airSearchModifiers);

    assertEquals(3, airSearchModifiers.getPermittedCabins().getCabinClass().size());
    assertEquals("A", airSearchModifiers.getPermittedCabins().getCabinClass().get(0).getType());
    assertEquals("B", airSearchModifiers.getPermittedCabins().getCabinClass().get(1).getType());
    assertEquals("C", airSearchModifiers.getPermittedCabins().getCabinClass().get(2).getType());

    assertNull(airSearchModifiers.getMaxSolutions());
    assertNull(airSearchModifiers.getProhibitedCarriers());
    assertNull(airSearchModifiers.getPermittedCarriers());
    assertNull(airSearchModifiers.getPreferredCarriers());
    assertNull(airSearchModifiers.getPreferredCabins());
    assertNull(airSearchModifiers.getMaxLayoverDuration());
    assertNull(airSearchModifiers.getMaxConnectionTime());
    assertEquals(false, airSearchModifiers.isExcludeGroundTransportation());
    assertNull(airSearchModifiers.getFlightType());
  }

  @Test
  public void searchModifiersMapperMaxLayoverDuration() {

    SearchModifiersAir searchModifiersAir = new SearchModifiersAir("SearchModifiersAir", null, null,
        null, null, null, null, null, "PT3H");

    // Call the test class
    AirSearchModifiers airSearchModifiers = searchModifiersMapper.mapSearchModifiers(null,
        searchModifiersAir);

    // Asserts
    assertNotNull(airSearchModifiers);

    assertEquals(180, airSearchModifiers.getMaxLayoverDuration().getDomestic().intValue());
    assertEquals(180, airSearchModifiers.getMaxLayoverDuration().getGateway().intValue());
    assertEquals(180, airSearchModifiers.getMaxLayoverDuration().getInternational().intValue());

    assertNull(airSearchModifiers.getPermittedCabins());
    assertNull(airSearchModifiers.getMaxSolutions());
    assertNull(airSearchModifiers.getProhibitedCarriers());
    assertNull(airSearchModifiers.getPermittedCarriers());
    assertNull(airSearchModifiers.getPreferredCarriers());
    assertNull(airSearchModifiers.getPreferredCabins());
    assertNull(airSearchModifiers.getMaxConnectionTime());
    assertEquals(false, airSearchModifiers.isExcludeGroundTransportation());
    assertNull(airSearchModifiers.getFlightType());
  }

  @Test
  public void searchModifiersMapperMaxConnectionDuration() {

    SearchModifiersAir searchModifiersAir = new SearchModifiersAir("SearchModifiersAir", null, null,
        null, null, null, null, "PT3H", null);

    // Call the test class
    AirSearchModifiers airSearchModifiers = searchModifiersMapper.mapSearchModifiers(null,
        searchModifiersAir);

    // Asserts
    assertNotNull(airSearchModifiers);

    assertEquals(BigInteger.valueOf(180), airSearchModifiers.getMaxConnectionTime());

    assertNull(airSearchModifiers.getMaxLayoverDuration());
    assertNull(airSearchModifiers.getPermittedCabins());
    assertNull(airSearchModifiers.getMaxSolutions());
    assertNull(airSearchModifiers.getProhibitedCarriers());
    assertNull(airSearchModifiers.getPermittedCarriers());
    assertNull(airSearchModifiers.getPreferredCarriers());
    assertNull(airSearchModifiers.getPreferredCabins());
    assertEquals(false, airSearchModifiers.isExcludeGroundTransportation());
    assertNull(airSearchModifiers.getFlightType());
  }

  @Test
  public void searchModifiersMapperChangeOfAirport() {

    SearchModifiersAir searchModifiersAir = new SearchModifiersAir("SearchModifiersAir", null, true,
        null, null, null, null, null, null);

    // Call the test class
    AirSearchModifiers airSearchModifiers = searchModifiersMapper.mapSearchModifiers(null,
        searchModifiersAir);

    // Asserts
    assertNotNull(airSearchModifiers);

    assertEquals(true, airSearchModifiers.isAllowChangeOfAirport());

    assertNull(airSearchModifiers.getMaxLayoverDuration());
    assertNull(airSearchModifiers.getPermittedCabins());
    assertNull(airSearchModifiers.getMaxSolutions());
    assertNull(airSearchModifiers.getProhibitedCarriers());
    assertNull(airSearchModifiers.getPermittedCarriers());
    assertNull(airSearchModifiers.getPreferredCarriers());
    assertNull(airSearchModifiers.getPreferredCabins());
    assertNull(airSearchModifiers.getMaxConnectionTime());
    assertEquals(false, airSearchModifiers.isExcludeGroundTransportation());
    assertNull(airSearchModifiers.getFlightType());
  }

  @Test
  public void searchModifiersMapperFlightType() {

    FlightType flightType = new FlightType();
    flightType.setConnectionType("SingleConnection");
    flightType.setExcludeInterlineConnectionsInd(true);
    SearchModifiersAir searchModifiersAir = new SearchModifiersAir("SearchModifiersAir", null, null,
        flightType, null, null, null, null, null);

    // Call the test class
    AirSearchModifiers airSearchModifiers = searchModifiersMapper.mapSearchModifiers(null,
        searchModifiersAir);

    // Asserts
    assertNotNull(airSearchModifiers);

    assertEquals(true, airSearchModifiers.getFlightType().isSingleOnlineCon());
    assertEquals(true, airSearchModifiers.getFlightType().isRequireSingleCarrier());

    assertNull(airSearchModifiers.getMaxLayoverDuration());
    assertNull(airSearchModifiers.getPermittedCabins());
    assertNull(airSearchModifiers.getMaxSolutions());
    assertNull(airSearchModifiers.getProhibitedCarriers());
    assertNull(airSearchModifiers.getPermittedCarriers());
    assertNull(airSearchModifiers.getPreferredCarriers());
    assertNull(airSearchModifiers.getPreferredCabins());
    assertNull(airSearchModifiers.getMaxConnectionTime());
    assertEquals(false, airSearchModifiers.isExcludeGroundTransportation());
  }

}
