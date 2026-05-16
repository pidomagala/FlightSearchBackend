package com.piotr.flightsearchapi.repository;

import com.piotr.flightsearchapi.domain.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Integer> {

}
