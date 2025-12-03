package com.Grp6_ChinYiMarwa.FlightBooking.MapperLayer;

import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.Flights;
import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.FlightsRepository;
import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.Passenger;
import com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer.*;
import org.springframework.stereotype.Component;

@Component
public class PassengerMapper {

    private final FlightsRepository flightsRepository;

    // Constructor injection for FlightsRepository
    public PassengerMapper(FlightsRepository flightsRepository) {
        this.flightsRepository = flightsRepository;
    }

    public PassengerResponseDTO toResponse(Passenger passenger) {
        if (passenger == null) {
            return null;
        }

        Long flightId = null;
        if (passenger.getFlight() != null) {
            flightId = passenger.getFlight().getFlightId();
        }

        return new PassengerResponseDTO(
                passenger.getPassengerId(),
                passenger.getFirstName(),
                passenger.getLastName(),
                passenger.getPhoneNumber(),
                passenger.getEmail(),
                passenger.getPassportNumber(),
                passenger.getPassportExpiryDate(),
                passenger.getCreditCardNumber(),
                passenger.getNumOfBaggage(),
                flightId
        );
    }

    public Passenger fromRequestDTOtoPassengerEntity(PassengerRequestDTO passengerRequestDTO) {
        if (passengerRequestDTO == null) {
            return null;
        }

        Passenger passenger = new Passenger();

        // Set all fields from DTO
        passenger.setFirstName(passengerRequestDTO.getFirstName());
        passenger.setLastName(passengerRequestDTO.getLastName());
        passenger.setDateOfBirth(passengerRequestDTO.getDateOfBirth());
        passenger.setGender(passengerRequestDTO.getGender());
        passenger.setAddress(passengerRequestDTO.getAddress());
        passenger.setPhoneNumber(passengerRequestDTO.getPhoneNumber());
        passenger.setEmail(passengerRequestDTO.getEmail());
        passenger.setPassportNumber(passengerRequestDTO.getPassportNumber());
        passenger.setPassportExpiryDate(passengerRequestDTO.getPassportExpiryDate());
        passenger.setCreditCardNumber(passengerRequestDTO.getCreditCardNumber());
        passenger.setNumOfBaggage(passengerRequestDTO.getNumOfBaggage());

        // MOST IMPORTANT: Find and set the Flight entity
        if (passengerRequestDTO.getFlightId() != null) {
            Flights flight = flightsRepository.findById(passengerRequestDTO.getFlightId())
                    .orElseThrow(() -> new RuntimeException("Flight not found with id: " + passengerRequestDTO.getFlightId()));
            passenger.setFlight(flight);
        } else {
            throw new RuntimeException("Flight ID is required");
        }

        return passenger;
    }

    // Optional: Keep if you need it elsewhere
    public static PassengerResponseDTO toResponseToFlight(Passenger passenger) {
        if (passenger == null) {
            return null;
        }

        Flights flights = passenger.getFlight();
        Long flightId = (flights != null) ? flights.getFlightId() : null;

        return new PassengerResponseDTO(
                passenger.getPassengerId(),
                passenger.getFirstName(),
                passenger.getLastName(),
                passenger.getPhoneNumber(),
                passenger.getEmail(),
                passenger.getPassportNumber(),
                passenger.getPassportExpiryDate(),
                passenger.getCreditCardNumber(),
                passenger.getNumOfBaggage(),
                flightId
        );
    }
}