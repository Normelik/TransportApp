package com.simple.backend.controllers;

import com.simple.backend.DTO.UserDTO;
import com.simple.backend.Service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserServiceImpl userServiceImpl;

    @GetMapping("/all-users")
    public List<UserDTO> getAllUsers() {
        return userServiceImpl.getAllUsers();
    }

}
