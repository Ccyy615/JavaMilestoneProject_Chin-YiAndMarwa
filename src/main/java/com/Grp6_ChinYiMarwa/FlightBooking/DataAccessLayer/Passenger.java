package com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passengerId; //PK

    private String lastName;
    private String firstName;

    @Past
    private LocalDate dateOfBirth;
    private String gender;
    private String address;
    private String phoneNumber;

    @Email(message = "invalid email")
    private String email;

    private String passportNumber;
    private LocalDate passportExpiryDate;
    private String creditCardNumber;

    private int numOfBaggage;

    @ManyToOne(cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "fK_flight_id")
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







}
