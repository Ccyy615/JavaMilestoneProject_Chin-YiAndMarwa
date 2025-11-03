package com.Grp6_ChinYiMarwa.FlightBooking.BusinessLayer;

import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.Flights;
import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.FlightsRepository;
import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.Passenger;
import com.Grp6_ChinYiMarwa.FlightBooking.DataAccessLayer.PassengerRepository;
import com.Grp6_ChinYiMarwa.FlightBooking.MapperLayer.FlightsMapper;
import com.Grp6_ChinYiMarwa.FlightBooking.MapperLayer.PassengerMapper;
import com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer.FlightsRequestDTO;
import com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer.FlightsResponseDTO;
import com.Grp6_ChinYiMarwa.FlightBooking.PresentationLayer.PassengerResponseDTO;
import com.Grp6_ChinYiMarwa.FlightBooking.Utilities.FlightNotFoundException;
import com.Grp6_ChinYiMarwa.FlightBooking.Utilities.InvalidRequestFlightException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightsService {

    private final FlightsMapper flightsMapper;
    private final FlightsRepository flightsRepository;
    private final PassengerRepository passengerRepository;


    public FlightsService(FlightsRepository flightsRepository, FlightsMapper flightsMapper, PassengerRepository passengerRepository) {
        this.flightsMapper=flightsMapper;
        this.flightsRepository = flightsRepository;
        this.passengerRepository = passengerRepository;
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
        try{
            long idLong=Long.parseLong(id);
//        Optional<Flights> flights= this.flightsRepository.findById(idLong);
            Flights flights = flightsRepository.findById(idLong)
                    .orElseThrow(() -> new FlightNotFoundException("Flight with ID " + id + " not found"));
            return this.flightsMapper.toResponse(flights);
        }catch(NumberFormatException ex){
            throw new InvalidRequestFlightException("Invalid id format: "+id+" (Valid Id format ex. 1)");
        }

    }


    //create a flight

    public FlightsResponseDTO createFlight(FlightsRequestDTO flightData ){

        List<Flights> existingFlights = flightsRepository.findAll();

        for(Flights existingFlight : existingFlights) {
            if(existingFlight.getAirline().equals(flightData.getAirline()) &&
                    existingFlight.getPlaceDepart().equals(flightData.getPlaceDepart()) &&
                    existingFlight.getDestination().equals(flightData.getDestination()) &&
                    existingFlight.getDepartDate().equals(flightData.getDepartDate()) &&
                    existingFlight.getDepartTime().equals(flightData.getDepartTime())) {

                throw new ResponseStatusException(HttpStatus.CONFLICT, "Flight already exists");
            }
        }

        Flights flight=this.flightsMapper.toEntity(flightData);
        Flights savedFlights=this.flightsRepository.save(flight);
        return this.flightsMapper.toResponse(savedFlights);
    }


    //update a flight

    public FlightsResponseDTO updateFlight(String id, FlightsRequestDTO flightData){

        try{
            Long idLong=Long.parseLong(id);
            Flights existingFlight=this.flightsRepository.findById(idLong)
                    .orElseThrow(()-> new FlightNotFoundException("Flight: " + id +" does not exist"));

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
        }catch(NumberFormatException message){
            throw new InvalidRequestFlightException("Invalid id format: "+id+" (Valid Id format ex. 1)");
        }

    }


    //delete a flight

    public void deleteFlightById(String id){
        try{
            long idLong = Long.parseLong(id);

            Flights existingFlight=this.flightsRepository.findById(idLong)
                    .orElseThrow(()-> new FlightNotFoundException("Flight: "+ id + "does not exist"));
            flightsRepository.deleteById(idLong);
        }catch(NumberFormatException ex){
            throw new InvalidRequestFlightException("Invalid id format: "+ id +" (Valid Id format ex. 1)");
        }

    }


    public List<PassengerResponseDTO> getPassengersByFlightId(String id){
        try{
            Long idLong =Long.parseLong(id);
            Flights flights=this.flightsRepository.findById(idLong)
                    .orElseThrow(()-> new FlightNotFoundException("Flight:  " + idLong +" does not exist"));
            List<Passenger> passengers=this.passengerRepository.findPassengerByFlight(flights);
            return passengers.stream().map(PassengerMapper::toResponseToFlight)
                    .collect(Collectors.toList());
        }
        catch(NumberFormatException e){
            throw new InvalidRequestFlightException("Invalid id format"+id+" Valid Id format ex. 1");
        }
    }

}

//// 200 OK - successful retrieval
//return ResponseEntity.ok(car);
//// 201 Created - new resource created
//return ResponseEntity.status(HttpStatus.CREATED).body(newCar);
//// 204 No Content - successful deletion
//return ResponseEntity.noContent().build();
//// 400 Bad Request - invalid input
//throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid ID format");
//// 404 Not Found - resource doesn't exist
//throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found");
//// 409 Conflict - duplicate resource
//throw new ResponseStatusException(HttpStatus.CONFLICT, "Car with VIN already exists");
//// 500 Internal Server Error - unexpected error
//throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error");