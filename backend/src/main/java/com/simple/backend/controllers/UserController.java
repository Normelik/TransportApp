package com.simple.backend.controllers;

import com.simple.backend.DTO.UserDTO;
import com.simple.backend.Service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/public")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> userRegistration(@RequestBody @Valid UserDTO userDTO){
        return new ResponseEntity<>(userServiceImpl.registerUser(userDTO), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> userLogin(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userServiceImpl.loginUser(userDTO), HttpStatus.OK);
    }
}
