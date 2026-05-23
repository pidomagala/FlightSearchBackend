package com.piotr.flightsearchapi.domain.dto;

import java.time.LocalDate;

public record FlightDto(
        Integer Id,
        String FlightNumber,
        int AirlineId,
        String FromAirportCode,
        String ToAirportCode,
        LocalDate DepartureTime,
        LocalDate ArrivalTime,
        String Status,
        String Gate,
        String Terminal
) {
}
