package com.travelport.refimpl.air.search.contollers;

import com.travelport.refimpl.air.search.models.Request;
import com.travelport.refimpl.air.search.models.Response;
import com.travelport.refimpl.air.search.services.UAPIAirService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The Class AirController.
 */
@RestController
@Api(value = "LowFareSearch Microservice")
public class AirController {

  /** The uapi air service. */
  @Autowired
  private UAPIAirService uapiAirService;

  /**
   * Instantiates a new air controller.
   *
   * @param uapiAirService the uapi air service
   */
  @Autowired
  AirController(UAPIAirService uapiAirService) {
    this.uapiAirService = uapiAirService;
  }

  /** The Constant LOG. */
  private static final Logger LOG = LoggerFactory.getLogger(AirController.class);

  /**
   * Air search.
   *
   * @param request the request
   * @param sccType the scc type
   * @param sccChannelId the scc channel id
   * @param view the view
   * @return the response
   */
  @ApiOperation(value = "Maps the model to a LowFareSearchReq and executes a UAPI request", response = Response.class)
  @RequestMapping(value = "/catalogofferings", method = RequestMethod.POST, produces = "application/json")
  public Response airSearch(@RequestBody Request request,
      @RequestParam(value = "sccType", required = false) String sccType,
      @RequestParam(value = "sccChannelId", required = false) String sccChannelId,
      @RequestParam(value = "view", required = false) String view) {

    LOG.debug("Call UAPIAirService with incoming request");
    LOG.debug("Enter air controller, map to /AirSearch");
    Response response = uapiAirService.getLowFareSearch(request, sccType, sccChannelId, view);

    return response;
  }
}