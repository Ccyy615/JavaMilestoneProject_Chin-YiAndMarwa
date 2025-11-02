package com.Grp6_ChinYiMarwa.FlightBooking.Utilities;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({InvalidRequestFlightException.class})
    public ResponseEntity<Map<String,Object>> BadRequestHandler(InvalidRequestFlightException flight,HttpServletRequest requestPath){

        Map<String,Object> bodyResponse= new HashMap<>();
        bodyResponse.put("timestamp",LocalDateTime.now());
        bodyResponse.put("status", HttpStatus.BAD_REQUEST.value());
        bodyResponse.put("error","Bad request format");
        bodyResponse.put("message",flight.getMessage());
        bodyResponse.put("path", requestPath.getRequestURI());

        return new ResponseEntity<>(bodyResponse,HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler({FlightNotFoundException.class})
    public ResponseEntity<Map<String,Object>> FlightNotFound(FlightNotFoundException flight, HttpServletRequest requestPath){

        Map<String,Object> bodyResponse = new HashMap<>();
        bodyResponse.put("timestamp", LocalDateTime.now());
        bodyResponse.put("status", HttpStatus.NOT_FOUND.value());
        bodyResponse.put("error","The id that was given does not correspond to any flight");
        bodyResponse.put("message",flight.getMessage());
        bodyResponse.put("path", requestPath.getRequestURI());


        return new ResponseEntity<>(bodyResponse,HttpStatus.NOT_FOUND);
    }

}