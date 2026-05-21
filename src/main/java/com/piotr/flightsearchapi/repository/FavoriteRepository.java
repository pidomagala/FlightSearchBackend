package com.piotr.flightsearchapi.repository;

import com.piotr.flightsearchapi.domain.entity.Favorite;
import com.piotr.flightsearchapi.domain.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {

    @Query(value = "SELECT * FROM favorites WHERE UserId = :UserId", nativeQuery = true)
    List<Flight> findByUserId(Integer UserId);

    @Query(value = "SELECT * FROM favorites WHERE FlightId = :FlightId", nativeQuery = true)
    Favorite findByFlightId(Integer FlightId);
}
