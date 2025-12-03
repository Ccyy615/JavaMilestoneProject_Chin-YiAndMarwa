package com.Grp6_ChinYiMarwa.FlightBooking.BusinessLayer;

import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.Flights;
import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.FlightsRepository;
import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.Passenger;
import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.PassengerRepository;
import com.Grp6_ChinYiMarwa.FlightBooking.MapperLayer.FlightsMapper;
import com.Grp6_ChinYiMarwa.FlightBooking.MapperLayer.PassengerMapper;
import com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer.FlightsResponseDTO;
import com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer.PassengerRequestDTO;
import com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer.PassengerResponseDTO;
import com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer.PassengerWithFlightResponseDTO;
import com.Grp6_ChinYiMarwa.FlightBooking.Utilities.InvalidAgeBookingException;
import com.Grp6_ChinYiMarwa.FlightBooking.Utilities.InvalidPassengerIdException;
import com.Grp6_ChinYiMarwa.FlightBooking.Utilities.InvalidPassportExpiredException;
import com.Grp6_ChinYiMarwa.FlightBooking.Utilities.PassengerNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;
    private final PassengerMapper passengerMapper;
    private final FlightsRepository flightsRepository;
    private final FlightsMapper flightsMapper;

    public PassengerService(PassengerRepository passengerRepository,
                            PassengerMapper passengerMapper,
                            FlightsRepository flightsRepository,
                            FlightsMapper flightsMapper) {
        this.passengerRepository = passengerRepository;
        this.passengerMapper = passengerMapper;
        this.flightsRepository = flightsRepository;
        this.flightsMapper = flightsMapper;
    }

    public List<PassengerResponseDTO> getPassengers() {
        List<Passenger> passengers = this.passengerRepository.findAll();
        List<PassengerResponseDTO> passengerResponseDTOs = new ArrayList<>();
        for(Passenger passenger : passengers) {
            passengerResponseDTOs.add(this.passengerMapper.toResponse(passenger));
        }
        return passengerResponseDTOs;
    }

    public PassengerResponseDTO getPassengerById(String id) {
        try{
            long idLong = Long.parseLong(id);
            return this.passengerRepository.findById(idLong)
                    .map(this.passengerMapper::toResponse)
                    .orElseThrow(() -> new PassengerNotFoundException("Passenger " + id + " not Found"));
        } catch(NumberFormatException ex) {
            throw new InvalidPassengerIdException("Invalid id format " + id + " Valid Id format ex. 1");
        }
    }

    public PassengerResponseDTO createPassenger(PassengerRequestDTO passengerData) {

        // Check if passportExpiryDate is not null before comparing
        if (passengerData.getPassportExpiryDate() != null &&
                passengerData.getPassportExpiryDate().isBefore(LocalDate.now())) {
            throw new InvalidPassportExpiredException("Passport is expired");
        }

        // Check if dateOfBirth is not null before calculating age
        if (passengerData.getDateOfBirth() != null) {
            int age = Period.between(passengerData.getDateOfBirth(), LocalDate.now()).getYears();
            if (age < 18) {
                throw new InvalidAgeBookingException("Invalid Age: Must be 18 or older");
            }
        }

        // Validate required fields
        if (passengerData.getFirstName() == null || passengerData.getFirstName().trim().isEmpty()) {
            throw new RuntimeException("First name is required");
        }

        if (passengerData.getLastName() == null || passengerData.getLastName().trim().isEmpty()) {
            throw new RuntimeException("Last name is required");
        }

        if (passengerData.getFlightId() == null) {
            throw new RuntimeException("Flight ID is required");
        }

        // Check if flight exists
        if (!flightsRepository.existsById(passengerData.getFlightId())) {
            throw new RuntimeException("Flight not found with id: " + passengerData.getFlightId());
        }

        Passenger newPassenger = this.passengerMapper.fromRequestDTOtoPassengerEntity(passengerData);
        Passenger savedPassenger = this.passengerRepository.save(newPassenger);

        return this.passengerMapper.toResponse(savedPassenger);
    }

    public PassengerResponseDTO updatePassenger(String id, PassengerRequestDTO passengerData) {
        try {
            long idLong = Long.parseLong(id);
            Optional<Passenger> passenger = this.passengerRepository.findById(idLong);
            if(passenger.isEmpty())
                throw new PassengerNotFoundException("Passenger " + id + " not Found.");

            Passenger newPassenger = this.passengerMapper.fromRequestDTOtoPassengerEntity(passengerData);
            newPassenger.setPassengerId(idLong);
            Passenger updatedPassenger = this.passengerRepository.save(newPassenger);

            return passengerMapper.toResponse(updatedPassenger);
        } catch(NumberFormatException ex) {
            throw new InvalidPassengerIdException("Invalid id format " + id + " Valid Id format ex. 1");
        }
    }

    public void deletePassenger(String id) {
        try {
            long idLong = Long.parseLong(id);
            this.passengerRepository.deleteById(idLong);
        } catch(NumberFormatException ex) {
            throw new InvalidPassengerIdException("Invalid id format " + id + " Valid Id format ex. 1");
        }
    }

    public List<PassengerWithFlightResponseDTO> getFlightByPassengerId(String id) {
        try {
            long longId = Long.parseLong(id);
            Passenger passenger = this.passengerRepository.findById(longId)
                    .orElseThrow(() -> new PassengerNotFoundException("Passenger with given id is not found: " + id));

            // Get only the first flight
            Flights flight = this.flightsRepository.findByPassenger(passenger).stream().findFirst().orElse(null);

            FlightsResponseDTO flightResponseDTO = null;
            if (flight != null) {
                flightResponseDTO = flightsMapper.toResponse(flight);
            }

            PassengerWithFlightResponseDTO passengerWithFlightResponseDTO =
                    getPassengerWithFlightResponseDTO(passenger, flightResponseDTO);

            return Collections.singletonList(passengerWithFlightResponseDTO);
        } catch (NumberFormatException ex) {
            throw new InvalidPassengerIdException("Invalid id format " + id + ". Valid Id format ex. 1");
        }
    }

    private static PassengerWithFlightResponseDTO getPassengerWithFlightResponseDTO(Passenger passenger, FlightsResponseDTO flightsResponseDTOS) {
        PassengerWithFlightResponseDTO passengerWithFlightResponseDTO = new PassengerWithFlightResponseDTO();
        passengerWithFlightResponseDTO.setPassengerId(passenger.getPassengerId());
        passengerWithFlightResponseDTO.setFirstName(passenger.getFirstName());
        passengerWithFlightResponseDTO.setLastName(passenger.getLastName());
        passengerWithFlightResponseDTO.setEmail(passenger.getEmail());
        passengerWithFlightResponseDTO.setFlightsResponseDTO(flightsResponseDTOS);
        return passengerWithFlightResponseDTO;
    }
}