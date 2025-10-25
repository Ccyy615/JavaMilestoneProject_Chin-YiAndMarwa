package com.Grp6_ChinYiMarwa.FlightBooking.MapperLayer;

import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.Flights;
import com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer.FlightsResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FlightsMapper {

    //1- toResponse how it will respond

    public FlightsResponseDTO toResponse(Flights flight){
        return new FlightsResponseDTO (

                flight.getFlightId(),
                flight.getAirline(),

                flight.getPlaceDepart(),
                flight.getDepartDate(),
                flight.getDepartTime(),

                flight.getDestination(),
                flight.getArrivalDate(),
                flight.getArrivalTime(),

                flight.getPrice()
        );

    }
    //2- toEntity create a new Flight accorded to the requestDTO
}
