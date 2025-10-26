package com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
