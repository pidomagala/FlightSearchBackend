package com.piotr.flightsearchapi.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "favorites", schema = "flightsearch")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private Integer UserId;
    private Integer FlightId;

    public Favorite() {
    }

    public Favorite(Integer id, Integer userId, Integer flightId) {
        Id = id;
        UserId = userId;
        FlightId = flightId;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public Integer getFlightId() {
        return FlightId;
    }

    public void setFlightId(Integer flightId) {
        FlightId = flightId;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "Id=" + Id +
                ", UserId=" + UserId +
                ", FlightId=" + FlightId +
                '}';
    }
}
