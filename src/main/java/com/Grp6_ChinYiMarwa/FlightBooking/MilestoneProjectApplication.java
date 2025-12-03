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


    private final FlightsRepository flightsRepository;
    private final PassengerRepository passengerRepository;

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
                1200.0,"INT-FLT-001A");

        Flights flight2 = new Flights("Alitalia", "Montreal, Canada", "Milan, Italy",
                LocalDate.of(2025, 11, 3),
                LocalDate.of(2025, 11, 4),
                LocalTime.of(19, 0),
                LocalTime.of(7, 0),
                1150.0,"INT-FLT-002B");

        Flights flight3 = new Flights("Lufthansa", "Montreal, Canada", "Berlin, Germany",
                LocalDate.of(2025, 11, 5),
                LocalDate.of(2025, 11, 6),
                LocalTime.of(18, 30),
                LocalTime.of(6, 30),
                1100.0,"INT-FLT-003C");

        Flights flight4= new Flights("Japan Airlines", "Montreal, Canada", "Tokyo, Japan",
                LocalDate.of(2025, 11, 8),
                LocalDate.of(2025, 11, 9),
                LocalTime.of(21, 0),
                LocalTime.of(12, 0),
                1500.0,"INT-FLT-004D");

        Flights flight5 = new Flights("Eva Air", "Montreal, Canada", "Taipei, Taiwan",
                LocalDate.of(2025, 11, 10),
                LocalDate.of(2025, 11, 11),
                LocalTime.of(22, 0),
                LocalTime.of(14, 0),
                1400.0,"INT-FLT-005E");

        Flights flight6 = new Flights("Air Algérie", "Montreal, Canada", "Oran, Algeria",
                LocalDate.of(2025, 11, 12),
                LocalDate.of(2025, 11, 13),
                LocalTime.of(20, 0),
                LocalTime.of(8, 0),
                1000.0,"INT-FLT-006F");


        Flights flight7 = new Flights("United Airlines", "Montreal, Canada", "New York, United-States",
                LocalDate.of(2025, 11, 19),
                LocalDate.of(2025, 11, 19),
                LocalTime.of(7, 30),
                LocalTime.of(9, 0),
                300.0,"INT-FLT-007G");

        Flights flight8 = new Flights("Iberia", "Montreal, Canada", "Madrid, Spain",
                LocalDate.of(2025, 11, 20),
                LocalDate.of(2025, 11, 21),
                LocalTime.of(19, 0),
                LocalTime.of(9, 0),
                1250.0,"INT-FLT-008H");


        Flights flight9 = new Flights("Korean Air", "Montreal, Canada", "Seoul, Korea",
                LocalDate.of(2025, 11, 24),
                LocalDate.of(2025, 11, 25),
                LocalTime.of(22, 0),
                LocalTime.of(13, 0),
                1500.0,"INT-FLT-009I");

        Flights flight10 = new Flights("Emirates", "Montreal, Canada", "Malé, Maldives",
                LocalDate.of(2025, 11, 26),
                LocalDate.of(2025, 11, 27),
                LocalTime.of(21, 0),
                LocalTime.of(10, 0),
                1800.0,"INT-FLT-010J");
        Flights flight11 = new Flights("Air Canada", "Toronto, Canada", "London, UK",
                LocalDate.of(2025, 12, 5),
                LocalDate.of(2025, 12, 6),
                LocalTime.of(22, 30),
                LocalTime.of(10, 15),
                980.0, "INT-FLT-011A");

        Flights flight12 = new Flights("British Airways", "London, UK", "New York, USA",
                LocalDate.of(2025, 10, 12),
                LocalDate.of(2025, 10, 12),
                LocalTime.of(14, 45),
                LocalTime.of(18, 20),
                760.0, "INT-FLT-012B");

        Flights flight13 = new Flights("Lufthansa", "Frankfurt, Germany", "Tokyo, Japan",
                LocalDate.of(2025, 9, 20),
                LocalDate.of(2025, 9, 21),
                LocalTime.of(12, 0),
                LocalTime.of(6, 55),
                1450.0, "INT-FLT-013C");

        Flights flight14 = new Flights("Emirates", "Dubai, UAE", "Sydney, Australia",
                LocalDate.of(2025, 8, 15),
                LocalDate.of(2025, 8, 16),
                LocalTime.of(3, 10),
                LocalTime.of(23, 5),
                1700.0, "INT-FLT-014D");

        Flights flight15 = new Flights("Qatar Airways", "Doha, Qatar", "Johannesburg, South Africa",
                LocalDate.of(2025, 7, 22),
                LocalDate.of(2025, 7, 22),
                LocalTime.of(8, 50),
                LocalTime.of(16, 30),
                980.0, "INT-FLT-015E");

        Flights flight16 = new Flights("Turkish Airlines", "Istanbul, Türkiye", "Toronto, Canada",
                LocalDate.of(2025, 6, 10),
                LocalDate.of(2025, 6, 10),
                LocalTime.of(9, 15),
                LocalTime.of(14, 40),
                890.0, "INT-FLT-016F");

        Flights flight17 = new Flights("KLM", "Amsterdam, Netherlands", "Los Angeles, USA",
                LocalDate.of(2025, 5, 18),
                LocalDate.of(2025, 5, 18),
                LocalTime.of(11, 0),
                LocalTime.of(14, 30),
                1025.0, "INT-FLT-017G");

        Flights flight18 = new Flights("Delta Airlines", "New York, USA", "Madrid, Spain",
                LocalDate.of(2025, 4, 25),
                LocalDate.of(2025, 4, 26),
                LocalTime.of(19, 10),
                LocalTime.of(7, 45),
                850.0, "INT-FLT-018H");

        Flights flight19 = new Flights("American Airlines", "Chicago, USA", "Rome, Italy",
                LocalDate.of(2025, 3, 14),
                LocalDate.of(2025, 3, 15),
                LocalTime.of(17, 40),
                LocalTime.of(9, 20),
                920.0, "INT-FLT-019I");

        Flights flight20 = new Flights("United Airlines", "San Francisco, USA", "Hong Kong, China",
                LocalDate.of(2025, 2, 9),
                LocalDate.of(2025, 2, 10),
                LocalTime.of(21, 0),
                LocalTime.of(7, 35),
                1380.0, "INT-FLT-020J");

        Flights flight21 = new Flights("Swiss Air", "Zurich, Switzerland", "Dubai, UAE",
                LocalDate.of(2025, 1, 26),
                LocalDate.of(2025, 1, 26),
                LocalTime.of(13, 25),
                LocalTime.of(22, 50),
                1100.0, "INT-FLT-021K");

        Flights flight22 = new Flights("Japan Airlines", "Tokyo, Japan", "Vancouver, Canada",
                LocalDate.of(2025, 11, 10),
                LocalDate.of(2025, 11, 10),
                LocalTime.of(9, 0),
                LocalTime.of(2, 40),
                1220.0, "INT-FLT-022L");

        Flights flight23 = new Flights("Korean Air", "Seoul, South Korea", "Singapore",
                LocalDate.of(2025, 10, 8),
                LocalDate.of(2025, 10, 8),
                LocalTime.of(6, 20),
                LocalTime.of(10, 50),
                600.0, "INT-FLT-023M");

        Flights flight24 = new Flights("Singapore Airlines", "Singapore", "Paris, France",
                LocalDate.of(2025, 9, 5),
                LocalDate.of(2025, 9, 6),
                LocalTime.of(23, 55),
                LocalTime.of(7, 40),
                1250.0, "INT-FLT-024N");

        Flights flight25 = new Flights("Iberia", "Madrid, Spain", "Buenos Aires, Argentina",
                LocalDate.of(2025, 8, 12),
                LocalDate.of(2025, 8, 13),
                LocalTime.of(0, 15),
                LocalTime.of(8, 45),
                1150.0, "INT-FLT-025O");

        Flights flight26 = new Flights("Air France", "Paris, France", "Dubai, UAE",
                LocalDate.of(2025, 7, 1),
                LocalDate.of(2025, 7, 1),
                LocalTime.of(10, 0),
                LocalTime.of(19, 20),
                980.0, "INT-FLT-026P");

        Flights flight27 = new Flights("Qantas", "Sydney, Australia", "San Francisco, USA",
                LocalDate.of(2025, 6, 19),
                LocalDate.of(2025, 6, 19),
                LocalTime.of(9, 45),
                LocalTime.of(6, 30),
                1450.0, "INT-FLT-027Q");

        Flights flight28 = new Flights("Etihad Airways", "Abu Dhabi, UAE", "Tokyo, Japan",
                LocalDate.of(2025, 5, 27),
                LocalDate.of(2025, 5, 28),
                LocalTime.of(2, 30),
                LocalTime.of(17, 50),
                1300.0, "INT-FLT-028R");

        Flights flight29 = new Flights("Hawaiian Airlines", "Honolulu, USA", "Seoul, South Korea",
                LocalDate.of(2025, 4, 14),
                LocalDate.of(2025, 4, 15),
                LocalTime.of(12, 0),
                LocalTime.of(17, 20),
                980.0, "INT-FLT-029S");

        Flights flight30 = new Flights("Finnair", "Helsinki, Finland", "Bangkok, Thailand",
                LocalDate.of(2025, 3, 22),
                LocalDate.of(2025, 3, 23),
                LocalTime.of(18, 25),
                LocalTime.of(7, 55),
                1050.0, "INT-FLT-030T");

        Flights flight31 = new Flights("Austrian Airlines", "Vienna, Austria", "Toronto, Canada",
                LocalDate.of(2025, 2, 16),
                LocalDate.of(2025, 2, 16),
                LocalTime.of(11, 10),
                LocalTime.of(15, 45),
                940.0, "INT-FLT-031U");

        Flights flight32 = new Flights("Scandinavian Airlines", "Stockholm, Sweden", "Chicago, USA",
                LocalDate.of(2025, 1, 30),
                LocalDate.of(2025, 1, 30),
                LocalTime.of(14, 55),
                LocalTime.of(18, 35),
                880.0, "INT-FLT-032V");

        Flights flight33 = new Flights("Aer Lingus", "Dublin, Ireland", "Boston, USA",
                LocalDate.of(2025, 11, 3),
                LocalDate.of(2025, 11, 3),
                LocalTime.of(16, 40),
                LocalTime.of(19, 25),
                620.0, "INT-FLT-033W");

        Flights flight34 = new Flights("Alitalia", "Rome, Italy", "Buenos Aires, Argentina",
                LocalDate.of(2025, 10, 17),
                LocalDate.of(2025, 10, 18),
                LocalTime.of(22, 20),
                LocalTime.of(8, 55),
                1250.0, "INT-FLT-034X");

        Flights flight35 = new Flights("Tap Air Portugal", "Lisbon, Portugal", "Newark, USA",
                LocalDate.of(2025, 9, 25),
                LocalDate.of(2025, 9, 25),
                LocalTime.of(12, 10),
                LocalTime.of(16, 35),
                740.0, "INT-FLT-035Y");

        Flights flight36 = new Flights("Air India", "Delhi, India", "Toronto, Canada",
                LocalDate.of(2025, 8, 6),
                LocalDate.of(2025, 8, 6),
                LocalTime.of(2, 25),
                LocalTime.of(7, 55),
                1120.0, "INT-FLT-036Z");

        Flights flight37 = new Flights("Air China", "Beijing, China", "Paris, France",
                LocalDate.of(2025, 7, 12),
                LocalDate.of(2025, 7, 12),
                LocalTime.of(8, 15),
                LocalTime.of(15, 10),
                1190.0, "INT-FLT-037A");

        Flights flight38 = new Flights("China Eastern", "Shanghai, China", "Los Angeles, USA",
                LocalDate.of(2025, 6, 3),
                LocalDate.of(2025, 6, 3),
                LocalTime.of(15, 0),
                LocalTime.of(9, 45),
                1080.0, "INT-FLT-038B");

        Flights flight39 = new Flights("Cathay Pacific", "Hong Kong, China", "Vancouver, Canada",
                LocalDate.of(2025, 5, 14),
                LocalDate.of(2025, 5, 14),
                LocalTime.of(23, 55),
                LocalTime.of(18, 35),
                990.0, "INT-FLT-039C");

        Flights flight40 = new Flights("EVA Air", "Taipei, Taiwan", "Seattle, USA",
                LocalDate.of(2025, 4, 27),
                LocalDate.of(2025, 4, 27),
                LocalTime.of(12, 20),
                LocalTime.of(7, 0),
                1000.0, "INT-FLT-040D");

        Flights flight41 = new Flights("Saudi Airlines", "Riyadh, Saudi Arabia", "Paris, France",
                LocalDate.of(2025, 3, 3),
                LocalDate.of(2025, 3, 3),
                LocalTime.of(4, 15),
                LocalTime.of(11, 40),
                980.0, "INT-FLT-041E");

        Flights flight42 = new Flights("Vietnam Airlines", "Hanoi, Vietnam", "Tokyo, Japan",
                LocalDate.of(2025, 2, 22),
                LocalDate.of(2025, 2, 22),
                LocalTime.of(9, 30),
                LocalTime.of(15, 0),
                460.0, "INT-FLT-042F");

        Flights flight43 = new Flights("Philippine Airlines", "Manila, Philippines", "Sydney, Australia",
                LocalDate.of(2025, 1, 12),
                LocalDate.of(2025, 1, 12),
                LocalTime.of(7, 45),
                LocalTime.of(18, 55),
                720.0, "INT-FLT-043G");

        Flights flight44 = new Flights("Garuda Indonesia", "Jakarta, Indonesia", "Amsterdam, Netherlands",
                LocalDate.of(2025, 11, 28),
                LocalDate.of(2025, 11, 28),
                LocalTime.of(20, 10),
                LocalTime.of(5, 30),
                1300.0, "INT-FLT-044H");

        Flights flight45 = new Flights("Kenya Airways", "Nairobi, Kenya", "Dubai, UAE",
                LocalDate.of(2025, 10, 14),
                LocalDate.of(2025, 10, 14),
                LocalTime.of(6, 0),
                LocalTime.of(11, 25),
                580.0, "INT-FLT-045I");

        Flights flight46 = new Flights("EgyptAir", "Cairo, Egypt", "Montreal, Canada",
                LocalDate.of(2025, 9, 3),
                LocalDate.of(2025, 9, 3),
                LocalTime.of(10, 15),
                LocalTime.of(16, 50),
                1020.0, "INT-FLT-046J");

        Flights flight47 = new Flights("Royal Air Maroc", "Casablanca, Morocco", "New York, USA",
                LocalDate.of(2025, 8, 21),
                LocalDate.of(2025, 8, 21),
                LocalTime.of(7, 0),
                LocalTime.of(11, 20),
                770.0, "INT-FLT-047K");

        Flights flight48 = new Flights("LATAM", "Santiago, Chile", "Madrid, Spain",
                LocalDate.of(2025, 7, 29),
                LocalDate.of(2025, 7, 30),
                LocalTime.of(23, 50),
                LocalTime.of(17, 35),
                1200.0, "INT-FLT-048L");

        Flights flight49 = new Flights("AeroMexico", "Mexico City, Mexico", "Paris, France",
                LocalDate.of(2025, 6, 11),
                LocalDate.of(2025, 6, 12),
                LocalTime.of(18, 20),
                LocalTime.of(13, 5),
                980.0, "INT-FLT-049M");

        Flights flight50 = new Flights("Copa Airlines", "Panama City, Panama", "Los Angeles, USA",
                LocalDate.of(2025, 5, 6),
                LocalDate.of(2025, 5, 6),
                LocalTime.of(8, 30),
                LocalTime.of(13, 20),
                540.0, "INT-FLT-050N");

        Flights flight51 = new Flights("JetBlue", "Boston, USA", "San Juan, Puerto Rico",
                LocalDate.of(2025, 4, 20),
                LocalDate.of(2025, 4, 20),
                LocalTime.of(6, 15),
                LocalTime.of(9, 55),
                320.0, "INT-FLT-051O");

        Flights flight52 = new Flights("Virgin Atlantic", "London, UK", "Johannesburg, South Africa",
                LocalDate.of(2025, 3, 8),
                LocalDate.of(2025, 3, 9),
                LocalTime.of(22, 0),
                LocalTime.of(9, 45),
                1380.0, "INT-FLT-052P");

        Flights flight53 = new Flights("Air New Zealand", "Auckland, New Zealand", "Vancouver, Canada",
                LocalDate.of(2025, 2, 4),
                LocalDate.of(2025, 2, 4),
                LocalTime.of(10, 0),
                LocalTime.of(5, 50),
                1550.0, "INT-FLT-053Q");

        Flights flight54 = new Flights("Brussels Airlines", "Brussels, Belgium", "Montreal, Canada",
                LocalDate.of(2025, 1, 29),
                LocalDate.of(2025, 1, 29),
                LocalTime.of(13, 45),
                LocalTime.of(16, 15),
                780.0, "INT-FLT-054R");

        Flights flight55 = new Flights("Aegean Airlines", "Athens, Greece", "Paris, France",
                LocalDate.of(2025, 11, 19),
                LocalDate.of(2025, 11, 19),
                LocalTime.of(9, 10),
                LocalTime.of(12, 0),
                350.0, "INT-FLT-055S");

        Flights flight56 = new Flights("El Al", "Tel Aviv, Israel", "New York, USA",
                LocalDate.of(2025, 10, 2),
                LocalDate.of(2025, 10, 2),
                LocalTime.of(1, 0),
                LocalTime.of(6, 45),
                1100.0, "INT-FLT-056T");

        Flights flight57 = new Flights("Norwegian Air", "Oslo, Norway", "Bangkok, Thailand",
                LocalDate.of(2025, 9, 11),
                LocalDate.of(2025, 9, 12),
                LocalTime.of(22, 10),
                LocalTime.of(14, 25),
                690.0, "INT-FLT-057U");

        Flights flight58 = new Flights("Icelandair", "Reykjavik, Iceland", "Boston, USA",
                LocalDate.of(2025, 8, 4),
                LocalDate.of(2025, 8, 4),
                LocalTime.of(17, 50),
                LocalTime.of(19, 25),
                480.0, "INT-FLT-058V");

        Flights flight59 = new Flights("Turkmenistan Airlines", "Ashgabat, Turkmenistan", "Istanbul, Türkiye",
                LocalDate.of(2025, 7, 15),
                LocalDate.of(2025, 7, 15),
                LocalTime.of(9, 0),
                LocalTime.of(11, 30),
                350.0, "INT-FLT-059W");

        Flights flight60 = new Flights("Malaysian Airlines", "Kuala Lumpur, Malaysia", "Tokyo, Japan",
                LocalDate.of(2025, 6, 23),
                LocalDate.of(2025, 6, 23),
                LocalTime.of(7, 20),
                LocalTime.of(14, 40),
                720.0, "INT-FLT-060X");




        this.flightsRepository.saveAll(Arrays.asList(
                flight1, flight2, flight3, flight4, flight5,
                flight6, flight7, flight8, flight9, flight10,
                flight11, flight12, flight13, flight14, flight15,
                flight16, flight17, flight18, flight19, flight20,
                flight21, flight22, flight23, flight24, flight25,
                flight26, flight27, flight28, flight29, flight30,
                flight31, flight32, flight33, flight34, flight35,
                flight36, flight37, flight38, flight39, flight40,
                flight41, flight42, flight43, flight44, flight45,
                flight46, flight47, flight48, flight49, flight50,
                flight51, flight52, flight53, flight54, flight55,
                flight56, flight57, flight58, flight59, flight60
        ));



        Passenger passenger1 = new Passenger(
                "Maria", "Gomez",
                LocalDate.of(1996, 10, 9),
                "Female",
                "2009 Boulevard Marie",
                "514-765-9006",
                "mariaGooomez96@hotmail.com",
                "CA2134542",
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

        Passenger passenger9 = new Passenger(
                "Myriam", "Silva",
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

        Passenger passenger10 = new Passenger(
                "Lina", "Karam",
                LocalDate.of(1990, 5, 14),
                "Female",
                "2210 Rue Sherbrooke O, Montreal, QC",
                "438-502-7788",
                "lina.karam@email.com",
                "CA7788990",
                LocalDate.of(2029, 3, 22),
                "4024 0091 5600 1010",
                1,
                flight9
        );

        Passenger passenger11 = new Passenger(
                "Ethan", "Dubois",
                LocalDate.of(1988, 9, 3),
                "Male",
                "153 Rue Crescent, Montreal, QC",
                "514-765-4432",
                "ethan.dubois@email.com",
                "CA4455667",
                LocalDate.of(2027, 11, 5),
                "4024 0023 8900 3333",
                2,
                flight10
        );

        Passenger passenger12 = new Passenger(
                "Amira", "Nguyen",
                LocalDate.of(1995, 12, 25),
                "Female",
                "6400 Boul. Décarie, Montreal, QC",
                "514-998-7700",
                "amira.nguyen@email.com",
                "CA9988776",
                LocalDate.of(2028, 6, 18),
                "4024 0044 2211 5555",
                3,
                flight10
        );
        Passenger passenger13 = new Passenger(
                "Karim", "ElMansour",
                LocalDate.of(1993, 5, 11),
                "Male",
                "2200 Rue Sherbrooke E, Montreal, QC",
                "514-885-2211",
                "karim.elmansour@email.com",
                "CA1122334",
                LocalDate.of(2029, 4, 22),
                "4024 1133 5522 7788",
                5,
                flight11
        );

        Passenger passenger14 = new Passenger(
                "Sofia", "Moretti",
                LocalDate.of(1998, 9, 3),
                "Female",
                "4100 Av. du Parc, Montreal, QC",
                "514-901-4322",
                "sofia.moretti@email.com",
                "IT5533221",
                LocalDate.of(2027, 12, 9),
                "4024 3300 1199 5500",
                8,
                flight12
        );

        Passenger passenger15 = new Passenger(
                "James", "Wilson",
                LocalDate.of(1987, 2, 14),
                "Male",
                "37 King Street W, Toronto, ON",
                "416-877-5544",
                "james.wilson@email.com",
                "US8877994",
                LocalDate.of(2030, 3, 17),
                "4532 1144 7788 9922",
                10,
                flight13
        );

        Passenger passenger16 = new Passenger(
                "Layla", "Hussein",
                LocalDate.of(1994, 8, 30),
                "Female",
                "900 Ste-Catherine O, Montreal, QC",
                "514-733-2288",
                "layla.hussein@email.com",
                "EG6622119",
                LocalDate.of(2028, 11, 4),
                "4024 9955 6611 2244",
                12,
                flight14
        );

        Passenger passenger17 = new Passenger(
                "Noah", "Thompson",
                LocalDate.of(1996, 1, 19),
                "Male",
                "88 Sparks Street, Ottawa, ON",
                "613-744-2200",
                "noah.thompson@email.com",
                "CA7788991",
                LocalDate.of(2027, 5, 8),
                "4024 5500 9988 1133",
                4,
                flight15
        );

        Passenger passenger18 = new Passenger(
                "Aisha", "Rahman",
                LocalDate.of(1995, 3, 25),
                "Female",
                "6000 Cote des Neiges, Montreal, QC",
                "514-667-2234",
                "aisha.rahman@email.com",
                "PK5544332",
                LocalDate.of(2030, 2, 19),
                "4532 2277 5511 0066",
                14,
                flight16
        );

        Passenger passenger19 = new Passenger(
                "Lucas", "Gauthier",
                LocalDate.of(1997, 4, 9),
                "Male",
                "200 Rue Saint-Antoine, Montreal, QC",
                "514-999-8800",
                "lucas.gauthier@email.com",
                "CA1133557",
                LocalDate.of(2029, 6, 27),
                "4024 2200 5577 4488",
                16,
                flight17
        );

        Passenger passenger20 = new Passenger(
                "Maya", "Fernandez",
                LocalDate.of(1999, 7, 1),
                "Female",
                "1250 Maisonneuve O, Montreal, QC",
                "514-700-9922",
                "maya.fernandez@email.com",
                "SP8822114",
                LocalDate.of(2028, 10, 30),
                "4488 9911 2233 7700",
                20,
                flight18
        );

        Passenger passenger21 = new Passenger(
                "Ethan", "Kim",
                LocalDate.of(1990, 6, 22),
                "Male",
                "300 Dundas Street W, Toronto, ON",
                "647-332-2200",
                "ethan.kim@email.com",
                "KR4455772",
                LocalDate.of(2027, 8, 12),
                "4024 6611 7788 0044",
                9,
                flight19
        );

        Passenger passenger22 = new Passenger(
                "Hannah", "Jordan",
                LocalDate.of(1996, 10, 8),
                "Female",
                "7400 Newman Blvd, Lasalle, QC",
                "514-889-7711",
                "hannah.jordan@email.com",
                "US5566771",
                LocalDate.of(2031, 1, 14),
                "4532 8822 9911 0044",
                13,
                flight19
        );

        Passenger passenger23 = new Passenger(
                "Ahmed", "Nasser",
                LocalDate.of(1989, 12, 2),
                "Male",
                "345 Côte-Vertu, Montreal, QC",
                "514-900-1122",
                "ahmed.nasser@email.com",
                "EG9988773",
                LocalDate.of(2029, 9, 17),
                "4024 5522 3311 7700",
                11,
                flight21
        );

        Passenger passenger24 = new Passenger(
                "Julia", "Bourgoin",
                LocalDate.of(1998, 5, 29),
                "Female",
                "18 Rue Rachel E, Montreal, QC",
                "514-812-4455",
                "julia.bourgoin@email.com",
                "CA6677881",
                LocalDate.of(2028, 4, 8),
                "4024 1133 2244 5588",
                6,
                flight22
        );

        Passenger passenger25 = new Passenger(
                "Samuel", "Davis",
                LocalDate.of(1993, 11, 7),
                "Male",
                "19 Wellington St, Toronto, ON",
                "416-221-9988",
                "samuel.davis@email.com",
                "US1122998",
                LocalDate.of(2030, 10, 20),
                "4532 9900 4411 8822",
                17,
                flight23
        );

        Passenger passenger26 = new Passenger(
                "Nora", "Khan",
                LocalDate.of(1994, 4, 18),
                "Female",
                "7150 St-Hubert, Montreal, QC",
                "514-330-7744",
                "nora.khan@email.com",
                "PK2377994",
                LocalDate.of(2027, 3, 3),
                "4024 6677 0011 8844",
                2,
                flight24
        );

        Passenger passenger27 = new Passenger(
                "Benjamin", "Roy",
                LocalDate.of(1992, 8, 10),
                "Male",
                "1150 Rene-Levesque O, Montreal, QC",
                "514-778-3009",
                "benjamin.roy@email.com",
                "CA7788996",
                LocalDate.of(2029, 12, 25),
                "4024 5577 2299 6633",
                21,
                flight25
        );

        Passenger passenger28 = new Passenger(
                "Clara", "Petit",
                LocalDate.of(1997, 1, 14),
                "Female",
                "22 Rue St-Denis, Montreal, QC",
                "514-944-7788",
                "clara.petit@email.com",
                "FR1122665",
                LocalDate.of(2030, 7, 19),
                "4488 3322 1199 7700",
                5,
                flight26
        );

        Passenger passenger29 = new Passenger(
                "Alex", "Gordon",
                LocalDate.of(1990, 9, 2),
                "Male",
                "88 Peel Street, Montreal, QC",
                "514-333-9911",
                "alex.gordon@email.com",
                "US9933112",
                LocalDate.of(2031, 2, 23),
                "4532 4411 7788 0055",
                14,
                flight27
        );

        Passenger passenger30 = new Passenger(
                "Leila", "Sadik",
                LocalDate.of(1995, 3, 27),
                "Female",
                "3000 Jean-Talon O, Montreal, QC",
                "514-922-4411",
                "leila.sadik@email.com",
                "MA4422117",
                LocalDate.of(2028, 6, 14),
                "4024 9900 5577 2211",
                8,
                flight28
        );
        Passenger passenger31 = new Passenger(
                "Yara", "Benali",
                LocalDate.of(1998, 2, 17),
                "Female",
                "7000 Boul. St-Laurent, Montreal, QC",
                "514-223-4411",
                "yara.benali@email.com",
                "MA6611223",
                LocalDate.of(2029, 8, 11),
                "4024 2222 3344 5566",
                6,
                flight29
        );

        Passenger passenger32 = new Passenger(
                "Jonathan", "White",
                LocalDate.of(1991, 9, 23),
                "Male",
                "122 Bank Street, Ottawa, ON",
                "613-772-8899",
                "jonathan.white@email.com",
                "US9900881",
                LocalDate.of(2028, 9, 3),
                "4488 5522 1100 3344",
                11,
                flight30
        );

        Passenger passenger33 = new Passenger(
                "Rania", "Saleh",
                LocalDate.of(1997, 5, 5),
                "Female",
                "2000 Boul. Henri-Bourassa, Montreal, QC",
                "514-303-7722",
                "rania.saleh@email.com",
                "EG2299112",
                LocalDate.of(2030, 3, 14),
                "4024 7788 0099 3322",
                4,
                flight31
        );

        Passenger passenger34 = new Passenger(
                "Marcus", "Dupont",
                LocalDate.of(1994, 4, 15),
                "Male",
                "445 Rue Ste-Catherine E, Montreal, QC",
                "514-998-5522",
                "marcus.dupont@email.com",
                "CA5522114",
                LocalDate.of(2029, 12, 28),
                "4532 1100 2233 4466",
                18,
                flight32
        );

        Passenger passenger35 = new Passenger(
                "Eva", "Morin",
                LocalDate.of(1998, 7, 19),
                "Female",
                "1110 Boul. Rosemont, Montreal, QC",
                "514-443-8822",
                "eva.morin@email.com",
                "CA3322009",
                LocalDate.of(2028, 11, 7),
                "4024 6611 3344 0099",
                2,
                flight33
        );

        Passenger passenger36 = new Passenger(
                "Olivier", "Tremblay",
                LocalDate.of(1993, 6, 11),
                "Male",
                "2225 Rue St-Zotique, Montreal, QC",
                "514-771-2233",
                "olivier.tremblay@email.com",
                "CA1998876",
                LocalDate.of(2031, 2, 18),
                "4024 5555 9900 2211",
                13,
                flight34
        );

        Passenger passenger37 = new Passenger(
                "Isabella", "Rossi",
                LocalDate.of(1996, 12, 9),
                "Female",
                "887 Rue Beaubien, Montreal, QC",
                "514-668-9922",
                "isabella.rossi@email.com",
                "IT8844332",
                LocalDate.of(2029, 4, 5),
                "4532 7788 1133 5599",
                9,
                flight35
        );

        Passenger passenger38 = new Passenger(
                "Victor", "Ng",
                LocalDate.of(1995, 3, 21),
                "Male",
                "64 Boul. Dorchester, Montreal, QC",
                "514-990-7733",
                "victor.ng@email.com",
                "CA5511003",
                LocalDate.of(2028, 12, 29),
                "4024 8866 4411 0022",
                7,
                flight36
        );

        Passenger passenger39 = new Passenger(
                "Chloe", "Martin",
                LocalDate.of(1999, 1, 30),
                "Female",
                "1000 Notre-Dame O, Montreal, QC",
                "514-700-3311",
                "chloe.martin@email.com",
                "FR6633221",
                LocalDate.of(2030, 8, 20),
                "4024 3311 5500 8822",
                3,
                flight37
        );

        Passenger passenger40 = new Passenger(
                "Gabriel", "Mendoza",
                LocalDate.of(1992, 10, 13),
                "Male",
                "44 Sherbrooke O, Montreal, QC",
                "514-744-2211",
                "gabriel.mendoza@email.com",
                "SP4422113",
                LocalDate.of(2028, 7, 14),
                "4488 9911 2200 4433",
                15,
                flight38
        );

        Passenger passenger41 = new Passenger(
                "Elsa", "Johansson",
                LocalDate.of(1997, 3, 9),
                "Female",
                "930 Rue Clark, Montreal, QC",
                "514-881-4422",
                "elsa.johansson@email.com",
                "SE9955331",
                LocalDate.of(2029, 6, 6),
                "4024 8844 2211 5599",
                1,
                flight39
        );

        Passenger passenger42 = new Passenger(
                "Henry", "Walker",
                LocalDate.of(1991, 9, 4),
                "Male",
                "78 Bayview Ave, Toronto, ON",
                "647-441-9922",
                "henry.walker@email.com",
                "US4477001",
                LocalDate.of(2031, 1, 1),
                "4024 9944 1133 2266",
                8,
                flight40
        );

        Passenger passenger43 = new Passenger(
                "Amina", "Zeroual",
                LocalDate.of(1996, 5, 8),
                "Female",
                "4580 Boul. Pie-IX, Montreal, QC",
                "514-602-8822",
                "amina.zeroual@email.com",
                "MA2288193",
                LocalDate.of(2027, 10, 3),
                "4024 1122 6644 9988",
                12,
                flight41
        );

        Passenger passenger44 = new Passenger(
                "Louis", "Harper",
                LocalDate.of(1994, 4, 1),
                "Male",
                "295 Queen St, Toronto, ON",
                "416-554-8822",
                "louis.harper@email.com",
                "UK3300114",
                LocalDate.of(2030, 2, 14),
                "4532 9900 2211 5566",
                10,
                flight42
        );

        Passenger passenger45 = new Passenger(
                "Aya", "Khatib",
                LocalDate.of(1997, 7, 22),
                "Female",
                "7550 Cote-St-Luc, Montreal, QC",
                "514-778-0044",
                "aya.khatib@email.com",
                "LB4433229",
                LocalDate.of(2028, 5, 4),
                "4024 8811 5533 1199",
                17,
                flight43
        );

        Passenger passenger46 = new Passenger(
                "Felix", "Morales",
                LocalDate.of(1995, 11, 26),
                "Male",
                "1400 Peel St, Montreal, QC",
                "514-405-2211",
                "felix.morales@email.com",
                "MX4477882",
                LocalDate.of(2031, 9, 3),
                "4024 5511 3300 7722",
                4,
                flight44
        );

        Passenger passenger47 = new Passenger(
                "Marwa", "Aziz",
                LocalDate.of(1998, 12, 6),
                "Female",
                "2200 Rue Rachel, Montreal, QC",
                "514-923-7711",
                "marwa.aziz@email.com",
                "MA1133448",
                LocalDate.of(2030, 12, 30),
                "4532 7722 1100 4455",
                6,
                flight45
        );

        Passenger passenger48 = new Passenger(
                "Thomas", "Lebrun",
                LocalDate.of(1993, 6, 19),
                "Male",
                "8800 Boul. St-Michel, Montreal, QC",
                "514-744-3399",
                "thomas.lebrun@email.com",
                "CA5599881",
                LocalDate.of(2029, 11, 7),
                "4024 2211 3300 4455",
                19,
                flight46
        );

        Passenger passenger49 = new Passenger(
                "Alicia", "Torres",
                LocalDate.of(1996, 2, 28),
                "Female",
                "744 Rue Amherst, Montreal, QC",
                "514-889-5500",
                "alicia.torres@email.com",
                "SP5511229",
                LocalDate.of(2027, 9, 2),
                "4024 5511 7722 0099",
                3,
                flight47
        );

        Passenger passenger50 = new Passenger(
                "Julien", "Perrot",
                LocalDate.of(1994, 8, 11),
                "Male",
                "3300 Maisonneuve E, Montreal, QC",
                "514-333-2211",
                "julien.perrot@email.com",
                "FR8811993",
                LocalDate.of(2030, 4, 14),
                "4488 9900 1122 5566",
                8,
                flight48
        );

        Passenger passenger51 = new Passenger(
                "Sami", "Hachem",
                LocalDate.of(1993, 1, 15),
                "Male",
                "12 Rue Wolfe, Montreal, QC",
                "514-440-9988",
                "sami.hachem@email.com",
                "LB5544221",
                LocalDate.of(2028, 8, 8),
                "4024 7766 1122 3300",
                2,
                flight49
        );

        Passenger passenger52 = new Passenger(
                "Maria", "Silva",
                LocalDate.of(1997, 4, 9),
                "Female",
                "18 Rue Amherst, Montreal, QC",
                "514-772-3366",
                "maria.silva@email.com",
                "BR7788441",
                LocalDate.of(2031, 1, 22),
                "4532 1166 7722 9900",
                5,
                flight50
        );

        Passenger passenger53 = new Passenger(
                "Jean", "Nguyen",
                LocalDate.of(1990, 8, 20),
                "Male",
                "4700 St-Denis, Montreal, QC",
                "514-882-4400",
                "jean.nguyen@email.com",
                "CA0022881",
                LocalDate.of(2029, 3, 17),
                "4024 9944 7766 5511",
                10,
                flight51
        );

        Passenger passenger54 = new Passenger(
                "Léa", "Marceau",
                LocalDate.of(1998, 10, 12),
                "Female",
                "6200 Newman Blvd, Lasalle, QC",
                "514-300-7788",
                "lea.marceau@email.com",
                "FR2299115",
                LocalDate.of(2028, 10, 30),
                "4024 3300 1122 9988",
                7,
                flight52
        );

        Passenger passenger55 = new Passenger(
                "Owen", "Bishop",
                LocalDate.of(1995, 3, 19),
                "Male",
                "204 Bay Street, Toronto, ON",
                "416-772-8899",
                "owen.bishop@email.com",
                "US8899113",
                LocalDate.of(2030, 5, 5),
                "4532 9922 5533 1100",
                14,
                flight53
        );

        Passenger passenger56 = new Passenger(
                "Dina", "Karam",
                LocalDate.of(1996, 12, 1),
                "Female",
                "1450 Papineau Ave, Montreal, QC",
                "514-889-2233",
                "dina.karam@email.com",
                "LB1122445",
                LocalDate.of(2027, 1, 29),
                "4024 6644 7722 1122",
                4,
                flight54
        );

        Passenger passenger57 = new Passenger(
                "Leo", "Fraser",
                LocalDate.of(1993, 11, 22),
                "Male",
                "188 King Edward Ave, Ottawa, ON",
                "613-554-7788",
                "leo.fraser@email.com",
                "UK9911228",
                LocalDate.of(2030, 12, 1),
                "4024 7711 0044 2233",
                9,
                flight55
        );

        Passenger passenger58 = new Passenger(
                "Nina", "Petrova",
                LocalDate.of(1997, 5, 30),
                "Female",
                "2100 St-Mathieu, Montreal, QC",
                "514-300-4411",
                "nina.petrova@email.com",
                "RU9900443",
                LocalDate.of(2028, 2, 14),
                "4024 5533 1177 8899",
                13,
                flight56
        );

        Passenger passenger59 = new Passenger(
                "Elias", "Gomez",
                LocalDate.of(1994, 7, 17),
                "Male",
                "5000 Cote des Neiges, Montreal, QC",
                "514-993-2233",
                "elias.gomez@email.com",
                "MX3377992",
                LocalDate.of(2031, 7, 19),
                "4024 8822 5511 0066",
                1,
                flight57
        );

        Passenger passenger60 = new Passenger(
                "Talia", "Rahim",
                LocalDate.of(1998, 3, 11),
                "Female",
                "33 Rue Ontario E, Montreal, QC",
                "514-440-9922",
                "talia.rahim@email.com",
                "EG6677554",
                LocalDate.of(2030, 9, 4),
                "4532 5500 3311 8844",
                7,
                flight58
        );

        Passenger passenger61 = new Passenger(
                "Jasper", "Ward",
                LocalDate.of(1995, 4, 4),
                "Male",
                "77 Dalhousie St, Ottawa, ON",
                "613-772-3300",
                "jasper.ward@email.com",
                "US5533991",
                LocalDate.of(2028, 6, 30),
                "4024 7788 2211 6644",
                18,
                flight59
        );

        Passenger passenger62 = new Passenger(
                "Mira", "Klein",
                LocalDate.of(1999, 1, 19),
                "Female",
                "28 Crescent St, Montreal, QC",
                "514-993-7700",
                "mira.klein@email.com",
                "DE5533110",
                LocalDate.of(2031, 5, 22),
                "4024 1166 7722 4400",
                2,
                flight60
        );

        Passenger passenger63 = new Passenger(
                "Rafael", "Sousa",
                LocalDate.of(1993, 7, 6),
                "Male",
                "6600 Sherbrooke E, Montreal, QC",
                "514-882-1100",
                "rafael.sousa@email.com",
                "BR3344551",
                LocalDate.of(2028, 11, 3),
                "4532 0099 3344 8822",
                11,
                flight11
        );

        Passenger passenger64 = new Passenger(
                "Helena", "Costa",
                LocalDate.of(1994, 11, 2),
                "Female",
                "1220 Fleury E, Montreal, QC",
                "514-667-8800",
                "helena.costa@email.com",
                "PT8877442",
                LocalDate.of(2030, 4, 11),
                "4024 4411 2200 7788",
                15,
                flight18
        );

        Passenger passenger65 = new Passenger(
                "Nathan", "Brooks",
                LocalDate.of(1996, 10, 14),
                "Male",
                "114 Rideau St, Ottawa, ON",
                "613-330-7744",
                "nathan.brooks@email.com",
                "US4422117",
                LocalDate.of(2029, 9, 22),
                "4024 3311 7788 5500",
                5,
                flight13
        );

        Passenger passenger66 = new Passenger(
                "Amaya", "López",
                LocalDate.of(1997, 12, 7),
                "Female",
                "2445 Notre-Dame E, Montreal, QC",
                "514-445-2211",
                "amaya.lopez@email.com",
                "SP6633219",
                LocalDate.of(2031, 6, 1),
                "4024 6600 5500 1122",
                14,
                flight14
        );

        Passenger passenger67 = new Passenger(
                "Adam", "Shaw",
                LocalDate.of(1993, 3, 20),
                "Male",
                "60 Jarvis St, Toronto, ON",
                "416-443-9988",
                "adam.shaw@email.com",
                "UK2211333",
                LocalDate.of(2028, 8, 14),
                "4532 1155 3300 9922",
                9,
                flight15
        );

        Passenger passenger68 = new Passenger(
                "Mariam", "Saidi",
                LocalDate.of(1994, 12, 1),
                "Female",
                "2005 Ontario St E, Montreal, QC",
                "514-772-1122",
                "mariam.saidi@email.com",
                "MA7711443",
                LocalDate.of(2030, 1, 3),
                "4024 5511 8866 0033",
                7,
                flight16
        );

        Passenger passenger69 = new Passenger(
                "Daniel", "Reyes",
                LocalDate.of(2000, 6, 3),
                "Male",
                "8005 St-Laurent, Montreal, QC",
                "514-333-7744",
                "daniel.reyes@email.com",
                "MX2211994",
                LocalDate.of(2027, 4, 19),
                "4024 4488 9922 1100",
                3,
                flight17
        );

        Passenger passenger70 = new Passenger(
                "Selena", "Holt",
                LocalDate.of(1998, 8, 29),
                "Female",
                "76 St-Marc St, Montreal, QC",
                "514-998-4422",
                "selena.holt@email.com",
                "US8844221",
                LocalDate.of(2029, 10, 14),
                "4024 2299 1144 7788",
                12,
                flight18
        );




        passengerRepository.saveAll(Arrays.asList(
                passenger1, passenger2, passenger3, passenger4, passenger5,
                passenger6, passenger7, passenger8, passenger9, passenger10,
                passenger11, passenger12, passenger13, passenger14, passenger15,
                passenger16, passenger17, passenger18, passenger19, passenger20,
                passenger21, passenger22, passenger23, passenger24, passenger25,
                passenger26, passenger27, passenger28, passenger29, passenger30,
                passenger31, passenger32, passenger33, passenger34, passenger35,
                passenger36, passenger37, passenger38, passenger39, passenger40,
                passenger41, passenger42, passenger43, passenger44, passenger45,
                passenger46, passenger47, passenger48, passenger49, passenger50,
                passenger51, passenger52, passenger53, passenger54, passenger55,
                passenger56, passenger57, passenger58, passenger59, passenger60,
                passenger61, passenger62, passenger63, passenger64, passenger65,
                passenger66, passenger67, passenger68, passenger69, passenger70
        ));

        System.out.println("Number of flights in DB: " + flightsRepository.count());
        logger.info("Flights count: {}", flightsRepository.count());

    }
}

