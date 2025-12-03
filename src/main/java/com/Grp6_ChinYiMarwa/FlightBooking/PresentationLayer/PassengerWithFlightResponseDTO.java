package com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PassengerWithFlightResponseDTO {

    private Long passengerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    private String passportNumber;
    private LocalDate passportExpiryDate;
    private String creditCardNumber;
    private int numOfBaggage;


    private FlightsResponseDTO flightsResponseDTO;
}
