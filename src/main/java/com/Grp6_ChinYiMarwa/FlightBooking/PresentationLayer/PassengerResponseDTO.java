package com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PassengerResponseDTO {

    private Long passengerId;
    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    private String phoneNumber;
    private String email;
    private String passportNumber;
    private LocalDate passportExpiryDate;
    private String creditCardNumber;
    private int numOfBaggage;
    private FlightsSummary flightsSummary;

}
