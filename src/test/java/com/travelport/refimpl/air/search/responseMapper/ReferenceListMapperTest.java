package com.travelport.refimpl.air.search.responseMapper;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.travelport.refimpl.air.search.models.Flight;
import com.travelport.refimpl.air.search.models.ReferenceList;
import com.travelport.schema.air_v45_0.CodeshareInfo;
import com.travelport.schema.air_v45_0.FlightDetails;
import com.travelport.schema.air_v45_0.TypeBaseAirSegment;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReferenceListMapperTest {

  @Autowired
  ReferenceListMapper refListMapper;

  TypeBaseAirSegment seg1 = new TypeBaseAirSegment();
  TypeBaseAirSegment seg2 = new TypeBaseAirSegment();

  List<TypeBaseAirSegment> airSegments = new ArrayList<TypeBaseAirSegment>();

  @Before
  public void populateSegments() {
    seg1.setKey("key1");
    seg1.setArrivalTime("05-14-2018T12:00:00");
    seg1.setDepartureTime("05-14-2018T11:00:00");
    seg1.setOrigin("DEN");
    seg1.setDestination("ATL");
    seg1.setFlightTime(BigInteger.valueOf(126));
    airSegments.add(seg1);

    seg2.setKey("key2");
    seg2.setArrivalTime("05-14-2018T14:00:00");
    seg2.setDepartureTime("05-14-2018T13:00:00");
    seg2.setOrigin("ATL");
    seg2.setDestination("JFK");
    seg2.setFlightTime(BigInteger.valueOf(140));
    airSegments.add(seg2);
  }

  @Test
  public void referenceListMapperTest() {
    List<ReferenceList> flights = refListMapper.mapReferenceList(airSegments);
    assertNotNull(flights);
    assertEquals(2, flights.get(0).getFlight().size());

    Flight flight1 = flights.get(0).getFlight().get(0);
    assertEquals("DEN", flight1.getDeparture().getLocation());
    assertEquals("ATL", flight1.getArrival().getLocation());
    assertEquals("11:00:00", flight1.getDeparture().getTime());
    assertEquals("12:00:00", flight1.getArrival().getTime());
    assertEquals("05-14-2018", flight1.getDeparture().getDate());
    assertEquals("05-14-2018", flight1.getArrival().getDate());
    assertEquals("PT2H6M", flight1.getDuration());
    assertNull(flight1.getOperatingCarrier());
    assertNull(flight1.getOperatingCarrierName());
    assertEquals("key1", flight1.getId());

    Flight flight2 = flights.get(0).getFlight().get(1);
    assertEquals("ATL", flight2.getDeparture().getLocation());
    assertEquals("JFK", flight2.getArrival().getLocation());
    assertEquals("13:00:00", flight2.getDeparture().getTime());
    assertEquals("14:00:00", flight2.getArrival().getTime());
    assertEquals("05-14-2018", flight2.getDeparture().getDate());
    assertEquals("05-14-2018", flight2.getArrival().getDate());
    assertEquals("PT2H20M", flight2.getDuration());
    assertNull(flight2.getOperatingCarrier());
    assertNull(flight2.getOperatingCarrierName());
    assertEquals("key2", flight2.getId());
  }

  @Test
  public void referenceListMapperCodeShareTest() {

    // Setup data
    CodeshareInfo codeShare = new CodeshareInfo();
    codeShare.setOperatingCarrier("UA");
    codeShare.setValue("United");
    airSegments.get(0).setCodeshareInfo(codeShare);
    airSegments.get(1).setCodeshareInfo(codeShare);

    // Call test
    List<ReferenceList> flights = refListMapper.mapReferenceList(airSegments);

    // Asserts
    assertNotNull(flights);
    assertEquals(2, flights.get(0).getFlight().size());

    Flight flight1 = flights.get(0).getFlight().get(0);
    assertEquals("UA", flight1.getOperatingCarrier());
    assertEquals("United", flight1.getOperatingCarrierName());
    assertEquals("DEN", flight1.getDeparture().getLocation());
    assertEquals("ATL", flight1.getArrival().getLocation());
    assertEquals("11:00:00", flight1.getDeparture().getTime());
    assertEquals("12:00:00", flight1.getArrival().getTime());
    assertEquals("05-14-2018", flight1.getDeparture().getDate());
    assertEquals("05-14-2018", flight1.getArrival().getDate());
    assertEquals("PT2H6M", flight1.getDuration());
    assertEquals("key1", flight1.getId());
  }

  @Test
  public void referenceListMapperIntermediateStopTest() {

    // Setup data
    FlightDetails flightDetails = new FlightDetails();
    flightDetails.setGroundTime(BigInteger.valueOf(45));
    flightDetails.setDestination("DUL");

    airSegments.get(0).setNumberOfStops(1);
    airSegments.get(0).getFlightDetails().add(flightDetails);

    // Call test
    List<ReferenceList> flights = refListMapper.mapReferenceList(airSegments);

    // Asserts
    assertNotNull(flights);
    assertEquals(2, flights.get(0).getFlight().size());

    Flight flight1 = flights.get(0).getFlight().get(0);
    assertEquals("DUL", flight1.getIntermediateStop().get(0).getValue());
    assertEquals("PT45M", flight1.getIntermediateStop().get(0).getDuration());
    assertEquals("DEN", flight1.getDeparture().getLocation());
    assertEquals("ATL", flight1.getArrival().getLocation());
    assertEquals("11:00:00", flight1.getDeparture().getTime());
    assertEquals("12:00:00", flight1.getArrival().getTime());
    assertEquals("05-14-2018", flight1.getDeparture().getDate());
    assertEquals("05-14-2018", flight1.getArrival().getDate());
    assertEquals("PT2H6M", flight1.getDuration());
    assertNull(flight1.getOperatingCarrier());
    assertNull(flight1.getOperatingCarrierName());
    assertEquals("key1", flight1.getId());
  }

}
