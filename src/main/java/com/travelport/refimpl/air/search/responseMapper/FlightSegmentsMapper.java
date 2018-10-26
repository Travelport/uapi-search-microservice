package com.travelport.refimpl.air.search.responseMapper;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.travelport.refimpl.air.search.models.Flight;
import com.travelport.refimpl.air.search.models.FlightSegment;
import com.travelport.schema.air_v45_0.BookingInfo;
import com.travelport.schema.air_v45_0.Connection;
import com.travelport.schema.air_v45_0.Option;
import com.travelport.schema.air_v45_0.TypeBaseAirSegment;

/**
 * The Class FlightSegmentsMapper.
 */
@Component
public class FlightSegmentsMapper {
  
  /**
   * Map flight segments.
   *
   * @param flight the flight
   * @param segmentsMap the segments map
   * @return the list
   */
  public List<FlightSegment> mapFlightSegments(Option flight,
      Map<String, TypeBaseAirSegment> segmentsMap) {
    List<FlightSegment> flightSegments = new ArrayList<FlightSegment>();

    // TripServices::FlightSegment == UAPI::BookingInfo
    for (int flightIterator = 0; flightIterator < flight.getBookingInfo()
        .size(); flightIterator++) {
      flightSegments.add(mapFlightSegment(flight, segmentsMap, flightIterator));
    }

    return flightSegments;
  }

  /**
   * Map flight segment.
   *
   * @param flight the flight
   * @param segmentsMap the segments map
   * @param flightIterator the flight iterator
   * @return the flight segment
   */
  private FlightSegment mapFlightSegment(Option flight, Map<String, TypeBaseAirSegment> segmentsMap,
      int flightIterator) {
    BookingInfo bookingInfo = flight.getBookingInfo().get(flightIterator);
    FlightSegment flightSegment = new FlightSegment();
    Flight flightRef = new Flight();

    flightRef.setFlightRef(bookingInfo.getSegmentRef());
    flightRef.setType("FlightID");
    flightSegment.setType("FlightSegment");
    flightSegment.setFlight(flightRef);
    flightSegment.setSequence(flightIterator + 1);
    flightSegment = addConnectionDetails(flight, flightIterator, flightSegment, segmentsMap);

    return flightSegment;
  }

  /**
   * Adds the connection details.
   *
   * @param flight the flight
   * @param flightIterator the flight iterator
   * @param flightSegment the flight segment
   * @param segmentsMap the segments map
   * @return the flight segment
   */
  private FlightSegment addConnectionDetails(Option flight, int flightIterator,
      FlightSegment flightSegment, Map<String, TypeBaseAirSegment> segmentsMap) {
    if (flightIterator + 1 < flight.getBookingInfo().size()) {
      BookingInfo bookingInfo = flight.getBookingInfo().get(flightIterator);
      BookingInfo connectingBookingInfo = flight.getBookingInfo().get(flightIterator + 1);
      TypeBaseAirSegment thisLeg = segmentsMap.get(bookingInfo.getSegmentRef());
      TypeBaseAirSegment nextLeg = segmentsMap.get(connectingBookingInfo.getSegmentRef());
      flightSegment.setConnectionDuration(
          calculateConnectionDuration(thisLeg.getArrivalTime(), nextLeg.getDepartureTime()));
      flightSegment.setBoundFlightsInd(mapBoundedFlightInd(flight, flightIterator));
    }
    return flightSegment;
  }

  /**
   * Map bounded flight ind.
   *
   * @param flight the flight
   * @param flightIterator the flight iterator
   * @return the boolean
   */
  private Boolean mapBoundedFlightInd(Option flight, int flightIterator) {
    Boolean foundMatchInd = false;
    List<Connection> connections = flight.getConnection();

    if (connections != null) {
      for (int j = 0; j < connections.size(); j++) {
        if (connections.get(j).getSegmentIndex() == flightIterator) {
          foundMatchInd = true;
        } else if (connections.get(j).getSegmentIndex() > flightIterator) {
          break;
        }
      }
    }

    return foundMatchInd;
  }

  /**
   * Calculate connection duration.
   *
   * @param arrivalTime the arrival time
   * @param departureTime the departure time
   * @return the string
   */
  private String calculateConnectionDuration(String arrivalTime, String departureTime) {
    OffsetDateTime arrival = OffsetDateTime.parse(arrivalTime);
    OffsetDateTime departure = OffsetDateTime.parse(departureTime);
    Duration connectionDuration = Duration.between(departure, arrival);
    return connectionDuration.toString().replaceAll("-", "");
  }
}
