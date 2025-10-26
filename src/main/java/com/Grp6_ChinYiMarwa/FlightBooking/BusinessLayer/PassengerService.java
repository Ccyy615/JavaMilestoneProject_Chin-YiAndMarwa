package com.Grp6_ChinYiMarwa.FlightBooking.BusinessLayer;


import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.Passenger;
import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository=passengerRepository;
    }

    public List<Passenger> getPassengers() {

        return this.passengerRepository.findAll();
    }

    public Optional<Passenger> getPassengerById(Long id) {
        return this.passengerRepository.findById(id);
    }

    public Passenger createPassenger(Map<String, Object> passengerData) {

        Passenger passenger = new Passenger();
        passenger.setFirstName( passengerData.get("firstName").toString());
        passenger.setLastName(passengerData.get("lastName").toString());

        Passenger savedNewPassenger = this.passengerRepository.save(passenger);
        return savedNewPassenger;

    }

    public Passenger updatePassenger(Long id, Map<String, Object> passengerData) {

        Passenger passenger = this.passengerRepository.findById(id).get();
        passenger.setFirstName( passengerData.get("firstName").toString());
        passenger.setLastName(passengerData.get("lastName").toString());

        Passenger savedPassenger = this.passengerRepository.save(passenger);
        return savedPassenger;
    }

    public void deletePassenger(Long id) {
        this.passengerRepository.deleteById(id);
    }

}
