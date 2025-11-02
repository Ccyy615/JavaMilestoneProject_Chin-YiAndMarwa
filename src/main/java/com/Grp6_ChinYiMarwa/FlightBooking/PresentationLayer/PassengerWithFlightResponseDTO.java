package com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PassengerWithFlightResponseDTO {

    private Long passengerId;
    private String firstName;
    private String lastName;
    private String email;

    private List<FlightsResponseDTO> flightsResponseDTO;
}
