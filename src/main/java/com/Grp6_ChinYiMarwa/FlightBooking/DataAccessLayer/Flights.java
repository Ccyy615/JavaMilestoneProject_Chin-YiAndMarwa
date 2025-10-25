package com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Flights {

    @Id
    @GeneratedValue
    @NotNull
    private String flightId; //PK


    private String airLine;

    @NotBlank
    private String placeDepart;
    @NotBlank
    private String destination;

    @FutureOrPresent
    private LocalDate departDate;

    @Future
    private LocalDate arrivalDate;

    @FutureOrPresent
    private LocalDateTime departTime;
    @Future
    private LocalDateTime arrivalTime;

    @Min(50)
    private double price;


    public Flights(String airLine, String placeDepart, String destination,
                   LocalDate departDate,
                   LocalDate arrivalDate, LocalDateTime departTime,
                   LocalDateTime arrivalTime, double price) {
        this.airLine = airLine;
        this.placeDepart = placeDepart;
        this.destination = destination;
        this.departDate = departDate;
        this.arrivalDate = arrivalDate;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }

}
