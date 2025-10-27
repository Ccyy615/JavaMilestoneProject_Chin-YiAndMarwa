package com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class FlightsResponseDTO {

    private Long flightId;//PK
    private String airline;

    private String placeDepart;
    private LocalDate departDate;
    private LocalTime departTime;

    private String destination;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;

    private double price;
}
