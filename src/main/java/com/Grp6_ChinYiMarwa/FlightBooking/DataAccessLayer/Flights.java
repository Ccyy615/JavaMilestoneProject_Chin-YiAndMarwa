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
import java.util.List;
import java.util.Map;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Flights {

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;

    private String airline;
    private String placeDepart;
    private String destination;
    private LocalDate departDate;
    private LocalDate arrivalDate;
    private LocalTime departTime;
    private LocalTime arrivalTime;
    private String internalCode;
    @Min(50)
    private double price;

    @OneToMany(mappedBy="flight",cascade = CascadeType.ALL)
//    @JoinColumn(name = "passenger_id")
    private List<Passenger> passenger;


    public Flights(String airline, String placeDepart, String destination,
                   LocalDate departDate,
                   LocalDate arrivalDate, LocalTime departTime,
                   LocalTime arrivalTime, double price,String internalCode) {
        this.airline = airline;
        this.placeDepart = placeDepart;
        this.destination = destination;
        this.departDate = departDate;
        this.arrivalDate = arrivalDate;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
        this.internalCode=internalCode;
        this.price = price;

    }

}
