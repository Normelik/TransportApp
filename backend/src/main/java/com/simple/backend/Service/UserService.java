package com.simple.backend.Service;

import com.simple.backend.DTO.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDTO registerUser(UserDTO userDTO);
}
