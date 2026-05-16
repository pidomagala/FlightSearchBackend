package com.piotr.flightsearchapi.service.impl;

import com.piotr.flightsearchapi.domain.CreateUserRequest;
import com.piotr.flightsearchapi.domain.entity.User;
import com.piotr.flightsearchapi.repository.UserRepository;
import com.piotr.flightsearchapi.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(CreateUserRequest request) {
        User user = new User(null, request.Email(), request.PasswordHash());
        return userRepository.save(user);
    }
}
