package com.travelport.refimpl.air.search.requestMapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.travelport.refimpl.air.search.models.SearchCriteriaFlight;
import com.travelport.schema.air_v45_0.SearchAirLeg;
import com.travelport.schema.common_v45_0.Airport;
import com.travelport.schema.common_v45_0.City;
import com.travelport.schema.common_v45_0.CityOrAirport;
import com.travelport.schema.common_v45_0.TypeFlexibleTimeSpec;
import com.travelport.schema.common_v45_0.TypeSearchLocation;
import com.travelport.schema.common_v45_0.TypeSpecificTime;

/**
 * The Class AirLegMapper.
 */
@Component
public class AirLegMapper {

  /** The Constant LOG. */
  private static final Logger LOG = LoggerFactory.getLogger(RequestMapper.class);

  /**
   * Map search air legs.
   *
   * @param tripLegs the trip legs
   * @return the list
   */
  public List<SearchAirLeg> mapSearchAirLegs(List<SearchCriteriaFlight> tripLegs) {
    LOG.debug("**Setup Air Legs");
    List<SearchAirLeg> searchAirLegs = new ArrayList<SearchAirLeg>();
    LOG.debug("Add legs");

    for (int i = 0; i < tripLegs.size(); i++) {
      SearchCriteriaFlight leg = tripLegs.get(i);
      searchAirLegs
          .add(mapLeg(leg.getFrom().getValue(), leg.getTo().getValue(), leg.getDepartureDate(),
              leg.getFrom().getType(), leg.getTo().getType(), leg.getDepartureTime()));
    }

    return searchAirLegs;
  }

  /**
   * Map leg.
   *
   * @param origin the origin
   * @param destination the destination
   * @param date the date
   * @param fromType the from type
   * @param toType the to type
   * @param time the time
   * @return the search air leg
   */
  private SearchAirLeg mapLeg(String origin, String destination, String date, String fromType,
      String toType, String time) {
    SearchAirLeg leg = new SearchAirLeg();

    leg.getSearchOrigin().add(mapLocation(origin, fromType));
    leg.getSearchDestination().add(mapLocation(destination, toType));
    leg.getSearchDepTime().add(mapTime(date, time));

    return leg;
  }

  /**
   * Map location.
   *
   * @param place the place
   * @param type the type
   * @return the type search location
   */
  private TypeSearchLocation mapLocation(String place, String type) {
    TypeSearchLocation location = new TypeSearchLocation();
    if (type == null) {
      type = "CityOrAirport";
    }
    switch (type) {
    case "Airport":
      location.setAirport(mapAirport(place));
      break;
    case "City":
      location.setCity(mapCity(place));
      break;
    case "CityOrAirport":
      location.setCityOrAirport(mapCityorAirport(place));
      break;
    default:
      location.setCityOrAirport(mapCityorAirport(place));
      break;
    }

    return location;
  }

  /**
   * Map city.
   *
   * @param place the place
   * @return the city
   */
  private City mapCity(String place) {
    City city = new City();
    city.setCode(place);
    return city;
  }

  /**
   * Map airport.
   *
   * @param place the place
   * @return the airport
   */
  private Airport mapAirport(String place) {
    Airport airport = new Airport();
    airport.setCode(place);
    return airport;
  }

  /**
   * Map cityor airport.
   *
   * @param place the place
   * @return the city or airport
   */
  private CityOrAirport mapCityorAirport(String place) {
    CityOrAirport cityOrAirport = new CityOrAirport();
    cityOrAirport.setCode(place);
    return cityOrAirport;
  }

  /**
   * Map time.
   *
   * @param date the date
   * @param time the time
   * @return the type flexible time spec
   */
  private TypeFlexibleTimeSpec mapTime(String date, String time) {
    TypeFlexibleTimeSpec timeType = new TypeFlexibleTimeSpec();
    timeType.setPreferredTime(date);
    if (time != null) {
      TypeSpecificTime specificTime = new TypeSpecificTime();
      specificTime.setTime(time);
      timeType.setSpecificTime(specificTime);
    }
    return timeType;
  }

}
