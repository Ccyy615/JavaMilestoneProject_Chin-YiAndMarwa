package com.Grp6_ChinYiMarwa.FlightBooking.BusinessLayer;

import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.Flights;
import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.FlightsRepository;
import com.Grp6_ChinYiMarwa.FlightBooking.MapperLayer.FlightsMapper;
import com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer.FlightsRequestDTO;
import com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer.FlightsResponseDTO;
import com.Grp6_ChinYiMarwa.FlightBooking.Utilities.FlightNotFoundException;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightsService {

    private final FlightsMapper flightsMapper;
    private final FlightsRepository flightsRepository;

    public FlightsService(FlightsRepository flightsRepository,FlightsMapper flightsMapper) {
        this.flightsMapper=flightsMapper;
        this.flightsRepository = flightsRepository;
    }

    //get all flights
    public List<FlightsResponseDTO> getAllFlights(){
        List<Flights> allFlights= this.flightsRepository.findAll();
        List<FlightsResponseDTO> flightsAll= new ArrayList<>();
        for(Flights flights : allFlights){
            flightsAll.add(this.flightsMapper.toResponse(flights));
        }
            return flightsAll;
    }

    //get flight by id

    public FlightsResponseDTO getFlightById(@PathVariable String id){
        long idLong=Long.parseLong(id);
        Optional<Flights> flights=this.flightsRepository.findById(idLong);
        return this.flightsMapper.toResponse(flights.get());
    }


    //create a flight

    public FlightsResponseDTO createFlight(FlightsRequestDTO flightData ){
        Flights flight=this.flightsMapper.toEntity(flightData);
        Flights savedFlights=this.flightsRepository.save(flight);
        return this.flightsMapper.toResponse(savedFlights);
    }


    //update a flight

    public FlightsResponseDTO updateFlight(String id, FlightsRequestDTO flightData){
        Long idLong=Long.parseLong(id);

        Flights existingFlight=this.flightsRepository.findById(idLong)
                .orElseThrow(()-> new FlightNotFoundException("This Flight does not exist"));


        existingFlight.setAirline(flightData.getAirline());
        existingFlight.setPlaceDepart(flightData.getPlaceDepart());
        existingFlight.setDepartDate(flightData.getDepartDate());
        existingFlight.setDepartTime(flightData.getDepartTime());
        existingFlight.setDestination(flightData.getDestination());
        existingFlight.setArrivalDate(flightData.getArrivalDate());
        existingFlight.setArrivalTime(flightData.getArrivalTime());
        existingFlight.setPrice(flightData.getPrice());

        Flights updatedFlight=this.flightsRepository.save(existingFlight);
        return this.flightsMapper.toResponse(updatedFlight);
    }


    //delete a flight

    public void deleteFlightById(String id){
        long idLong = Long.parseLong(id);

        Flights existingFlight=this.flightsRepository.findById(idLong)
                .orElseThrow(()-> new FlightNotFoundException("This Flight does not exist"));

        List<Flights> flights=this.flightsRepository.findAllById((Iterable<Long>) existingFlight);

        if(!flights.isEmpty()){
            throw new FlightNotFoundException("a test");
        }

        flightsRepository.deleteById(idLong);
    }


    /*
    *    public void deleteOwnerById(String id) {

        Owner existingOwner = ownerRepository.findById(longId)
            .orElseThrow(() -> new OwnerNotFoundException("Owner with id: " + longId + " not found."));
        List<Car> cars = carRepository.findCarsByOwner(existingOwner);

        if (!cars.isEmpty()) {
           throw new InvalidOwnerDeleteException( "Cannot delete owner with existing cars.");
    }
        ownerRepository.deleteById(longId);
    }
    *
    * */
}
