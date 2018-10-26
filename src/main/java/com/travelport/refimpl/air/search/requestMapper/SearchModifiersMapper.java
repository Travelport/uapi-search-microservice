package com.travelport.refimpl.air.search.requestMapper;

import java.math.BigInteger;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.travelport.refimpl.air.search.models.CarrierPreference;
import com.travelport.refimpl.air.search.models.SearchModifiersAir;
import com.travelport.schema.air_v45_0.AirSearchModifiers;
import com.travelport.schema.air_v45_0.FlightType;
import com.travelport.schema.air_v45_0.MaxLayoverDurationType;
import com.travelport.schema.air_v45_0.PermittedCabins;
import com.travelport.schema.air_v45_0.PermittedCarriers;
import com.travelport.schema.air_v45_0.PreferredCabins;
import com.travelport.schema.air_v45_0.PreferredCarriers;
import com.travelport.schema.air_v45_0.ProhibitedCarriers;
import com.travelport.schema.common_v45_0.CabinClass;
import com.travelport.schema.common_v45_0.Carrier;

/**
 * The Class SearchModifiersMapper.
 */
@Component
public class SearchModifiersMapper {
  
  /**
   * Map search modifiers.
   *
   * @param offersPerPage the offers per page
   * @param searchModifiers the search modifiers
   * @return the air search modifiers
   */
  public AirSearchModifiers mapSearchModifiers(Integer offersPerPage,
      SearchModifiersAir searchModifiers) {
    AirSearchModifiers modifiers = new AirSearchModifiers();
    if (offersPerPage != null) {
      modifiers.setMaxSolutions(BigInteger.valueOf(offersPerPage));
    }
    if (searchModifiers != null) {
      modifiers
          .setMaxLayoverDuration(mapMaxLayoverDuration(searchModifiers.getMaxOvernightDuration()));
      modifiers.setMaxConnectionTime(
          mapMaxConnectionDuration(searchModifiers.getMaxConnectionDuration()));
      modifiers.setExcludeGroundTransportation(searchModifiers.getExcludeGround());
      modifiers.setAllowChangeOfAirport(searchModifiers.getProhibitChangeOfAirportInd());
      modifiers.setFlightType(mapFlightType(searchModifiers));
      modifiers = mapCarrierPreferences(searchModifiers, modifiers);
      modifiers = mapCabinPreferences(searchModifiers, modifiers);
    }
    return modifiers;
  }

  /**
   * Map max connection duration.
   *
   * @param maxConnectionString the max connection string
   * @return the big integer
   */
  private BigInteger mapMaxConnectionDuration(String maxConnectionString) {
    BigInteger maxConnection = null;
    if (maxConnectionString != null) {
      Duration maxConnectionDuration = Duration.parse(maxConnectionString);
      maxConnection = BigInteger.valueOf(maxConnectionDuration.toMinutes());
    }
    return maxConnection;
  }

  /**
   * Map flight type.
   *
   * @param searchModifiers the search modifiers
   * @return the flight type
   */
  private FlightType mapFlightType(SearchModifiersAir searchModifiers) {
    FlightType flightType = null;
    com.travelport.refimpl.air.search.models.FlightType tsFlightType = searchModifiers
        .getFlightType();
    if (tsFlightType != null) {
      flightType = new FlightType();
      flightType.setRequireSingleCarrier(tsFlightType.getExcludeInterlineConnectionsInd());
      flightType = mapConnectionType(tsFlightType, flightType);
    }
    return flightType;
  }

  /**
   * Map connection type.
   *
   * @param tsFlightType the ts flight type
   * @param flightType the flight type
   * @return the flight type
   */
  private FlightType mapConnectionType(
      com.travelport.refimpl.air.search.models.FlightType tsFlightType, FlightType flightType) {
    if (tsFlightType.getConnectionType() != null) {
      switch (tsFlightType.getConnectionType()) {
      case "NonStopDirect":
        flightType.setNonStopDirects(true);
        break;
      case "StopDirect":
        flightType.setStopDirects(true);
        break;
      case "SingleConnection":
        if (tsFlightType.getExcludeInterlineConnectionsInd()) {
          flightType.setSingleOnlineCon(true);
        } else {
          flightType.setSingleInterlineCon(true);
        }
        break;
      case "DoubleConnection":
        if (tsFlightType.getExcludeInterlineConnectionsInd()) {
          flightType.setDoubleOnlineCon(true);
        } else {
          flightType.setDoubleInterlineCon(true);
        }
        break;
      }
    }
    return flightType;
  }

  /**
   * Map carrier preferences.
   *
   * @param searchModifiers the search modifiers
   * @param modifiers the modifiers
   * @return the air search modifiers
   */
  private AirSearchModifiers mapCarrierPreferences(SearchModifiersAir searchModifiers,
      AirSearchModifiers modifiers) {
    if (searchModifiers.getCarrierPreference() != null) {
      CarrierPreference preference = searchModifiers.getCarrierPreference();
      switch (preference.getType()) {
      case "Permitted":
        PermittedCarriers permittedCarriers = new PermittedCarriers();
        permittedCarriers.getCarrier().addAll(getCarriers(preference));
        modifiers.setPermittedCarriers(permittedCarriers);
        break;
      case "Prohibited":
        ProhibitedCarriers prohibitedCarriers = new ProhibitedCarriers();
        prohibitedCarriers.getCarrier().addAll(getCarriers(preference));
        modifiers.setProhibitedCarriers(prohibitedCarriers);
        break;
      case "Preferred":
        PreferredCarriers preferredCarriers = new PreferredCarriers();
        preferredCarriers.getCarrier().addAll(getCarriers(preference));
        modifiers.setPreferredCarriers(preferredCarriers);
        break;
      }
    }
    return modifiers;
  }

  /**
   * Gets the carriers.
   *
   * @param preference the preference
   * @return the carriers
   */
  private List<Carrier> getCarriers(CarrierPreference preference) {
    List<Carrier> carriers = new ArrayList<Carrier>();
    for (String carrierName : preference.getCarriers()) {
      Carrier carrier = new Carrier();
      carrier.setCode(carrierName);
      carriers.add(carrier);
    }
    return carriers;
  }

  /**
   * Map cabin preferences.
   *
   * @param searchModifiers the search modifiers
   * @param modifiers the modifiers
   * @return the air search modifiers
   */
  private AirSearchModifiers mapCabinPreferences(SearchModifiersAir searchModifiers,
      AirSearchModifiers modifiers) {
    if (searchModifiers.getCabinPreference() != null) {
      List<String> cabins = searchModifiers.getCabinPreference().get(0).getCabins();
      PreferredCabins preferredCabins = new PreferredCabins();
      CabinClass cabinClass = new CabinClass();
      switch (searchModifiers.getCabinPreference().get(0).getType()) {
      case "Permitted":
        PermittedCabins permittedCabins = new PermittedCabins();
        for (String cabin : cabins) {
          CabinClass permittedCabinClass = new CabinClass();
          permittedCabinClass.setType(cabin);
          permittedCabins.getCabinClass().add(permittedCabinClass);
        }
        modifiers.setPermittedCabins(permittedCabins);
        break;
      case "Preferred":
        cabinClass.setType(cabins.get(0));
        preferredCabins.setCabinClass(cabinClass);
        modifiers.setPreferredCabins(preferredCabins);
        break;
      case "PreferredWithUpgrade":
        cabinClass.setType(cabins.get(0));
        preferredCabins.setCabinClass(cabinClass);
        modifiers.setPreferredCabins(preferredCabins);
        break;
      }
    }
    return modifiers;
  }

  /**
   * Map max layover duration.
   *
   * @param maxLayoverDurationString the max layover duration string
   * @return the max layover duration type
   */
  private MaxLayoverDurationType mapMaxLayoverDuration(String maxLayoverDurationString) {
    MaxLayoverDurationType maxLayoverDurationType = null;
    if (maxLayoverDurationString != null) {
      maxLayoverDurationType = new MaxLayoverDurationType();
      Duration maxLayoverDuration = Duration.parse(maxLayoverDurationString);

      maxLayoverDurationType.setDomestic((int) (long) maxLayoverDuration.toMinutes());
      maxLayoverDurationType.setInternational((int) (long) maxLayoverDuration.toMinutes());
      maxLayoverDurationType.setGateway((int) (long) maxLayoverDuration.toMinutes());
    }
    return maxLayoverDurationType;
  }
}
