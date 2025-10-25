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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Locale;

@SpringBootApplication
public class MilestoneProjectApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MilestoneProjectApplication.class);
    private FlightsRepository flightsRepository;
    private PassengerRepository passengerRepository;

    public static void main(String[] args) {
        SpringApplication.run(MilestoneProjectApplication.class, args);

        logger.info("Flight Booking Application has started");
    }

    public MilestoneProjectApplication(FlightsRepository flightsRepository, PassengerRepository passengerRepository) {
        this.flightsRepository = flightsRepository;
        this.passengerRepository = passengerRepository;
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

        Flights flight4 = new Flights("Air Canada", "Montreal, Canada", "Toronto, Canada",
                LocalDate.of(2025, 11, 7),
                LocalDate.of(2025, 11, 7),
                LocalTime.of(9, 0),
                LocalTime.of(10, 30),
                250.0);

        Flights flight5 = new Flights("Japan Airlines", "Montreal, Canada", "Tokyo, Japan",
                LocalDate.of(2025, 11, 8),
                LocalDate.of(2025, 11, 9),
                LocalTime.of(21, 0),
                LocalTime.of(12, 0),
                1500.0);

        Flights flight6 = new Flights("Eva Air", "Montreal, Canada", "Taipei, Taiwan",
                LocalDate.of(2025, 11, 10),
                LocalDate.of(2025, 11, 11),
                LocalTime.of(22, 0),
                LocalTime.of(14, 0),
                1400.0);

        Flights flight7 = new Flights("Air Algérie", "Montreal, Canada", "Oran, Algeria",
                LocalDate.of(2025, 11, 12),
                LocalDate.of(2025, 11, 13),
                LocalTime.of(20, 0),
                LocalTime.of(8, 0),
                1000.0);

        Flights flight8 = new Flights("Tunisair", "Montreal, Canada", "Tunis, Tunisia",
                LocalDate.of(2025, 11, 14),
                LocalDate.of(2025, 11, 15),
                LocalTime.of(20, 30),
                LocalTime.of(10, 0),
                1100.0);

        Flights flight9 = new Flights("Caribbean Airlines", "Montreal, Canada", "Bridgetown, Barbados",
                LocalDate.of(2025, 11, 16),
                LocalDate.of(2025, 11, 16),
                LocalTime.of(8, 0),         // departTime (8:00 AM)
                LocalTime.of(12, 0),
                800.0);

        Flights flight10 = new Flights("American Airlines", "Montreal, Canada", "Florida, United-States",
                LocalDate.of(2025, 11, 17),
                LocalDate.of(2025, 11, 17),
                LocalTime.of(9, 0),
                LocalTime.of(12, 0),
                500.0);

        Flights flight11 = new Flights("Delta Airlines", "Montreal, Canada", "Los Angeles, United-States",
                LocalDate.of(2025, 11, 18),
                LocalDate.of(2025, 11, 18),
                LocalTime.of(10, 0),
                LocalTime.of(14, 0),
                700.0);

        Flights flight12 = new Flights("United Airlines", "Montreal, Canada", "New York, United-States",
                LocalDate.of(2025, 11, 19),
                LocalDate.of(2025, 11, 19),
                LocalTime.of(7, 30),
                LocalTime.of(9, 0),
                300.0);

        Flights flight13 = new Flights("Iberia", "Montreal, Canada", "Madrid, Spain",
                LocalDate.of(2025, 11, 20),
                LocalDate.of(2025, 11, 21),
                LocalTime.of(19, 0),
                LocalTime.of(9, 0),
                1250.0);

        Flights flight14 = new Flights("TAP Air Portugal", "Montreal, Canada", "Lisbon, Portugal",
                LocalDate.of(2025, 11, 22),
                LocalDate.of(2025, 11, 23),
                LocalTime.of(20, 0),
                LocalTime.of(8, 0),
                1300.0);

        Flights flight15 = new Flights("Korean Air", "Montreal, Canada", "Seoul, Korea",
                LocalDate.of(2025, 11, 24),
                LocalDate.of(2025, 11, 25),
                LocalTime.of(22, 0),
                LocalTime.of(13, 0),
                1500.0);

        Flights flight16 = new Flights("Emirates", "Montreal, Canada", "Malé, Maldives",
                LocalDate.of(2025, 11, 26),
                LocalDate.of(2025, 11, 27),
                LocalTime.of(21, 0),
                LocalTime.of(10, 0),
                1800.0);

        Flights flight17= new Flights("Qantas", "Montreal, Canada", "Sydney, Australia",
                LocalDate.of(2025, 11, 28),
                LocalDate.of(2025, 11, 29),
                LocalTime.of(20, 0),
                LocalTime.of(8, 0),
                2000.0);

        this.flightsRepository.saveAll(Arrays.asList(flight1,flight2,flight3,flight4,flight5,
                flight6,flight7,flight8,flight9,flight10,
                flight11,flight12,flight13,flight14,flight15,flight16,flight17));


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


        passengerRepository.save(passenger1);


        }
    }

