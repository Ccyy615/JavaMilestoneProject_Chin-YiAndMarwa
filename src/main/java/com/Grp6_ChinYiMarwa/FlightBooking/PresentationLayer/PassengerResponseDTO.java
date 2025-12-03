package com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PassengerResponseDTO {

    private Long passengerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    private String passportNumber;
    private LocalDate passportExpiryDate;
    private String creditCardNumber;
    private int numOfBaggage;
    private Long flightId;

//    public PassengerResponseDTO(Long passengerId, String firstName, String lastName,
//                                String phoneNumber, String email, String passportNumber,
//                                LocalDate passportExpiryDate, String creditCardNumber, int numOfBaggage, Long flightId) {
//        this.passengerId = passengerId;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.flightId = flightId;
//        this.phoneNumber = phoneNumber;
//        this.email = email;
//        this.passportNumber = passportNumber;
//        this.passportExpiryDate=passportExpiryDate;
//        this.creditCardNumber = creditCardNumber;
//        this.numOfBaggage = numOfBaggage;
//        this.flightId = flightId;
//    }


}
