package com.travelport.refimpl.air.search.connector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.travelport.schema.air_v45_0.LowFareSearchReq;
import com.travelport.schema.air_v45_0.LowFareSearchRsp;
import com.travelport.service.air_v45_0.AirFaultMessage;
import com.travelport.service.air_v45_0.AirLowFareSearchPortType;
import com.travelport.service.air_v45_0.AirService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AirSearchConnectorTest {

  @Autowired
  AirSearchConnector airSearchConnector;

  @Test
  public void uAPIServiceConstructorTest() {
    assertTrue(airSearchConnector.airShop instanceof AirLowFareSearchPortType);
    assertTrue(airSearchConnector.air instanceof AirService);
  }

  @Test
  @Ignore
  public void callLowFareSearchTest() {
    LowFareSearchReq uapiReq = new LowFareSearchReq();
    LowFareSearchRsp uapiRsp = new LowFareSearchRsp();
    try {
      Mockito.when(airSearchConnector.airShop.service(uapiReq)).thenReturn(uapiRsp);
      assertEquals(uapiRsp, airSearchConnector.airSearchConnector(uapiReq));
    } catch (AirFaultMessage e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
