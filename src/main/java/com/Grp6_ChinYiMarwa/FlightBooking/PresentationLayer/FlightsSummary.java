package com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FlightsSummary {

    private Long flightId;
    private String placeDepart;
    private LocalTime departTime;
    private String destination;

}

