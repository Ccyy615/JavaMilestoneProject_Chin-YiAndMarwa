package com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer;


import com.Grp6_ChinYiMarwa.FlightBooking.BusinessLayer.PassengerService;
import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.Passenger;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService){
        this.passengerService=passengerService;
    }

    @GetMapping
    public ResponseEntity<List<PassengerResponseDTO>> getPassengers(){
        List<PassengerResponseDTO> passengers = this.passengerService.getPassengers();
        return ResponseEntity.ok(passengers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassengerResponseDTO> getPassengerById(@PathVariable String id){
        PassengerResponseDTO passenger = this.passengerService.getPassengerById(id);
        return ResponseEntity.ok(passenger);
    }

    @PostMapping
    public ResponseEntity<PassengerResponseDTO> createPassenger(@Valid @RequestBody PassengerRequestDTO passengerData){

        PassengerResponseDTO savedPassenger = this.passengerService.createPassenger(passengerData);
        return ResponseEntity
                .created(URI.create("/passengers/" + savedPassenger.getPassengerId()))
                .body(savedPassenger);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PassengerResponseDTO> updatePassenger(@PathVariable String  id, @RequestBody PassengerRequestDTO requestPassenger){

        PassengerResponseDTO savedPassenger = this.passengerService.updatePassenger(id, requestPassenger);
        return ResponseEntity.ok(savedPassenger);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deletePassenger(@PathVariable String id){
        this.passengerService.deletePassenger(id);
        return ResponseEntity.noContent().build();
    }
}
