package com.Grp6_ChinYiMarwa.FlightBooking.MapperLayer;


import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.Flights;
import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.Passenger;
import com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer.FlightsRequestDTO;
import com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer.FlightsResponseDTO;
import com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer.PassengerResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class PassengerMapper {


    public static PassengerResponseDTO toResponse(Passenger passenger){
        Flights flights = passenger.getFlight();

        return new PassengerResponseDTO(passenger.getPassengerId(), passenger.getFirstName(),passenger.getLastName()
                );
    }

//    public Flights toEntity(FlightsRequestDTO flightRequest){
//        if(flightRequest==null)
//            return null;
//
//        Flights f1=new Flights();
//        f1.setAirline(flightRequest.getAirline());
//        f1.setPlaceDepart(flightRequest.getPlaceDepart());
//        f1.setDepartDate(flightRequest.getDepartDate());
//        f1.setDepartTime(flightRequest.getDepartTime());
//        f1.setDestination(flightRequest.getDestination());
//        f1.setArrivalDate(flightRequest.getArrivalDate());
//        f1.setArrivalTime(flightRequest.getArrivalTime());
//        f1.setPrice(flightRequest.getPrice());
//
//        return f1;
//    }




}
