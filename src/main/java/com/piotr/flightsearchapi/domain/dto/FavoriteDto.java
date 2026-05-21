package com.piotr.flightsearchapi.domain.dto;

public record FavoriteDto(
        Integer Id,
        Integer UserId,
        Integer FlightId
) {
}
