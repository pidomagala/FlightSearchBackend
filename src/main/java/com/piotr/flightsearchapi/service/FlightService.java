package com.piotr.flightsearchapi.service;

import com.piotr.flightsearchapi.domain.FindFlightsRequest;
import com.piotr.flightsearchapi.domain.entity.Flight;

import java.time.LocalDate;
import java.util.List;


public interface FlightService {
    List<Flight> getAllFlights();
    List<Flight> getFlightByNumber(String FlightNumber);
    Flight addFlight(Flight flight);
    List<Flight> findFlights(FindFlightsRequest request);
    Flight updateFlight(Flight flight);
    void deleteFlight(Integer Id);
    List<Flight> findFlightsByFromAirportCode(String FromAirportCode);
    List<Flight> findFlightsByToAirportCode(String ToAirportCode);
    List<Flight> findFlightsByDepartureTime(LocalDate DepartureTime);
    List<Flight> findFlightsByToAirportCodeAndFromAirportCode(String ToAirportCode, String FromAirportCode);

}
