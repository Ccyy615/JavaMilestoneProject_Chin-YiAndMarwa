package com.Grp6_ChinYiMarwa.FlightBooking.BusinessLayer;


import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.Passenger;
import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.PassengerRepository;
import com.Grp6_ChinYiMarwa.FlightBooking.MapperLayer.PassengerMapper;
import com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer.PassengerRequestDTO;
import com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer.PassengerResponseDTO;
import com.Grp6_ChinYiMarwa.FlightBooking.Utilities.PassengerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;
    private final PassengerMapper passengerMapper;

    public PassengerService(PassengerRepository passengerRepository, PassengerMapper passengerMapper) {
        this.passengerRepository=passengerRepository;
        this.passengerMapper=passengerMapper;
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
        long idLong = Long.parseLong(id);
        return this.passengerRepository.findById(idLong)
                .map(this.passengerMapper::toResponse)
                .orElseThrow(()-> new PassengerNotFoundException("Passenger " + id + " not Found"));
    }

    public PassengerResponseDTO createPassenger(PassengerRequestDTO passengerData) {

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
    }

    public void deletePassenger(String id) {
        long idLong = Long.parseLong(id);
        this.passengerRepository.deleteById(idLong);
    }
}
