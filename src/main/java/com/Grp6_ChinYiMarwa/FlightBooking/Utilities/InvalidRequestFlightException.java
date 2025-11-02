package com.Grp6_ChinYiMarwa.FlightBooking.Utilities;

public class InvalidRequestFlightException extends RuntimeException{

    public InvalidRequestFlightException(String message){
        super(message);
    }
}
