package com.demo.roulette.config;

import com.demo.roulette.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("generalFunctions")
public class GeneralFunctions {

    public ResponseDto response(long confirmation, HttpStatus httpStatus, String message, String operation) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setConfirmation(confirmation);
        responseDto.setHttpStatus(httpStatus);
        responseDto.setMessage(message);
        responseDto.setOperation(operation);
        responseDto.setTimeStamp(new Date());
        return responseDto;
    }

}
