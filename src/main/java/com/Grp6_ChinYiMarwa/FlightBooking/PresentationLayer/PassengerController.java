package com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer;


import com.Grp6_ChinYiMarwa.FlightBooking.BusinessLayer.PassengerService;
import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.Passenger;
import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.PassengerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping
public class PassengerController {

    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService){
        this.passengerService=passengerService;
    }

    @GetMapping("/passengers")
    public List<Passenger> getPassengers(){
        return this.passengerService.getPassengers();
    }

    @GetMapping("/passengers/{id}")
    public Optional<Passenger> getPassengerById(Long id){
        return this.passengerService.getPassengerById(id);
    }

    @PostMapping("/passengers")
    public Map<String, Object> createPassenger(@RequestBody Map<String, Object> passengerData){
        /*return Map.of("status", "success", "message", "Passenger created successfully",
                "data", carData, "id assigned to new passenger", System.currentTimeMillis());*/

        Passenger savedNewPassenger = this.passengerService.createPassenger(passengerData);
        Map<String,Object> result;
        if (savedNewPassenger != null)
            result=Map.of("status", "success", "message",
                    "Passenger created successfully", "new passenger saved", savedNewPassenger,
                    "id assigned to new passenger", savedNewPassenger.getPassengerId());
        else {
            result=Map.of("ststus","Failure",
                    "message", "Could not save new passenger in database");
        }
        return result;
    }

    @PutMapping("/passengers/{id}")
    public Map<String, Object> updatePassenger(@PathVariable Long id, @RequestBody Map<String, Object> passengerData){
        /*return Map.of("status", "success", "message", "Car updated successfully",
                "id", id, "updataData", carData);*/
        Passenger updatedPassenger = this.passengerService.updatePassenger(id, passengerData);
        Map<String, Object> result;
        if (updatedPassenger != null)
            result=Map.of(
                    "status", "success",
                    "message","Passenger created successfully",
                    "new car saved", updatedPassenger,
                    "id assigned to new car", updatedPassenger.getPassengerId()
            );
        else {
            result=Map.of(
                    "status", "Failure",
                    "message", "Could not save passenger in database"
            );
        }
        return result;
    }

    @DeleteMapping("/passengers/{id}")
    public Map<String, Object> deletePassenger(@PathVariable Long id){
        return Map.of("status", "success", "message",
                "Passenger deleted successfully", "id", id);
    }

}
