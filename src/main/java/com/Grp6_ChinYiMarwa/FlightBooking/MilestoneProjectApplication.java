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
import java.util.List;

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
                "James", "Wilson",
                LocalDate.of(1988, 3, 15),
                "Male",
                "1542 Rue Saint-Denis, Montreal, QC",
                "438-922-3344",
                "james.wilson@email.com",
                "CA1234567",
                LocalDate.of(2027, 8, 22),
                "5274 8192 7364 9821",
                1,
                flight1
        );

        Passenger passenger3 = new Passenger(
                "Sophie", "Chen",
                LocalDate.of(1992, 7, 28),
                "Female",
                "892 Avenue du Parc, Montreal, QC",
                "514-233-4455",
                "sophie.chen@outlook.com",
                "CA8899123",
                LocalDate.of(2030, 5, 14),
                "3712 4598 7654 3210",
                3,
                flight4
        );

        Passenger passenger4 = new Passenger(
                "Ahmed", "Al-Farsi",
                LocalDate.of(1985, 11, 3),
                "Male",
                "345 Rue Sherbrooke Ouest, Montreal, QC",
                "438-556-7788",
                "ahmed.alfarsi@gmail.com",
                "CA5544678",
                LocalDate.of(2028, 12, 3),
                "4532 8765 4321 9876",
                2,
                flight3
        );

        Passenger passenger5 = new Passenger(
                "Isabella", "Rossi",
                LocalDate.of(1990, 12, 22),
                "Female",
                "678 Boulevard Decarie, Montreal, QC",
                "514-667-8899",
                "bella.rossi@email.com",
                "CA7722334",
                LocalDate.of(2029, 9, 30),
                "5423 9876 5432 1098",
                1,
                flight5
        );

        Passenger passenger6 = new Passenger(
                "Liam", "O'Connor",
                LocalDate.of(1978, 4, 17),
                "Male",
                "1234 Rue University, Montreal, QC",
                "438-778-9900",
                "liam.oconnor@company.com",
                "CA9911223",
                LocalDate.of(2027, 6, 18),
                "4916 2345 6789 0123",
                0,
                flight7
        );

        Passenger passenger7 = new Passenger(
                "Yuki", "Tanaka",
                LocalDate.of(1994, 9, 8),
                "Female",
                "567 Avenue des Pins, Montreal, QC",
                "514-889-0011",
                "yuki.tanaka@email.com",
                "CA8833445",
                LocalDate.of(2031, 3, 25),
                "4556 7890 1234 5678",
                2,
                flight9
        );

        Passenger passenger8 = new Passenger(
                "Carlos", "Silva",
                LocalDate.of(1982, 1, 30),
                "Male",
                "890 Rue Saint-Laurent, Montreal, QC",
                "438-990-1122",
                "carlos.silva@email.com",
                "CA6677889",
                LocalDate.of(2028, 7, 12),
                "4024 0071 0900 0000",
                1,
                flight8
        );



        passengerRepository.saveAll(Arrays.asList(passenger1,passenger2,passenger3,passenger4,passenger5,passenger6,passenger7,passenger8));

        System.out.println("Number of flights in DB: " + flightsRepository.count());
        logger.info("Flights count: {}", flightsRepository.count());

    }
}

