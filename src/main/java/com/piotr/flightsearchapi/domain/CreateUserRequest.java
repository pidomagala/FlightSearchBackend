package com.piotr.flightsearchapi.domain;

public record CreateUserRequest(Integer id, String Email, String PasswordHash) {

}
