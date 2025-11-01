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

        /*Passenger savedNewPassenger = this.passengerService.createPassenger(passengerData);
        Map<String,Object> result;
        if (savedNewPassenger != null)
            result=Map.of("status", "success", "message",
                    "Passenger created successfully", "new passenger saved", savedNewPassenger,
                    "id assigned to new passenger", savedNewPassenger.getPassengerId());
        else {
            result=Map.of("ststus","Failure",
                    "message", "Could not save new passenger in database");
        }
        return result;*/
    }

    @PutMapping("/{id}")
    public ResponseEntity<PassengerResponseDTO> updatePassenger(@PathVariable String  id, @RequestBody PassengerRequestDTO requestPassenger){

        PassengerResponseDTO savedPassenger = this.passengerService.updatePassenger(id, requestPassenger);
        return ResponseEntity.ok(savedPassenger);

        /*Passenger updatedPassenger = this.passengerService.updatePassenger(id, passengerData);
        Map<String, Object> result;
        if (updatedPassenger != null)
            result=Map.of(
                    "status", "success",
                    "message","Passenger created successfully",
                    "new passenger saved", updatedPassenger,
                    "id assigned to new car", updatedPassenger.getPassengerId()
            );
        else {
            result=Map.of(
                    "status", "Failure",
                    "message", "Could not save passenger in database"
            );
        }
        return result;*/
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deletePassenger(@PathVariable String id){
        this.passengerService.deletePassenger(id);
        return ResponseEntity.noContent().build();
    }
}
