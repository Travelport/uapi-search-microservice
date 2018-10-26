package com.travelport.refimpl.air.search.responseMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.travelport.refimpl.air.search.models.FlightSegment;
import com.travelport.schema.air_v45_0.BookingInfo;
import com.travelport.schema.air_v45_0.Connection;
import com.travelport.schema.air_v45_0.Option;
import com.travelport.schema.air_v45_0.TypeBaseAirSegment;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightSegmentsMapperTest {

  @Autowired
  FlightSegmentsMapper flightSegmentsMapper;

  Option flight = new Option();
  Map<String, TypeBaseAirSegment> segmentsMap = new HashMap<String, TypeBaseAirSegment>();
  TypeBaseAirSegment seg1 = new TypeBaseAirSegment();
  TypeBaseAirSegment seg2 = new TypeBaseAirSegment();

  @Before
  public void populateFlightSegmentsMapperTestArgs() {
    BookingInfo bookingInfo1 = new BookingInfo();
    bookingInfo1.setSegmentRef("key1");
    BookingInfo bookingInfo2 = new BookingInfo();
    bookingInfo2.setSegmentRef("key2");

    Connection connection = new Connection();
    connection.setSegmentIndex(0);

    flight.getConnection().add(connection);

    seg1.setKey("key1");
    seg1.setArrivalTime("2018-05-14T12:00:00.000+11:00");
    seg1.setDepartureTime("2018-05-14T11:00:00.000+11:00");

    seg2.setKey("key2");
    seg2.setArrivalTime("2018-05-14T14:00:00.000+11:00");
    seg2.setDepartureTime("2018-05-14T13:00:00.000+11:00");

    flight.getBookingInfo().add(bookingInfo1);
    flight.getBookingInfo().add(bookingInfo2);

    segmentsMap.put("key1", seg1);
    segmentsMap.put("key2", seg2);
  }

  @Test
  public void flightSegmentsMapperBasicTest() {

    BookingInfo bookingInfoBasic = new BookingInfo();
    bookingInfoBasic.setSegmentRef("key1");
    Option flightBasic = new Option();
    seg1.setKey("key1");
    seg1.setArrivalTime("2018-05-14T12:00:00.000+11:00");
    seg1.setDepartureTime("2018-05-14T11:00:00.000+11:00");
    flightBasic.getBookingInfo().add(bookingInfoBasic);

    List<FlightSegment> flightSegments = flightSegmentsMapper.mapFlightSegments(flightBasic,
        segmentsMap);
    assertNotNull(flightSegments);
    assertEquals(1, flightSegments.size());
    assertEquals(1, flightSegments.get(0).getSequence().intValue());
    assertNull(flightSegments.get(0).getBoundFlightsInd());
    assertEquals("key1", flightSegments.get(0).getFlight().getFlightRef());
    assertNull(flightSegments.get(0).getConnectionDuration());
  }

  @Test
  public void flightSegmentsMapperBoundedFlightTest() {
    List<FlightSegment> flightSegments = flightSegmentsMapper.mapFlightSegments(flight,
        segmentsMap);
    assertNotNull(flightSegments);
    assertEquals(2, flightSegments.size());
    assertEquals(true, flightSegments.get(0).getBoundFlightsInd());
    assertEquals("key1", flightSegments.get(0).getFlight().getFlightRef());
    assertNull(flightSegments.get(1).getBoundFlightsInd());
    assertEquals("key2", flightSegments.get(1).getFlight().getFlightRef());
  }

  @Test
  public void flightSegmentsMapperConnectionDurationTest() {
    List<FlightSegment> flightSegments = flightSegmentsMapper.mapFlightSegments(flight,
        segmentsMap);
    assertNotNull(flightSegments);
    assertEquals("PT1H", flightSegments.get(0).getConnectionDuration());
    assertEquals(2, flightSegments.size());
    assertEquals(true, flightSegments.get(0).getBoundFlightsInd());
    assertEquals("key1", flightSegments.get(0).getFlight().getFlightRef());
    assertNull(flightSegments.get(1).getBoundFlightsInd());
    assertEquals("key2", flightSegments.get(1).getFlight().getFlightRef());
  }

}
