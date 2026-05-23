package com.piotr.flightsearchapi.repository;

import com.piotr.flightsearchapi.domain.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {

    @Query(value = "SELECT * FROM favorites WHERE UserId = :UserId", nativeQuery = true)
    List<Favorite> findByUserId(@Param("UserId") Integer UserId);

    @Query(value = "SELECT * FROM favorites WHERE UserId = :UserId AND FlightId = :FlightId", nativeQuery = true)
    Favorite findByUserIdAndFlightId(@Param("UserId")Integer UserId, @Param("FlightId")int FlightId);
}
