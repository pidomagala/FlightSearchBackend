package com.piotr.flightsearchapi.service.impl;

import com.piotr.flightsearchapi.domain.CreateUserRequest;
import com.piotr.flightsearchapi.domain.entity.User;
import com.piotr.flightsearchapi.repository.UserRepository;
import com.piotr.flightsearchapi.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Optional<User> getUserbyEmail(String Email){
        return Optional.ofNullable(userRepository.findByEmail(Email));
    }

    @Override
    public User createUser(CreateUserRequest request) {
        if (getUserbyEmail(request.Email()).isPresent()) {
            throw new IllegalArgumentException("User with this email already exists");
        }
        User user = new User(null, request.Email(), request.PasswordHash());
        return userRepository.save(user);
    }

    @Override
    public User updateUserEmail(Integer Id, String Email) {
        User user = userRepository.findByEmail(Email);
        if(!Objects.equals(user.getId(), Id)){
            throw new IllegalArgumentException("User with this email already exists");
        }
        user.setEmail(Email);
        return userRepository.save(user);
    }

    @Override
    public User updateUserPassword(Integer Id, String PasswordHash) {
        User user = userRepository.findById(Id)
                .orElseThrow(() -> new IllegalArgumentException("User with this id does not exist"));
        if(user.getPasswordHash().equals(PasswordHash)){
            throw new IllegalArgumentException("Passwords must be different");
        }
        user.setPasswordHash(PasswordHash);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String email) {
        User user = userRepository.findByEmail(email);
        userRepository.delete(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByEmail(String Email) {
        return userRepository.findByEmail(Email);
    }

    @Override
    public User findUserByEmailAndPassword(String Email, String PasswordHash){
        return userRepository.findByEmailAndPassword(Email, PasswordHash);
    }


}
