package com.travelport.refimpl.air.search.responseMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.travelport.refimpl.air.search.models.CatalogOfferings;
import com.travelport.refimpl.air.search.models.ReferenceList;
import com.travelport.refimpl.air.search.models.Response;
import com.travelport.refimpl.air.search.models.Result;
import com.travelport.schema.air_v45_0.AirSegmentList;
import com.travelport.schema.air_v45_0.LowFareSearchRsp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResponseMapperTest {

  @MockBean
  ReferenceListMapper refListMapper;

  @MockBean
  CatalogOfferingsMapper catalogOfferingsMapper;

  @MockBean
  ResultMapper resultMapper;

  @Autowired
  ResponseMapper responseMapper;

  @Test
  public void responseMapperTest() {
    LowFareSearchRsp lfsRsp = new LowFareSearchRsp();
    lfsRsp.setTraceId("test_trace");
    lfsRsp.setTransactionId("test_txn_id");
    lfsRsp.setAirSegmentList(new AirSegmentList());

    Mockito.when(refListMapper.mapReferenceList(Mockito.any()))
        .thenReturn(new ArrayList<ReferenceList>());
    Mockito.when(catalogOfferingsMapper.mapCatalogOfferings(lfsRsp, "test"))
        .thenReturn(new CatalogOfferings());
    Mockito.when(resultMapper.mapResult(Mockito.any())).thenReturn(new Result());

    Response response = responseMapper.mapLowFareSearchRes(lfsRsp, "test");
    assertNotNull(response);
    assertNotNull(response.getCatalogOfferingsResponse());
    assertEquals("test_trace", response.getCatalogOfferingsResponse().getTraceId());
    assertEquals("test_txn_id", response.getCatalogOfferingsResponse().getTransactionId());
  }

}
