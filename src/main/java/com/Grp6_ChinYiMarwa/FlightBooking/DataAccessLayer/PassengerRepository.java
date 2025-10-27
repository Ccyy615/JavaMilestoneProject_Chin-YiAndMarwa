package com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {

    List<Passenger> findByFlight(Flights flights);
}
