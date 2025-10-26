package com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PassengerSummary {

    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String email;
    private int passportNumber;
    private LocalDate passportExpiryDate;
}
