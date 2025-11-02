package com.Grp6_ChinYiMarwa.FlightBooking.MapperLayer;

import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.Flights;
import com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer.FlightsRequestDTO;
import com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer.FlightsResponseDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
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

    public Flights toEntity(FlightsRequestDTO flightRequest){
        if(flightRequest==null)
            return null;

        Flights f1=new Flights();
        f1.setAirline(flightRequest.getAirline());
        f1.setPlaceDepart(flightRequest.getPlaceDepart());
        f1.setDepartDate(flightRequest.getDepartDate());
        f1.setDepartTime(flightRequest.getDepartTime());
        f1.setDestination(flightRequest.getDestination());
        f1.setArrivalDate(flightRequest.getArrivalDate());
        f1.setArrivalTime(flightRequest.getArrivalTime());
        f1.setPrice(flightRequest.getPrice());
        f1.setInternalCode(flightRequest.getInternalCode());

        return f1;
    }
    //2- toEntity create a new Flight accorded to the requestDTO
}
