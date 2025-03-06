package com.simple.backend.Service.impl;

import com.simple.backend.DTO.RequestUserDTO;
import com.simple.backend.DTO.ResponseUserDTO;
import com.simple.backend.Service.UserService;
import com.simple.backend.entities.UserEntity;
import com.simple.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationProvider provider;
    private final JwtService jwtService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationProvider provider, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.provider = provider;
        this.jwtService = jwtService;
    }


    public List<RequestUserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(username -> {
                    return new RequestUserDTO(
                            username.getUsername(),
                            username.getPassword()
                    );
                })
                .collect(Collectors.toList());
    }

    @Override
    public ResponseUserDTO registerUser(RequestUserDTO requestUserDTO) {
        if (userRepository.existsByUsername(requestUserDTO.username())){
            throw new UsernameNotFoundException("username already exists in database"); // TODO - usernameAlreadyExistsException
        }

        UserEntity newUser = new UserEntity();
        newUser.setUsername(requestUserDTO.username());
        newUser.setPassword(passwordEncoder.encode(requestUserDTO.password()));

        userRepository.save(newUser);

        return new ResponseUserDTO(newUser.getUsername());
    }

    @Override
    public ResponseUserDTO loginUser(RequestUserDTO requestUserDTO) {
        Authentication authenticationRequest = UsernamePasswordAuthenticationToken.unauthenticated(requestUserDTO.username(), requestUserDTO.password());
        Authentication authentication = provider.authenticate(authenticationRequest);
        if (!authentication.isAuthenticated()) {
            throw new UsernameNotFoundException("User not found");
        }
        return new ResponseUserDTO(jwtService.generateToken(authentication)); // TODO tokenservice.generateToken
    }
}
