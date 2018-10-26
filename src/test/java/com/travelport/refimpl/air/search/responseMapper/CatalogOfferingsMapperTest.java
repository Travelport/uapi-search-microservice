package com.travelport.refimpl.air.search.responseMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.cxf.helpers.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.travelport.refimpl.air.search.models.CatalogOfferings;
import com.travelport.refimpl.air.search.models.Price;
import com.travelport.refimpl.air.search.models.ProductOption;
import com.travelport.refimpl.air.search.models.TermsAndConditions;
import com.travelport.schema.air_v45_0.AirPricePoint;
import com.travelport.schema.air_v45_0.LowFareSearchRsp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CatalogOfferingsMapperTest {

  @Autowired
  CatalogOfferingsMapper MAPPER;

  @MockBean
  TermsAndConditionsObjectMapper tcMapper;

  @MockBean
  PriceMapper priceMapper;

  @MockBean
  ProductMapper productMapper;

  static JAXBContext jaxbContext;
  LowFareSearchRsp lfsRsp = new LowFareSearchRsp();

  @Before
  public void setupLfsResponse() throws IOException {
    String responseEnvelope = IOUtils
        .toString(getClass().getResourceAsStream("/lfs/catalogOfferingsTest.xml"));
    try {
      // Needed for unmarshalling the service request
      jaxbContext = JAXBContext.newInstance(LowFareSearchRsp.class);
      Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
      StringReader reader = new StringReader(responseEnvelope);
      // Cast SOAP string to service Request Object
      lfsRsp = (LowFareSearchRsp) unmarshaller.unmarshal(reader);
    } catch (Exception e) {
      throw new IllegalStateException(e);
    }
  }

  @Test
  public void testMapCatalogOfferingsBasic() {
    // Set up mock behaviors
    Mockito.when(tcMapper.mapTermsAndConditions(Mockito.any(AirPricePoint.class), Mockito.anyMap()))
        .thenReturn(new TermsAndConditions());
    Mockito.when(priceMapper.mapPrice(Mockito.any(AirPricePoint.class), Mockito.anyString()))
        .thenReturn(new Price());
    Mockito.when(productMapper.mapProductOptions(Mockito.any(AirPricePoint.class), Mockito.anyMap(),
        Mockito.anyMap(), Mockito.anyMap())).thenReturn(new ArrayList<ProductOption>());

    // Call the class we are testing
    CatalogOfferings catalogOfferings = MAPPER.mapCatalogOfferings(lfsRsp, null);

    // Asserts
    assertNotNull(catalogOfferings);
    assertEquals(catalogOfferings.getDefaultCurrency().getCode(), "AUD");
    assertEquals(catalogOfferings.getIdentifier().getAuthority(), "Travelport");
    assertEquals(catalogOfferings.getId(), "s1");
  }

}
