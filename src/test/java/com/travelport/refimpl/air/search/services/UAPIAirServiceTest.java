package com.travelport.refimpl.air.search.services;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.cxf.helpers.IOUtils;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.travelport.schema.air_v45_0.LowFareSearchReq;
import com.travelport.schema.air_v45_0.LowFareSearchRsp;
import com.travelport.refimpl.air.search.connector.AirSearchConnector;
import com.travelport.refimpl.air.search.models.CarrierPreference;
import com.travelport.refimpl.air.search.models.CatalogOfferingsRequestAir;
import com.travelport.refimpl.air.search.models.From;
import com.travelport.refimpl.air.search.models.PassengerCriterium;
import com.travelport.refimpl.air.search.models.PseudoCityInfo;
import com.travelport.refimpl.air.search.models.Request;
import com.travelport.refimpl.air.search.models.Response;
import com.travelport.refimpl.air.search.models.SearchCriteriaFlight;
import com.travelport.refimpl.air.search.models.SearchModifiersAir;
import com.travelport.refimpl.air.search.models.To;
import com.travelport.refimpl.air.search.requestMapper.RequestMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UAPIAirServiceTest {

  // TODO:Move to integration test package and replace with actual unit test

  @Autowired
  public UAPIAirService service;

  @Mock
  RequestMapper mapper;

  @Mock
  AirSearchConnector uapi;

  @InjectMocks
  UAPIAirService mockUAPIService;

  // Dummy data to be used by the service
  PassengerCriterium passenger = new PassengerCriterium("ADT", 1, null, null, null);
  List<PassengerCriterium> passengerCriteria = new ArrayList<PassengerCriterium>(
      Arrays.asList(passenger));
  SearchCriteriaFlight flight = new SearchCriteriaFlight("SearchCriteriaFlight", "2018-09-29", null,
      null, new From("DEN", null), new To("LAX", null));

  List<SearchCriteriaFlight> flights = new ArrayList<SearchCriteriaFlight>(Arrays.asList(flight));
  CarrierPreference carrierPreference = new CarrierPreference("Prohibited", Arrays.asList("WN"));
  SearchModifiersAir searchModifiersAir = new SearchModifiersAir("SearchModifiersAir", null, null,
      null, carrierPreference, null, null, null, null);
  CatalogOfferingsRequestAir catalogOfferingsRequestAir = new CatalogOfferingsRequestAir(null, 5,
      null, passengerCriteria, flights, searchModifiersAir, null, new PseudoCityInfo("OMW", null));
  Request dummyRequest = new Request(catalogOfferingsRequestAir);

  // TxnID from the sampleresponse.xml
  String expectedTxnID = "AB9EC2F90A07761F870ED0544821C7A7";

  // Constructs a HTTP server that we will connect to instead of UAPI
  // JUnit manages the lifecycle, starts the server prior to each test method
  // and stops it after the method returns.
  @Rule
  public WireMockRule wireMockRule = new WireMockRule(8087);

  @Test@Ignore
  public void UAPIAirServiceTestWireMock() throws IOException {

    // Stringify the test XML files from the src/test/resources/lfs folder
    String requestEnvelope = IOUtils
        .toString(getClass().getResourceAsStream("/lfs/samplerequest.xml"));
    String responseEnvelope = IOUtils
        .toString(getClass().getResourceAsStream("/lfs/sampleresponse.xml"));

    // Configure a stub for /AirService,
    // provide it the expected request header and body,
    // provide it the response values in case the request matches
    wireMockRule.stubFor(post(urlEqualTo("/AirService"))
        .withHeader("Content-Type", equalTo("text/xml; charset=UTF-8"))
        .withRequestBody(equalToXml(requestEnvelope))
        .willReturn(aResponse().withStatus(HttpStatus.OK.value()).withBody(responseEnvelope))
        .withHeader("Content-Type", equalTo("text/xml; charset=UTF-8")));

    // Call the service with the dummy requestModel.
    // WireMock will intercept the SOAP request because
    // src\test\resources\application.yml contains
    // endpoint: http://localhost:8089/AirService
    Response response = service.getLowFareSearch(dummyRequest, null, null, null);

    // If our service sent a properly formed request, wireMock will return
    // the xml we provided it. We can verify via reading a value from
    // the response object.
    assertEquals("DEN", response.getCatalogOfferingsResponse().getReferenceList().get(0).getFlight()
        .get(0).getDeparture().getLocation());

  }

  @Test
  public void mockUAPIAirServiceTest() {
    List<PassengerCriterium> passengerCriteria = new ArrayList<PassengerCriterium>();
    PassengerCriterium passenger = new PassengerCriterium("ADT", 1, null, null, null);
    passengerCriteria.add(passenger);
    LowFareSearchReq uapiReq = new LowFareSearchReq();
    LowFareSearchRsp uapiRsp = new LowFareSearchRsp();
    when(uapi.airSearchConnector(uapiReq)).thenReturn(uapiRsp);
  }

}
