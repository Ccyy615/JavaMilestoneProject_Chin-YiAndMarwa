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
    private final FlightsRepository  flightsRepository;
    private final FlightsMapper flightsMapper;

    public List<Passenger> getAllPassengers() {
        return this.passengerRepository.findAll();
    }

    public PassengerService(PassengerRepository passengerRepository, PassengerMapper passengerMapper,
                            FlightsRepository flightsRepository, FlightsMapper flightsMapper) {
        this.passengerRepository=passengerRepository;
        this.passengerMapper=passengerMapper;
        this.flightsRepository=flightsRepository;
        this.flightsMapper = flightsMapper;
    }

    public List<PassengerResponseDTO> getPassengers() {
        List<Passenger> passengers = this.passengerRepository.findAll();
        List<PassengerResponseDTO> passengerResponseDTO= new ArrayList<>();
        for(Passenger passenger : passengers) {
            passengerResponseDTO.add(this.passengerMapper.toResponse(passenger));
        }
        return passengerResponseDTO;
    }


    public PassengerResponseDTO getPassengerById(String id) {
        try{
            long idLong = Long.parseLong(id);
            return this.passengerRepository.findById(idLong)
                    .map(this.passengerMapper::toResponse)
                    .orElseThrow(()-> new PassengerNotFoundException("Passenger " + id + " not Found"));
        }catch(NumberFormatException ex){
            throw new InvalidPassengerIdException("Invalid id format"+id+" Valid Id format ex. 1");
        }

    }



    public PassengerResponseDTO createPassenger(PassengerRequestDTO passengerData) {

        if (passengerData.getPassportExpiryDate().isBefore(LocalDate.now())) {
            throw new InvalidPassportExpiredException("Passport is expired");
        }else if (Period.between(passengerData.getDateOfBirth(), LocalDate.now()).getYears() < 18){
            throw new InvalidAgeBookingException("Invalid Age");
        }
            Passenger newPassenger = this.passengerMapper.fromRequestDTOtoPassengerEntity(passengerData);
            Passenger saveNewPassenger = this.passengerRepository.save(newPassenger);

            return this.passengerMapper.toResponse(saveNewPassenger);
        /*Passenger passenger = new Passenger();
        passenger.setFirstName( passengerData.get("firstName").toString());
        passenger.setLastName(passengerData.get("lastName").toString());
        Passenger savedNewPassenger = this.passengerRepository.save(passenger);
        return savedNewPassenger;*/
    }

    public PassengerResponseDTO updatePassenger(String id, PassengerRequestDTO passengerData) {
try{
    long idLong = Long.parseLong(id);
    Optional<Passenger> passenger = this.passengerRepository.findById(idLong);
    if(passenger.isEmpty())
        throw new PassengerNotFoundException("Passenger "+id+" not Found.");

    Passenger newPassenger = this.passengerMapper.fromRequestDTOtoPassengerEntity(passengerData);

    newPassenger.setPassengerId(idLong);
    Passenger updatedPassenger = this.passengerRepository.save(newPassenger);

    return passengerMapper.toResponse(updatedPassenger);
        /*Passenger passenger = this.passengerRepository.findById(id).get();
        passenger.setFirstName( passengerData.get("firstName").toString());
        passenger.setLastName(passengerData.get("lastName").toString());
        Passenger savedPassenger = this.passengerRepository.save(passenger);
        return savedPassenger;*/
}catch(NumberFormatException ex){
    throw new InvalidPassengerIdException("Invalid id format"+id+" Valid Id format ex. 1");
}

    }

    public void deletePassenger(String id) {
        try{
            long idLong = Long.parseLong(id);
            this.passengerRepository.deleteById(idLong);

        }catch(NumberFormatException ex){
            throw new InvalidPassengerIdException("Invalid id format"+id+" Valid Id format ex. 1");
        }

    }

    public List<PassengerWithFlightResponseDTO> getFlightByPassengerId(String id) {
        try{
            long longId = Long.parseLong(id);
            Passenger passenger = this.passengerRepository.findById(longId)
                    .orElseThrow(() -> new PassengerNotFoundException("Passenger with given id is not found: " + id));

            List<Flights> flights = this.flightsRepository.findByPassenger(passenger);
            List<FlightsResponseDTO> flightsResponseDTOS= flights.stream()
                    .map(flightsMapper::toResponse)
                    .collect(Collectors.toList());

            PassengerWithFlightResponseDTO passengerWithFlightResponseDTO = new PassengerWithFlightResponseDTO();
            passengerWithFlightResponseDTO.setPassengerId(passenger.getPassengerId());
            passengerWithFlightResponseDTO.setFirstName(passenger.getFirstName());
            passengerWithFlightResponseDTO.setLastName(passenger.getLastName());
            passengerWithFlightResponseDTO.setEmail(passenger.getEmail());
            passengerWithFlightResponseDTO.setFlightsResponseDTO(flightsResponseDTOS);

            return Collections.singletonList(passengerWithFlightResponseDTO);
        }catch(NumberFormatException ex){
            throw new InvalidPassengerIdException("Invalid id format"+id+" Valid Id format ex. 1");
        }
    }
}
