package com.Grp6_ChinYiMarwa.FlightBooking.BusinessLayer;

import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.Flights;
import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.FlightsRepository;
import com.Grp6_ChinYiMarwa.FlightBooking.MapperLayer.FlightsMapper;
import com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer.FlightsRequestDTO;
import com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer.FlightsResponseDTO;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightsService {

    private FlightsResponseDTO flightsResponseDTO;
    private FlightsRequestDTO flightsRequestDTO;
    private FlightsMapper flightsMapper;
    private FlightsRepository flightsRepository;



    public List<FlightsResponseDTO> getAllFlights(){
        List<Flights> allFlights= this.flightsRepository.findAll();
        List<FlightsResponseDTO> flightsAll= new ArrayList<>();
        for(Flights flights : allFlights){
            flightsAll.add(this.flightsMapper.toResponse(flights));
        }
            return flightsAll;
    }

}
