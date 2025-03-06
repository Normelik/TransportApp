package com.simple.backend.Service;

import com.simple.backend.DTO.RequestUserDTO;
import com.simple.backend.DTO.ResponseUserDTO;
import org.apache.tomcat.websocket.AuthenticationException;

public interface UserService {

    ResponseUserDTO registerUser(RequestUserDTO requestUserDTO);

    ResponseUserDTO loginUser(RequestUserDTO requestUserDTO) throws AuthenticationException;
}
