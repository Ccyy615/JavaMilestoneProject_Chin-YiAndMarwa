package com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long passengerId; //PK

    @Column
    private int ticketId;
    private String firstName;
    private String lastName;

    @Past // this is for date of birth must be in the past
    private LocalDate dateOfBirth;

    private String gender;
    private String address;
    private String phoneNumber;

    @Email(message = "invalid email") // those are validation examples
    private String email;

    private String passportNumber;
    private LocalDate passportExpiryDate;
    private String creditCardNumber;

    //FirstClass, Economy, Business
    private String FlightClass;
    private int numOfBaggage;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "fK_flight_id")
    @NotNull
    private Flights flight; //flight object

    public Passenger(String firstName,String lastName,
                     LocalDate dateOfBirth, String gender, String address, String phoneNumber, String email,
                     String passportNumber,LocalDate passportExpiryDate,
                     String creditCardNumber, int numOfBaggage, Flights flight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passportNumber = passportNumber;
        this.passportExpiryDate = passportExpiryDate;
        this.creditCardNumber = creditCardNumber;
        this.numOfBaggage = numOfBaggage;
        this.flight = flight;
    }


    //Pk passengerId
    //Fk flightId
    // creates ticketId when choosing a flight




}
