package com.travelport.refimpl.air.search.requestMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.travelport.refimpl.air.search.models.From;
import com.travelport.refimpl.air.search.models.SearchCriteriaFlight;
import com.travelport.refimpl.air.search.models.To;
import com.travelport.schema.air_v45_0.SearchAirLeg;

public class AirLegMapperTest {

  private static final AirLegMapper MAPPER = new AirLegMapper();

  @Test
  public void testAirLegMapperZeroLegs() {

    // Set up mock vars
    List<SearchCriteriaFlight> flights = new ArrayList<SearchCriteriaFlight>();

    // Call test class
    List<SearchAirLeg> uapiLegs = MAPPER.mapSearchAirLegs(flights);

    // Assert response contains proper values
    assertEquals(uapiLegs.size(), 0);
  }

  @Test
  public void testAirLegMapperBasic() {

    // Set up mock vars
    SearchCriteriaFlight flight = new SearchCriteriaFlight("SearchCriteriaFlight", "2018-09-29",
        null, null, new From("DEN", null), new To("LAX", null));
    List<SearchCriteriaFlight> flights = new ArrayList<SearchCriteriaFlight>(Arrays.asList(flight));

    // Call test class
    List<SearchAirLeg> uapiLegs = MAPPER.mapSearchAirLegs(flights);

    // Assert response contains proper values
    assertEquals(uapiLegs.size(), 1);
    assertEquals(uapiLegs.get(0).getSearchOrigin().get(0).getCityOrAirport().getCode(), "DEN");
    assertEquals(uapiLegs.get(0).getSearchDestination().get(0).getCityOrAirport().getCode(), "LAX");
    assertEquals(uapiLegs.get(0).getSearchDepTime().get(0).getPreferredTime(), "2018-09-29");
    assertNull(uapiLegs.get(0).getSearchOrigin().get(0).getCity());
    assertNull(uapiLegs.get(0).getSearchOrigin().get(0).getAirport());
    assertNull(uapiLegs.get(0).getSearchDestination().get(0).getCity());
    assertNull(uapiLegs.get(0).getSearchDestination().get(0).getAirport());
  }

  @Test
  public void testAirLegMapperWithAirport() {

    // Set up mock vars
    SearchCriteriaFlight flight = new SearchCriteriaFlight("SearchCriteriaFlight", "2018-09-29",
        null, null, new From("DEN", "Airport"), new To("LAX", "Airport"));
    List<SearchCriteriaFlight> flights = new ArrayList<SearchCriteriaFlight>(Arrays.asList(flight));

    // Call test class
    List<SearchAirLeg> uapiLegs = MAPPER.mapSearchAirLegs(flights);

    // Assert response contains proper values
    assertEquals(uapiLegs.size(), 1);
    assertEquals(uapiLegs.get(0).getSearchOrigin().get(0).getAirport().getCode(), "DEN");
    assertEquals(uapiLegs.get(0).getSearchDestination().get(0).getAirport().getCode(), "LAX");
    assertEquals(uapiLegs.get(0).getSearchDepTime().get(0).getPreferredTime(), "2018-09-29");
    assertNull(uapiLegs.get(0).getSearchOrigin().get(0).getCity());
    assertNull(uapiLegs.get(0).getSearchOrigin().get(0).getCityOrAirport());
    assertNull(uapiLegs.get(0).getSearchDestination().get(0).getCity());
    assertNull(uapiLegs.get(0).getSearchDestination().get(0).getCityOrAirport());
  }

  @Test
  public void testAirLegMapperWithCity() {

    // Set up mock vars
    SearchCriteriaFlight flight = new SearchCriteriaFlight("SearchCriteriaFlight", "2018-09-29",
        null, null, new From("DEN", "City"), new To("LAX", "City"));
    List<SearchCriteriaFlight> flights = new ArrayList<SearchCriteriaFlight>(Arrays.asList(flight));

    // Call test class
    List<SearchAirLeg> uapiLegs = MAPPER.mapSearchAirLegs(flights);

    // Assert response contains proper values
    assertEquals(uapiLegs.size(), 1);
    assertEquals(uapiLegs.get(0).getSearchOrigin().get(0).getCity().getCode(), "DEN");
    assertEquals(uapiLegs.get(0).getSearchDestination().get(0).getCity().getCode(), "LAX");
    assertEquals(uapiLegs.get(0).getSearchDepTime().get(0).getPreferredTime(), "2018-09-29");
    assertNull(uapiLegs.get(0).getSearchOrigin().get(0).getAirport());
    assertNull(uapiLegs.get(0).getSearchOrigin().get(0).getCityOrAirport());
    assertNull(uapiLegs.get(0).getSearchDestination().get(0).getAirport());
    assertNull(uapiLegs.get(0).getSearchDestination().get(0).getCityOrAirport());
  }

  @Test
  public void testAirLegMapperWithCityOrAirport() {

    // Set up mock vars
    SearchCriteriaFlight flight = new SearchCriteriaFlight("SearchCriteriaFlight", "2018-09-29",
        null, null, new From("DEN", "CityOrAirport"), new To("LAX", "CityOrAirport"));
    List<SearchCriteriaFlight> flights = new ArrayList<SearchCriteriaFlight>(Arrays.asList(flight));

    // Call test class
    List<SearchAirLeg> uapiLegs = MAPPER.mapSearchAirLegs(flights);

    // Assert response contains proper values
    assertEquals(uapiLegs.size(), 1);
    assertEquals(uapiLegs.get(0).getSearchOrigin().get(0).getCityOrAirport().getCode(), "DEN");
    assertEquals(uapiLegs.get(0).getSearchDestination().get(0).getCityOrAirport().getCode(), "LAX");
    assertEquals(uapiLegs.get(0).getSearchDepTime().get(0).getPreferredTime(), "2018-09-29");
    assertNull(uapiLegs.get(0).getSearchOrigin().get(0).getAirport());
    assertNull(uapiLegs.get(0).getSearchOrigin().get(0).getCity());
    assertNull(uapiLegs.get(0).getSearchDestination().get(0).getAirport());
    assertNull(uapiLegs.get(0).getSearchDestination().get(0).getCity());
  }

  @Test
  public void testAirLegMapperWithTime() {

    // Set up mock vars
    SearchCriteriaFlight flight = new SearchCriteriaFlight("SearchCriteriaFlight", "2018-09-29",
        "11:55:00.000", null, new From("DEN", "CityOrAirport"), new To("LAX", "CityOrAirport"));
    List<SearchCriteriaFlight> flights = new ArrayList<SearchCriteriaFlight>(Arrays.asList(flight));

    // Call test class
    List<SearchAirLeg> uapiLegs = MAPPER.mapSearchAirLegs(flights);

    // Assert response contains proper values
    assertEquals(uapiLegs.size(), 1);
    assertEquals(uapiLegs.get(0).getSearchOrigin().get(0).getCityOrAirport().getCode(), "DEN");
    assertEquals(uapiLegs.get(0).getSearchDestination().get(0).getCityOrAirport().getCode(), "LAX");
    assertEquals(uapiLegs.get(0).getSearchDepTime().get(0).getPreferredTime(), "2018-09-29");
    assertEquals(uapiLegs.get(0).getSearchDepTime().get(0).getSpecificTime().getTime(),
        "11:55:00.000");
    assertNull(uapiLegs.get(0).getSearchOrigin().get(0).getAirport());
    assertNull(uapiLegs.get(0).getSearchOrigin().get(0).getCity());
    assertNull(uapiLegs.get(0).getSearchDestination().get(0).getAirport());
    assertNull(uapiLegs.get(0).getSearchDestination().get(0).getCity());
  }

  @Test
  public void testAirLegMapperWithVariedLocationType() {

    // Set up mock vars
    SearchCriteriaFlight flight1 = new SearchCriteriaFlight("SearchCriteriaFlight", "2018-09-29",
        null, null, new From("DEN", "CityOrAirport"), new To("LAX", "City"));
    SearchCriteriaFlight flight2 = new SearchCriteriaFlight("SearchCriteriaFlight", "2018-09-31",
        null, null, new From("DEN", "Airport"), new To("LAX", "Airport"));
    List<SearchCriteriaFlight> flights = new ArrayList<SearchCriteriaFlight>(
        Arrays.asList(flight1, flight2));

    // Call test class
    List<SearchAirLeg> uapiLegs = MAPPER.mapSearchAirLegs(flights);

    // Assert response contains proper values
    assertEquals(uapiLegs.size(), 2);

    assertEquals(uapiLegs.get(0).getSearchOrigin().get(0).getCityOrAirport().getCode(), "DEN");
    assertEquals(uapiLegs.get(0).getSearchDestination().get(0).getCity().getCode(), "LAX");
    assertEquals(uapiLegs.get(0).getSearchDepTime().get(0).getPreferredTime(), "2018-09-29");

    assertEquals(uapiLegs.get(1).getSearchOrigin().get(0).getAirport().getCode(), "DEN");
    assertEquals(uapiLegs.get(1).getSearchDestination().get(0).getAirport().getCode(), "LAX");
    assertEquals(uapiLegs.get(1).getSearchDepTime().get(0).getPreferredTime(), "2018-09-31");
  }

}
