package com.piotr.flightsearchapi.controller;

import com.piotr.flightsearchapi.domain.CreateUserRequest;
import com.piotr.flightsearchapi.domain.dto.*;
import com.piotr.flightsearchapi.domain.entity.User;
import com.piotr.flightsearchapi.mapper.UserMapper;
import com.piotr.flightsearchapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(
            @Valid @RequestBody CreateUserRequestDto createUserRequestDto
            ) {
        CreateUserRequest createUserRequest = userMapper.fromDTO(createUserRequestDto);
        User user = userService.createUser(createUserRequest);
        UserDto createdUserDto = userMapper.toDTO(user);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUsersEmail(
            @PathVariable Integer userId,
            @Valid @RequestBody UpdateUserEmailRequestDto updateUserEmailRequestDto){
        String Email = userMapper.emailFromDTO(updateUserEmailRequestDto);
       User user = userService.updateUserEmail(userId, Email);
       UserDto updatedUserDto = userMapper.toDTO(user);
       return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);
    }


    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUsersPassword(
            @PathVariable Integer userId,
            @Valid @RequestBody UpdateUserPasswordRequestDto updateUserPasswordRequestDto){
        String Password = userMapper.passwordFromDTO(updateUserPasswordRequestDto);
        User user = userService.updateUserEmail(userId, Password);
        UserDto updatedUserDto = userMapper.toDTO(user);
        return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);
    }


}
