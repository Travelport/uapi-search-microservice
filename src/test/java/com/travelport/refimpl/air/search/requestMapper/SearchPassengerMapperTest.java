package com.travelport.refimpl.air.search.requestMapper;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.travelport.refimpl.air.search.models.PassengerCriterium;
import com.travelport.schema.common_v45_0.SearchPassenger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchPassengerMapperTest {

  @Autowired
  SearchPassengerMapper passengerMapper;

  PassengerCriterium passenger1 = new PassengerCriterium("ADT", 1, null, "AR", "City");
  PassengerCriterium passenger2 = new PassengerCriterium("CHD", 1, 13, "AR", "Country");
  List<PassengerCriterium> passengerCriteria = new ArrayList<PassengerCriterium>(
      Arrays.asList(passenger1, passenger2));

  @Test
  public void searchPassengerMapperTestSinglePassenger() {

    PassengerCriterium adult = new PassengerCriterium("ADT", 1, null, null, null);
    List<SearchPassenger> uapiPassengers = passengerMapper
        .mapSearchPassengers(Arrays.asList(adult));

    assertNotNull(uapiPassengers);
    assertEquals(1, uapiPassengers.size());
    assertEquals("ADT", uapiPassengers.get(0).getCode());
    assertNull(uapiPassengers.get(0).getPersonalGeography());
    assertNull(uapiPassengers.get(0).getAge());
  }

  @Test
  public void searchPassengerMapperTestMultiAdult() {

    PassengerCriterium adult = new PassengerCriterium("ADT", 3, null, null, null);
    List<SearchPassenger> uapiPassengers = passengerMapper
        .mapSearchPassengers(Arrays.asList(adult));

    assertNotNull(uapiPassengers);
    assertEquals(3, uapiPassengers.size());
    assertEquals("ADT", uapiPassengers.get(0).getCode());
    assertNull(uapiPassengers.get(0).getPersonalGeography());
    assertNull(uapiPassengers.get(0).getAge());
    assertEquals("ADT", uapiPassengers.get(1).getCode());
    assertNull(uapiPassengers.get(1).getPersonalGeography());
    assertNull(uapiPassengers.get(1).getAge());
    assertEquals("ADT", uapiPassengers.get(2).getCode());
    assertNull(uapiPassengers.get(2).getPersonalGeography());
    assertNull(uapiPassengers.get(2).getAge());
  }

  @Test
  public void searchPassengerMapperTestPersonalGeograpghy() {

    List<SearchPassenger> uapiPassengers = passengerMapper.mapSearchPassengers(passengerCriteria);

    assertNotNull(uapiPassengers);
    assertEquals(2, uapiPassengers.size());

    assertEquals("ADT", uapiPassengers.get(0).getCode());
    assertEquals("AR", uapiPassengers.get(0).getPersonalGeography().getCityCode());
    assertNull(uapiPassengers.get(0).getAge());

    assertEquals("CHD", uapiPassengers.get(1).getCode());
    assertEquals("AR", uapiPassengers.get(1).getPersonalGeography().getCountryCode());
    assertEquals(13, uapiPassengers.get(1).getAge().intValue());
  }

}
