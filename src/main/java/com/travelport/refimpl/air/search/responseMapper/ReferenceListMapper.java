package com.travelport.refimpl.air.search.responseMapper;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.travelport.refimpl.air.search.models.Arrival;
import com.travelport.refimpl.air.search.models.Departure;
import com.travelport.refimpl.air.search.models.Flight;
import com.travelport.refimpl.air.search.models.IntermediateStop;
import com.travelport.refimpl.air.search.models.ReferenceList;
import com.travelport.schema.air_v45_0.FlightDetails;
import com.travelport.schema.air_v45_0.TypeBaseAirSegment;

/**
 * The Class ReferenceListMapper.
 */
@Component
public class ReferenceListMapper {
  
  /**
   * Map reference list.
   *
   * @param airSegments the air segments
   * @return the list
   */
  public List<ReferenceList> mapReferenceList(List<TypeBaseAirSegment> airSegments) {
    List<ReferenceList> segmentsList = new ArrayList<ReferenceList>();

    segmentsList.add(setReferenceList(airSegments));

    return segmentsList;
  }

  /**
   * Sets the reference list.
   *
   * @param airSegments the air segments
   * @return the reference list
   */
  private ReferenceList setReferenceList(List<TypeBaseAirSegment> airSegments) {
    ReferenceList flights = new ReferenceList();

    flights.setType("ReferenceListFlight");
    flights.setFlight(mapFlightsList(airSegments));

    return flights;
  }

  /**
   * Map flights list.
   *
   * @param airSegments the air segments
   * @return the list
   */
  private List<Flight> mapFlightsList(List<TypeBaseAirSegment> airSegments) {
    List<Flight> flightsList = new ArrayList<Flight>();

    for (TypeBaseAirSegment airSegment : airSegments) {
      flightsList.add(setAirSegment(airSegment));
    }

    return flightsList;
  }

  /**
   * Sets the air segment.
   *
   * @param seg the seg
   * @return the flight
   */
  private Flight setAirSegment(TypeBaseAirSegment seg) {
    Flight flight = new Flight();
    flight.setId(seg.getKey());
    flight.setType("Flight");

    if (seg.getCodeshareInfo() != null) {
      flight.setOperatingCarrier(seg.getCodeshareInfo().getOperatingCarrier());
      flight.setOperatingCarrierName(seg.getCodeshareInfo().getValue());
    }

    flight.setDeparture(mapDeparture(seg.getDepartureTime(), seg.getOrigin()));
    flight.setArrival(mapArrival(seg.getArrivalTime(), seg.getDestination()));
    flight.setCarrier(seg.getCarrier());
    flight.setEquipment(Arrays.asList(seg.getEquipment()));
    flight.setNumber(seg.getFlightNumber());

    if (seg.getDistance() != null) {
      flight.setDistance(seg.getDistance().intValue());
    }

    flight.setDuration(Duration.ofMinutes(seg.getFlightTime().longValue()).toString());
    flight.setIntermediateStop(mapIntermediateStops(seg));

    return flight;
  }

  /**
   * Map arrival.
   *
   * @param arrivalTime the arrival time
   * @param destination the destination
   * @return the arrival
   */
  private Arrival mapArrival(String arrivalTime, String destination) {
    String arrivalTimeAndDate[] = arrivalTime.split("T");
    Arrival arrival = new Arrival();

    arrival.setType("Arrival");
    arrival.setTime(arrivalTimeAndDate[1]);
    arrival.setDate(arrivalTimeAndDate[0]);
    arrival.setLocation(destination);

    return arrival;
  }

  /**
   * Map departure.
   *
   * @param departureTime the departure time
   * @param origin the origin
   * @return the departure
   */
  private Departure mapDeparture(String departureTime, String origin) {
    String timeAndDate[] = departureTime.split("T");
    Departure departure = new Departure();

    departure.setType("Departure");
    departure.setLocation(origin);
    departure.setTime(timeAndDate[1]);
    departure.setDate(timeAndDate[0]);

    return departure;
  }

  /**
   * Map intermediate stops.
   *
   * @param seg the seg
   * @return the list
   */
  private List<IntermediateStop> mapIntermediateStops(TypeBaseAirSegment seg) {
    List<IntermediateStop> intermediateStops = null;

    if (seg.getNumberOfStops() != null && seg.getFlightDetails() != null) {
      intermediateStops = new ArrayList<IntermediateStop>();
      for (FlightDetails flightDetail : seg.getFlightDetails()) {
        IntermediateStop intermediateStop = new IntermediateStop();
        intermediateStop
            .setDuration(Duration.ofMinutes(flightDetail.getGroundTime().longValue()).toString());
        intermediateStop.setValue(flightDetail.getDestination());
        intermediateStops.add(intermediateStop);
      }
    }

    return intermediateStops;
  }
}
