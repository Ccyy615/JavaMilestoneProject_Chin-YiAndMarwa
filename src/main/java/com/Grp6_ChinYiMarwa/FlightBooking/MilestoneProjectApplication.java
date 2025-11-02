package com.Grp6_ChinYiMarwa.FlightBooking;

import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.Flights;
import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.FlightsRepository;
import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.Passenger;
import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.PassengerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

@SpringBootApplication
public class MilestoneProjectApplication implements CommandLineRunner {


    private FlightsRepository flightsRepository;
    private PassengerRepository passengerRepository;

    private static final Logger logger = LoggerFactory.getLogger(MilestoneProjectApplication.class);

    public MilestoneProjectApplication(FlightsRepository flightsRepository, PassengerRepository passengerRepository) {
        this.flightsRepository = flightsRepository;
        this.passengerRepository = passengerRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(MilestoneProjectApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        Flights flight1 = new Flights("Air France", "Montreal, Canada", "Paris, France",
                LocalDate.of(2025, 11, 1),
                LocalDate.of(2025, 11, 2),
                LocalTime.of(20, 0),
                LocalTime.of(8, 0),
                1200.0);

        Flights flight2 = new Flights("Alitalia", "Montreal, Canada", "Milan, Italy",
                LocalDate.of(2025, 11, 3),
                LocalDate.of(2025, 11, 4),
                LocalTime.of(19, 0),
                LocalTime.of(7, 0),
                1150.0);

        Flights flight3 = new Flights("Lufthansa", "Montreal, Canada", "Berlin, Germany",
                LocalDate.of(2025, 11, 5),
                LocalDate.of(2025, 11, 6),
                LocalTime.of(18, 30),
                LocalTime.of(6, 30),
                1100.0);

        Flights flight4= new Flights("Japan Airlines", "Montreal, Canada", "Tokyo, Japan",
                LocalDate.of(2025, 11, 8),
                LocalDate.of(2025, 11, 9),
                LocalTime.of(21, 0),
                LocalTime.of(12, 0),
                1500.0);

        Flights flight5 = new Flights("Eva Air", "Montreal, Canada", "Taipei, Taiwan",
                LocalDate.of(2025, 11, 10),
                LocalDate.of(2025, 11, 11),
                LocalTime.of(22, 0),
                LocalTime.of(14, 0),
                1400.0);

        Flights flight6 = new Flights("Air Algérie", "Montreal, Canada", "Oran, Algeria",
                LocalDate.of(2025, 11, 12),
                LocalDate.of(2025, 11, 13),
                LocalTime.of(20, 0),
                LocalTime.of(8, 0),
                1000.0);


        Flights flight7 = new Flights("United Airlines", "Montreal, Canada", "New York, United-States",
                LocalDate.of(2025, 11, 19),
                LocalDate.of(2025, 11, 19),
                LocalTime.of(7, 30),
                LocalTime.of(9, 0),
                300.0);

        Flights flight8 = new Flights("Iberia", "Montreal, Canada", "Madrid, Spain",
                LocalDate.of(2025, 11, 20),
                LocalDate.of(2025, 11, 21),
                LocalTime.of(19, 0),
                LocalTime.of(9, 0),
                1250.0);


        Flights flight9 = new Flights("Korean Air", "Montreal, Canada", "Seoul, Korea",
                LocalDate.of(2025, 11, 24),
                LocalDate.of(2025, 11, 25),
                LocalTime.of(22, 0),
                LocalTime.of(13, 0),
                1500.0);

        Flights flight10 = new Flights("Emirates", "Montreal, Canada", "Malé, Maldives",
                LocalDate.of(2025, 11, 26),
                LocalDate.of(2025, 11, 27),
                LocalTime.of(21, 0),
                LocalTime.of(10, 0),
                1800.0);



        this.flightsRepository.saveAll(Arrays.asList(flight1,flight2,flight3,flight4,flight5,
                flight6,flight7,flight8,
                flight9,flight10));



        Passenger passenger1 = new Passenger(
                "Maria", "Gomez",
                LocalDate.of(1996, 10, 9),
                "Female",
                "2009 Boulevard Marie",
                "514-765-9006",
                "mariaGooomez96@hotmail.com",
                "HelloPassportNumHere",
                LocalDate.of(2029, 1, 16),
                "4390 8901 6783 5352",
                2,
                flight2);

        Passenger passenger2 = new Passenger(
                "Jack", "Compos",
                LocalDate.of(1989, 5, 19),
                "Male",
                "2201 St-Laurent Marie",
                "514-192-1209",
                "JackC@gmail.com",
                "HelloPassportNumHere",
                LocalDate.of(2027, 12, 29),
                "1299 1289 2490 1274",
                1,
                flight2);

//
        passengerRepository.saveAll(Arrays.asList(passenger1, passenger2));
        System.out.println("Number of flights in DB: " + flightsRepository.count());
        logger.info("Flights count: {}", flightsRepository.count());

    }
}

