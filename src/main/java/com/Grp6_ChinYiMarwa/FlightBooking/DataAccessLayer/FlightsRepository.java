package com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import org.springframework.stereotype.Repository;


public interface FlightsRepository extends JpaRepository<Flights,Long> {

    List<Flights> findByPassenger(Passenger passenger);

}
