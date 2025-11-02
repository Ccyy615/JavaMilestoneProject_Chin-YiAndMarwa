package com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer;

import jakarta.persistence.Access;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PassengerSummaryDTO {

    private Long passengerId;
    private String firstName;
    private String lastName;
}
