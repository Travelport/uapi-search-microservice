package com.travelport.refimpl.air.search.contollers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.travelport.refimpl.air.search.models.CatalogOfferingsResponse;
import com.travelport.refimpl.air.search.models.Request;
import com.travelport.refimpl.air.search.models.Response;
import com.travelport.refimpl.air.search.services.UAPIAirService;

@RunWith(SpringRunner.class)
@WebMvcTest(AirController.class)
public class AirControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  UAPIAirService mockUAPIService;

  @Test
  public void testDefaultControllerResponse() throws Exception {
    // Setup Mock vars and behavior
    CatalogOfferingsResponse catalogOfferingsResponse = new CatalogOfferingsResponse(null,
        "txn12345", "mock_trace", null, null);
    Response mockResponse = new Response(catalogOfferingsResponse);
    Request request = new Request();
    Mockito.when(mockUAPIService.getLowFareSearch(Mockito.any(Request.class), Mockito.isNull(),
        Mockito.isNull(), Mockito.isNull())).thenReturn(mockResponse);

    // Call MockMvc and Assert the response has the appropriate values
    mvc.perform(MockMvcRequestBuilders.post("/catalogofferings").accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON).content(asJsonString(request)))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.CatalogOfferingsResponse.transactionId")
            .value("txn12345"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.CatalogOfferingsResponse.traceId")
            .value("mock_trace"));
  }

  @Test
  public void testControllerResponse400() throws Exception {
    // Setup Mock vars and behavior
    Request request = new Request();

    // Call improper url and expect error
    mvc.perform(MockMvcRequestBuilders.post("/catalogoffering").accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON).content(asJsonString(request)))
        .andExpect(MockMvcResultMatchers.status().is4xxClientError());
  }

  public static String asJsonString(final Object obj) {
    try {
      final ObjectMapper mapper = new ObjectMapper();
      final String jsonContent = mapper.writeValueAsString(obj);
      return jsonContent;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
