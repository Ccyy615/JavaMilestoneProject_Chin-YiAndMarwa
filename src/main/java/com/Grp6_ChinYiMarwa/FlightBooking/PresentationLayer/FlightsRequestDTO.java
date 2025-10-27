package com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
public class FlightsRequestDTO {

    private Long flightId; //PK
    private String airline;
    private String placeDepart;
    private String destination;
    private LocalDate departDate;
    private LocalDate arrivalDate;
    private LocalTime departTime;
    private LocalTime arrivalTime;
    private double price;

}
