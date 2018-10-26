package com.travelport.refimpl.air.search.responseMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.travelport.refimpl.air.search.models.Error;
import com.travelport.refimpl.air.search.models.Result;
import com.travelport.refimpl.air.search.models.Warning;
import com.travelport.schema.common_v45_0.ResponseMessage;

/**
 * The Class ResultMapper.
 */
@Component
public class ResultMapper {
  
  /**
   * Map result.
   *
   * @param responseMessages the response messages
   * @return the result
   */
  public Result mapResult(List<ResponseMessage> responseMessages) {
    Result result = null;
    if (responseMessages != null) {
      result = new Result();
      result.setType("Result");
      result.setError(mapErrors(responseMessages));
      result.setWarning(mapWarnings(responseMessages));
    }

    return result;
  }

  /**
   * Map errors.
   *
   * @param responseMessages the response messages
   * @return the list
   */
  private List<Error> mapErrors(List<ResponseMessage> responseMessages) {
    List<Error> errors = new ArrayList<Error>();

    for (ResponseMessage responseMessage : responseMessages) {
      if (responseMessage.getType().equals("Error")) {
        Error error = new Error();
        error.setType("Error");
        error.setStatusCode(responseMessage.getCode().intValue());
        error.setMessage(responseMessage.getValue());
        errors.add(error);
      }
    }

    return errors.isEmpty() ? null : errors;
  }

  /**
   * Map warnings.
   *
   * @param responseMessages the response messages
   * @return the list
   */
  private List<Warning> mapWarnings(List<ResponseMessage> responseMessages) {
    List<Warning> warnings = new ArrayList<Warning>();

    for (ResponseMessage responseMessage : responseMessages) {
      if (responseMessage.getType().equals("Warning")) {
        Warning warning = new Warning();
        warning.setType("Warning");
        warning.setStatusCode(responseMessage.getCode().intValue());
        warning.setMessage(responseMessage.getValue());
        warnings.add(warning);
      }
    }

    return warnings.isEmpty() ? null : warnings;
  }
}
