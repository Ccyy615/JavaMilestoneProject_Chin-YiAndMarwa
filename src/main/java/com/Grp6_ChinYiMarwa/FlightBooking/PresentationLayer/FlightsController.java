package com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer;

import com.Grp6_ChinYiMarwa.FlightBooking.BusinessLayer.FlightsService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class FlightsController {

    private final FlightsService flightsService;

    public FlightsController(FlightsService flightsService){
        this.flightsService=flightsService;
    }

    //Get all the flights
    @GetMapping("/flights")
    public List<FlightsResponseDTO> getAllFlights(){
        return this.flightsService.getAllFlights();
    }

    //Get flights by the Identification
    @GetMapping("/flights/{id}")
        public FlightsResponseDTO getFlightById(@PathVariable String id){
            return this.flightsService.getFlightById(id);
        }

    //Create a flight
    @PostMapping("/flights")
        public ResponseEntity<FlightsResponseDTO> createFlight(@Valid @RequestBody FlightsRequestDTO flightData){
        FlightsResponseDTO newFlight= this.flightsService.createFlight(flightData);

        return ResponseEntity.created(URI.create("/flights"+ newFlight.getFlightId())).body(newFlight);
    }

//    //Update the flight
      @PutMapping("/flights/{id}")
    public ResponseEntity<FlightsResponseDTO> updateFlight(@PathVariable String id, @Valid @RequestBody FlightsRequestDTO requestFlight){
        FlightsResponseDTO flight = this.flightsService.updateFlight(id,requestFlight);
        return ResponseEntity.ok(flight);
      }

//
//    //delete flight
  @DeleteMapping("/flights/{id}")
    public ResponseEntity<Void> deleteFlightById(@PathVariable String id){
        this.flightsService.deleteFlightById(id);
        return ResponseEntity.noContent().build();
  }

}

