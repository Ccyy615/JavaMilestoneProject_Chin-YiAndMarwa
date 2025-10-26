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
import java.util.Locale;

@SpringBootApplication
public class MilestoneProjectApplication implements CommandLineRunner {

    private static final Logger logger= LoggerFactory.getLogger(MilestoneProjectApplication.class);
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
                LocalDateTime.of(2025, 11, 1, 20, 0),
                LocalDateTime.of(2025, 11, 2, 8, 0),
                1200.0);

        Flights flight2 = new Flights("Alitalia", "Montreal, Canada", "Milan, Italy",
                LocalDate.of(2025, 11, 3),
                LocalDate.of(2025, 11, 4),
                LocalDateTime.of(2025, 11, 3, 19, 0),
                LocalDateTime.of(2025, 11, 4, 7, 0),
                1150.0);

        Flights flight3 = new Flights("Lufthansa", "Montreal, Canada", "Berlin, Germany",
                LocalDate.of(2025, 11, 5),
                LocalDate.of(2025, 11, 6),
                LocalDateTime.of(2025, 11, 5, 18, 30),
                LocalDateTime.of(2025, 11, 6, 6, 30),
                1100.0);

        Flights flight4 = new Flights("Air Canada", "Montreal, Canada", "Toronto, Canada",
                LocalDate.of(2025, 11, 7),
                LocalDate.of(2025, 11, 7),
                LocalDateTime.of(2025, 11, 7, 9, 0),
                LocalDateTime.of(2025, 11, 7, 10, 30),
                250.0);

        Flights flight5 = new Flights("Japan Airlines", "Montreal, Canada", "Tokyo, Japan",
                LocalDate.of(2025, 11, 8),
                LocalDate.of(2025, 11, 9),
                LocalDateTime.of(2025, 11, 8, 21, 0),
                LocalDateTime.of(2025, 11, 9, 12, 0),
                1500.0);

        Flights flight6 = new Flights("Eva Air", "Montreal, Canada", "Taipei, Taiwan",
                LocalDate.of(2025, 11, 10),
                LocalDate.of(2025, 11, 11),
                LocalDateTime.of(2025, 11, 10, 22, 0),
                LocalDateTime.of(2025, 11, 11, 14, 0),
                1400.0);

        Flights flight7 = new Flights("Air Algérie", "Montreal, Canada", "Oran, Algeria",
                LocalDate.of(2025, 11, 12),
                LocalDate.of(2025, 11, 13),
                LocalDateTime.of(2025, 11, 12, 20, 0),
                LocalDateTime.of(2025, 11, 13, 8, 0),
                1000.0);

        Flights flight8 = new Flights("Tunisair", "Montreal, Canada", "Tunis, Tunisia",
                LocalDate.of(2025, 11, 14),
                LocalDate.of(2025, 11, 15),
                LocalDateTime.of(2025, 11, 14, 20, 30),
                LocalDateTime.of(2025, 11, 15, 10, 0),
                1100.0);

        Flights flight9 = new Flights("Caribbean Airlines", "Montreal, Canada", "Bridgetown, Barbados",
                LocalDate.of(2025, 11, 16),
                LocalDate.of(2025, 11, 16),
                LocalDateTime.of(2025, 11, 16, 8, 0),
                LocalDateTime.of(2025, 11, 16, 12, 0),
                800.0);

        Flights flight10 = new Flights("American Airlines", "Montreal, Canada", "Florida, United-States",
                LocalDate.of(2025, 11, 17),
                LocalDate.of(2025, 11, 17),
                LocalDateTime.of(2025, 11, 17, 9, 0),
                LocalDateTime.of(2025, 11, 17, 12, 0),
                500.0);

        Flights flight11 = new Flights("Delta Airlines", "Montreal, Canada", "Los Angeles, United-States",
                LocalDate.of(2025, 11, 18),
                LocalDate.of(2025, 11, 18),
                LocalDateTime.of(2025, 11, 18, 10, 0),
                LocalDateTime.of(2025, 11, 18, 14, 0),
                700.0);

        Flights flight12 = new Flights("United Airlines", "Montreal, Canada", "New York, United-States",
                LocalDate.of(2025, 11, 19),
                LocalDate.of(2025, 11, 19),
                LocalDateTime.of(2025, 11, 19, 7, 30),
                LocalDateTime.of(2025, 11, 19, 9, 0),
                300.0);

        Flights flight13 = new Flights("Iberia", "Montreal, Canada", "Madrid, Spain",
                LocalDate.of(2025, 11, 20),
                LocalDate.of(2025, 11, 21),
                LocalDateTime.of(2025, 11, 20, 19, 0),
                LocalDateTime.of(2025, 11, 21, 9, 0),
                1250.0);

        Flights flight14 = new Flights("TAP Air Portugal", "Montreal, Canada", "Lisbon, Portugal",
                LocalDate.of(2025, 11, 22),
                LocalDate.of(2025, 11, 23),
                LocalDateTime.of(2025, 11, 22, 20, 0),
                LocalDateTime.of(2025, 11, 23, 8, 0),
                1300.0);

        Flights flight15 = new Flights("Korean Air", "Montreal, Canada", "Seoul, Korea",
                LocalDate.of(2025, 11, 24),
                LocalDate.of(2025, 11, 25),
                LocalDateTime.of(2025, 11, 24, 22, 0),
                LocalDateTime.of(2025, 11, 25, 13, 0),
                1500.0);

        Flights flight16 = new Flights("Emirates", "Montreal, Canada", "Malé, Maldives",
                LocalDate.of(2025, 11, 26),
                LocalDate.of(2025, 11, 27),
                LocalDateTime.of(2025, 11, 26, 21, 0),
                LocalDateTime.of(2025, 11, 27, 10, 0),
                1800.0);

        Flights flight17 = new Flights("Qantas", "Montreal, Canada", "Sydney, Australia",
                LocalDate.of(2025, 11, 28),
                LocalDate.of(2025, 11, 29),
                LocalDateTime.of(2025, 11, 28, 20, 0),
                LocalDateTime.of(2025, 11, 29, 8, 0),
                2000.0);


        Passenger passenger1= new Passenger("Maria","Gomez",
                LocalDate.of(1996, 10, 9),"Female",
                "2009 Boulevard Marie","514-765-9006"
                ,"mariaGooomez96@hotmail.com","HelloPasseportNumHere",
                LocalDate.of(2029,1,16),"4390 8901 6783 5352",2,flight2);



    }
}
