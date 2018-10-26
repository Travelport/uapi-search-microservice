package com.travelport.refimpl.air.search.responseMapper;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.travelport.refimpl.air.search.models.Result;
import com.travelport.schema.common_v45_0.ResponseMessage;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResultMapperTest {

  @Autowired
  ResultMapper resultMapper;

  ResponseMessage response1 = new ResponseMessage();
  ResponseMessage response2 = new ResponseMessage();
  List<ResponseMessage> responseMessages = new ArrayList<ResponseMessage>();

  @Before
  public void populateResponseMessages() {
    response1.setType("Error");
    response1.setCode(BigInteger.valueOf(1000));
    response1.setValue("Fake error 1");

    response2.setType("Warning");
    response2.setCode(BigInteger.valueOf(2000));
    response2.setValue("Fake warning 1");

    responseMessages.add(response1);
    responseMessages.add(response2);
  }

  @Test
  public void resultMapperErrorsAndWarningsTest() {
    Result result = resultMapper.mapResult(responseMessages);
    assertNotNull(result);
    assertNotNull(result.getError());
    assertNotNull(result.getWarning());
    assertEquals("Fake error 1", result.getError().get(0).getMessage());
    assertEquals(Integer.valueOf(1000), result.getError().get(0).getStatusCode());
    assertEquals("Fake warning 1", result.getWarning().get(0).getMessage());
    assertEquals(Integer.valueOf(2000), result.getWarning().get(0).getStatusCode());
  }

  @Test
  public void resultMapperErrorsTest() {
    responseMessages.get(1).setType("Error");
    Result result = resultMapper.mapResult(responseMessages);
    assertNotNull(result);
    assertNotNull(result.getError());
    assertNull(result.getWarning());
    assertEquals("Fake error 1", result.getError().get(0).getMessage());
    assertEquals(Integer.valueOf(1000), result.getError().get(0).getStatusCode());
    assertEquals("Fake warning 1", result.getError().get(1).getMessage());
    assertEquals(Integer.valueOf(2000), result.getError().get(1).getStatusCode());
  }

  @Test
  public void resultMapperWarningsTest() {
    responseMessages.get(0).setType("Warning");
    Result result = resultMapper.mapResult(responseMessages);
    assertNotNull(result);
    assertNull(result.getError());
    assertNotNull(result.getWarning());
    assertEquals("Fake error 1", result.getWarning().get(0).getMessage());
    assertEquals(Integer.valueOf(1000), result.getWarning().get(0).getStatusCode());
    assertEquals("Fake warning 1", result.getWarning().get(1).getMessage());
    assertEquals(Integer.valueOf(2000), result.getWarning().get(1).getStatusCode());
  }

  @Test
  public void resultMapperNullTest() {
    Result result = resultMapper.mapResult(null);
    assertNull(result);
  }

}
