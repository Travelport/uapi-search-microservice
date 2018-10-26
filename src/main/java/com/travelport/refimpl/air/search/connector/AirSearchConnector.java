package com.travelport.refimpl.air.search.connector;

import javax.xml.ws.BindingProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.travelport.schema.air_v45_0.LowFareSearchReq;
import com.travelport.schema.air_v45_0.LowFareSearchRsp;
import com.travelport.service.air_v45_0.AirFaultMessage;
import com.travelport.service.air_v45_0.AirLowFareSearchPortType;
import com.travelport.service.air_v45_0.AirService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * The Class AirSearchConnector.
 */
@Component
public class AirSearchConnector {

  /** The Constant LOG. */
  private static final Logger LOG = LoggerFactory.getLogger(AirSearchConnector.class);

  /** The username. */
  @Value("${air.username}")
  private String username;

  /** The password. */
  @Value("${air.password}")
  private String password;

  /** The endpoint. */
  @Value("${air.endpoint}")
  private String endpoint;

  /** The branch. */
  @Value("${air.branch}")
  private String branch;

  /** The air shop. */
  public AirLowFareSearchPortType airShop;
  
  /** The air. */
  public AirService air;

  /**
   * Instantiates a new air search connector.
   */
  @Autowired
  public AirSearchConnector() {
    this.air = new com.travelport.service.air_v45_0.AirService();
    this.airShop = air.getAirLowFareSearchPort();
  }

  /**
   * Air search connector.
   *
   * @param lfsRequest the lfs request
   * @return the low fare search rsp
   */
  public LowFareSearchRsp airSearchConnector(LowFareSearchReq lfsRequest) {
    LowFareSearchRsp lfsResponse = new LowFareSearchRsp();
    addParametersToProvider((BindingProvider) airShop);

    try {
      lfsResponse = airShop.service(lfsRequest);
    } catch (AirFaultMessage e) {
      e.printStackTrace();
    }
    return lfsResponse;
  }

  /**
   * Adds the parameters to provider.
   *
   * @param provider the provider
   */
  private void addParametersToProvider(BindingProvider provider) {
    LOG.debug("Username: " + username);
    LOG.debug("Endpoint: " + endpoint);
    LOG.debug("Branch: " + branch);

    provider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);
    provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, username);
    provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, password);
    provider.getRequestContext().put("schema-validation-enabled", "false");
  }
}