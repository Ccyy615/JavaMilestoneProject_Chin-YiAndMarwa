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
    private String departTime;
    private String destination;


    public FlightsSummary(Long flightId, String placeDepart, LocalTime departTime, String destination) {
    }
}
