package com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer;

import com.Grp6_ChinYiMarwa.FlightBooking.BusinessLayer.FlightsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightsController {

    private FlightsService flightsService;

    public FlightsController(FlightsService flightsService){
        this.flightsService=flightsService;
    }
    @GetMapping("/flights")
    public List<FlightsResponseDTO> getAllFlights(){
        return this.flightsService.getAllFlights();

    }


}
