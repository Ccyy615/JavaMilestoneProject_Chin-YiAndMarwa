package com.Grp6_ChinYiMarwa.FlightBooking.MapperLayer;


import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.Flights;
import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.Passenger;
import com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer.FlightsSummary;
import com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer.PassengerRequestDTO;
import com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer.PassengerResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class PassengerMapper {

    public static PassengerResponseDTO toResponseToFlight(Passenger passenger){
        Flights flights = passenger.getFlight();

        FlightsSummary flightsSummaryToFlight;

        if( flights == null)
            flightsSummaryToFlight=null;
        else
            flightsSummaryToFlight= new FlightsSummary(flights.getFlightId(), flights.getPlaceDepart(),flights.getDepartTime(),flights.getDestination());

        return new PassengerResponseDTO(passenger.getPassengerId(),passenger.getFirstName(),passenger.getLastName(),
                passenger.getPhoneNumber(), passenger.getEmail());
    }

    public PassengerResponseDTO toResponse(Passenger passenger){

        Flights flight = passenger.getFlight();
        FlightsSummary flightsSummary;

        if( flight == null)
            flightsSummary=null;
        else
            flightsSummary= new FlightsSummary(flight.getFlightId(), flight.getPlaceDepart(),
                    flight.getDepartTime(),flight.getDestination());

        return new PassengerResponseDTO(passenger.getPassengerId(),passenger.getFirstName(),passenger.getLastName(),
                passenger.getPhoneNumber(), passenger.getEmail());

//        return new PassengerResponseDTO(passenger.getPassengerId(),passenger.getFirstName(), passenger.getLastName(),
//                passenger.getGender(),passenger.getAddress(), passenger.getPhoneNumber(),
//                passenger.getEmail(), passenger.getPassportNumber(), passenger.getPassportExpiryDate(),
//                passenger.getCreditCardNumber(),passenger.getNumOfBaggage(), flightsSummary);
    }

    public Passenger fromRequestDTOtoPassengerEntity(PassengerRequestDTO passengerRequestDTO){

        if(passengerRequestDTO == null)
            return null;

        Passenger passenger = new Passenger();

        passenger.setFirstName(passengerRequestDTO.getFirstName());
        passenger.setLastName(passengerRequestDTO.getLastName());
        passenger.setPhoneNumber(passengerRequestDTO.getPhoneNumber());
        passenger.setAddress(passengerRequestDTO.getAddress());
        passenger.setEmail(passengerRequestDTO.getEmail());
        passenger.setPassportNumber(passengerRequestDTO.getPassportNumber());
        passenger.setPassportExpiryDate(passengerRequestDTO.getPassportExpiryDate());

        return passenger;
    }
}
