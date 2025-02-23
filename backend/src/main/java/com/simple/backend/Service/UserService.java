package com.simple.backend.Service;

import com.simple.backend.DTO.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserDTO registerUser(UserDTO userDTO);

    UserDTO loginUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();
}
