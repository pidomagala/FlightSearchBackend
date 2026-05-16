package com.piotr.flightsearchapi.service;

import com.piotr.flightsearchapi.domain.CreateUserRequest;
import com.piotr.flightsearchapi.domain.entity.User;

public interface UserService {
    User createUser(CreateUserRequest request);
}
