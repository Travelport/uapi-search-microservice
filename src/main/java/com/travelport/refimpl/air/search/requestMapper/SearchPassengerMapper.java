package com.travelport.refimpl.air.search.requestMapper;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.travelport.refimpl.air.search.models.PassengerCriterium;
import com.travelport.schema.common_v45_0.PersonalGeography;
import com.travelport.schema.common_v45_0.SearchPassenger;

/**
 * The Class SearchPassengerMapper.
 */
@Component
public class SearchPassengerMapper {

  /** The Constant LOG. */
  private static final Logger LOG = LoggerFactory.getLogger(RequestMapper.class);

  /**
   * Map search passengers.
   *
   * @param passengers the passengers
   * @return the list
   */
  public List<SearchPassenger> mapSearchPassengers(List<PassengerCriterium> passengers) {
    LOG.debug("***Set Passengers");
    List<SearchPassenger> passengerList = new ArrayList<SearchPassenger>();
    for (PassengerCriterium passenger : passengers) {
      SearchPassenger searchPassenger = new SearchPassenger();
      searchPassenger.setCode(passenger.getValue());
      searchPassenger.setAge(mapAge(passenger.getAge()));
      searchPassenger.setPersonalGeography(mapTravelerGeography(passenger));
      // Duplicate search passengers according to the number requested
      for (int passengerCopy = 0; passengerCopy < passenger.getNumber(); passengerCopy++) {
        passengerList.add(searchPassenger);
      }

    }
    return passengerList;
  }

  /**
   * Map age.
   *
   * @param age the age
   * @return the big integer
   */
  private BigInteger mapAge(Integer age) {
    BigInteger bigAge = null;

    if (age != null) {
      bigAge = BigInteger.valueOf(age.intValue());
    }

    return bigAge;
  }

  /**
   * Map traveler geography.
   *
   * @param passenger the passenger
   * @return the personal geography
   */
  private PersonalGeography mapTravelerGeography(PassengerCriterium passenger) {
    PersonalGeography geography = null;

    if (passenger.getTravelerGeographicLocationType() != null) {
      geography = new PersonalGeography();
      switch (passenger.getTravelerGeographicLocationType()) {
      case "StateOrProvince":
        geography.setStateProvinceCode(passenger.getTravelerGeographicLocation());
        break;
      case "City":
        geography.setCityCode(passenger.getTravelerGeographicLocation());
        break;
      case "Country":
        geography.setCountryCode(passenger.getTravelerGeographicLocation());
        break;
      }
    }

    return geography;
  }
}
