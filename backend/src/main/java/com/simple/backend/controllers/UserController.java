package com.simple.backend.controllers;

import com.simple.backend.DTO.RequestUserDTO;
import com.simple.backend.DTO.response.ResponseUserDTO;
import com.simple.backend.Service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/public")
@CrossOrigin(origins = "http://localhost:5173")

public class UserController {

    private final UserServiceImpl userServiceImpl;


    @PostMapping("/register")
    public ResponseEntity<ResponseUserDTO> userRegistration(@RequestBody RequestUserDTO requestUserDTO){
        return new ResponseEntity<>(userServiceImpl.registerUser(requestUserDTO), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseUserDTO> userLogin(@RequestBody RequestUserDTO requestUserDTO){
        return new ResponseEntity<>(userServiceImpl.loginUser(requestUserDTO), HttpStatus.OK);
    }
}
