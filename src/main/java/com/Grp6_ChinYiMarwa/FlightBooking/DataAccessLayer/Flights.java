package com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Flights {

    @Id //PK
    @GeneratedValue
    @NotNull
    private String flightId;


    private String airline;

    @NotBlank
    private String placeDepart;
    @NotBlank
    private String destination;

    @FutureOrPresent
    private LocalDate departDate;

    @Future
    private LocalDate arrivalDate;

    @FutureOrPresent
    private LocalTime departTime;
    @Future
    private LocalTime arrivalTime;

    @Min(50)
    private double price;


    public Flights(String airline, String placeDepart, String destination,
                   LocalDate departDate,
                   LocalDate arrivalDate, LocalTime departTime,
                   LocalTime arrivalTime, double price) {
        this.airline = airline;
        this.placeDepart = placeDepart;
        this.destination = destination;
        this.departDate = departDate;
        this.arrivalDate = arrivalDate;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }

}
