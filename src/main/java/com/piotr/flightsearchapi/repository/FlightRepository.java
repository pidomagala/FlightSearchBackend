package com.piotr.flightsearchapi.repository;

import com.piotr.flightsearchapi.domain.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    @Query(value = "SELECT * FROM flights WHERE ToAirportCode = :ToAirportCode", nativeQuery = true)
    List<Flight> findByToAirportCode(@Param("ToAirportCode") String ToAirportCode);

    @Query(value = "SELECT * FROM flights WHERE FromAirportCode = :FromAirportCode", nativeQuery = true)
    List<Flight> findByFromAirportCode(@Param("FromAirportCode") String FromAirportCode);

    @Query(value = "SELECT * FROM flights WHERE DepartureTime = :DepartureTime", nativeQuery = true)
    List<Flight> findByDepartureTime(@Param("DepartureTime") LocalDate DepartureTime);

    @Query(value = "SELECT * FROM flights WHERE FlightNumber  = :FlightNumber", nativeQuery = true)
    List<Flight> findByFlightNumber(@Param("FlightNumber") String FlightNumber);

    @Query(value ="SELECT * FROM flights  WHERE FromAirportCode = :FromAirportCode  AND ToAirportCode = :ToAirportCode", nativeQuery = true)
    List<Flight> findByToAirportCodeAndFromAirportCode(@Param("ToAirportCode") String ToAirportCode, @Param("FromAirportCode") String FromAirportCode);

    @Query(value="SELECT * FROM flights WHERE FromAirportCode = :FromAirportCode AND ToAirportCode = :ToAirportCode AND DepartureTime = :DepartureTime", nativeQuery = true)
    List<Flight> findByToAirportCodeAndFromAirportCodeAndDepartureTime(@Param("ToAirportCode") String ToAirportCode, @Param("FromAirportCode") String FromAirportCode, @Param("DepartureTime") LocalDate DepartureTime);


}
