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
    public ResponseEntity<Map<String,Object>> BadRequestFlight(InvalidRequestFlightException flight,HttpServletRequest requestPath){

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

    @ExceptionHandler({InvalidPassengerIdException.class})
    public ResponseEntity<Map<String,Object>> BadRequestPassenger(InvalidPassengerIdException passenger,HttpServletRequest requestPath){

        Map<String,Object> bodyResponse= new HashMap<>();
        bodyResponse.put("timestamp",LocalDateTime.now());
        bodyResponse.put("status", HttpStatus.BAD_REQUEST.value());
        bodyResponse.put("error","Bad request format");
        bodyResponse.put("message",passenger.getMessage());
        bodyResponse.put("path", requestPath.getRequestURI());

        return new ResponseEntity<>(bodyResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({PassengerNotFoundException.class})
    public ResponseEntity<Map<String,Object>> FlightNotFound(PassengerNotFoundException passenger, HttpServletRequest requestPath){

        Map<String,Object> bodyResponse = new HashMap<>();
        bodyResponse.put("timestamp", LocalDateTime.now());
        bodyResponse.put("status", HttpStatus.NOT_FOUND.value());
        bodyResponse.put("error","The id that was given does not correspond to any passengers");
        bodyResponse.put("message",passenger.getMessage());
        bodyResponse.put("path", requestPath.getRequestURI());

        return new ResponseEntity<>(bodyResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({InvalidPassportExpiredException.class})
    public ResponseEntity<Map<String,Object>> PassengerPassportExpired(InvalidPassportExpiredException passport,HttpServletRequest requestPath){

        Map<String,Object> bodyResponse= new HashMap<>();
        bodyResponse.put("timestamp",LocalDateTime.now());
        bodyResponse.put("status", HttpStatus.BAD_REQUEST.value());
        bodyResponse.put("error","Invalid passport");
        bodyResponse.put("message",passport.getMessage());
        bodyResponse.put("path", requestPath.getRequestURI());

        return new ResponseEntity<>(bodyResponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({InvalidAgeBookingException.class})
    public ResponseEntity<Map<String,Object>> PassengerPassportExpired(InvalidAgeBookingException passport,HttpServletRequest requestPath){

        Map<String,Object> bodyResponse= new HashMap<>();
        bodyResponse.put("timestamp",LocalDateTime.now());
        bodyResponse.put("status", HttpStatus.BAD_REQUEST.value());
        bodyResponse.put("error","You must be 18+ to book a flight");
        bodyResponse.put("message",passport.getMessage());
        bodyResponse.put("path", requestPath.getRequestURI());

        return new ResponseEntity<>(bodyResponse,HttpStatus.BAD_REQUEST);
    }

}
