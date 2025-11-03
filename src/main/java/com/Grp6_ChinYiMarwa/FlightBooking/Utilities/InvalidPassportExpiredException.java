package com.Grp6_ChinYiMarwa.FlightBooking.Utilities;

public class InvalidPassportExpiredException extends RuntimeException{

    public InvalidPassportExpiredException(String message) {
        super(message);
    }
}
