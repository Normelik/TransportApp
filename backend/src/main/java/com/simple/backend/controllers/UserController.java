package com.simple.backend.controllers;

import com.simple.backend.DTO.UserDTO;
import com.simple.backend.Service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> userRegistration(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userServiceImpl.registerUser(userDTO), HttpStatus.OK);
    }
}
