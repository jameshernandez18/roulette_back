package com.demo.roulette.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private long confirmation;
    private String operation;
    private HttpStatus httpStatus;
    private String message;
    private Date timeStamp;
}
