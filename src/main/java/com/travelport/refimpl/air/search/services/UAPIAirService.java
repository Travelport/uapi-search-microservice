package com.travelport.refimpl.air.search.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelport.refimpl.air.search.connector.AirSearchConnector;
import com.travelport.refimpl.air.search.models.Request;
import com.travelport.refimpl.air.search.models.Response;
import com.travelport.refimpl.air.search.requestMapper.RequestMapper;
import com.travelport.refimpl.air.search.responseMapper.ResponseMapper;
import com.travelport.schema.air_v45_0.LowFareSearchReq;
import com.travelport.schema.air_v45_0.LowFareSearchRsp;

/**
 * The Class UAPIAirService.
 */
@Service
public class UAPIAirService {

  /** The Constant LOG. */
  private static final Logger LOG = LoggerFactory.getLogger(UAPIAirService.class);
  
  /** The air mapper. */
  @Autowired
  private RequestMapper airMapper;
  
  /** The air search connector. */
  @Autowired
  private AirSearchConnector airSearchConnector;
  
  /** The response mapper. */
  @Autowired
  private ResponseMapper responseMapper;

  /**
   * Gets the low fare search.
   *
   * @param request the request
   * @param sccType the scc type
   * @param sccChannelID the scc channel ID
   * @param view the view
   * @return the low fare search
   */
  public Response getLowFareSearch(Request request, String sccType, String sccChannelID,
      String view) {
    LOG.debug("Send model to mapper to get LowFareSearchReq");
    LowFareSearchReq lfsRequest = airMapper.mapLowFareSearchReq(request, sccType, sccChannelID);
    LOG.debug("****Setup service");
    LOG.debug("****Getting Service");
    LowFareSearchRsp lfsResponse = airSearchConnector.airSearchConnector(lfsRequest);
    LOG.debug("****Mapping Response");
    Response solutions = responseMapper.mapLowFareSearchRes(lfsResponse, view);
    LOG.debug("*******Request Completed");
    return solutions;
  }
}