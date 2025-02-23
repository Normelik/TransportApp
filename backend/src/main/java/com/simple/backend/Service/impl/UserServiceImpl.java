package com.simple.backend.Service.impl;

import com.simple.backend.DTO.ShipmentDTO;
import com.simple.backend.DTO.UserDTO;
import com.simple.backend.Service.UserService;
import com.simple.backend.entities.UserEntity;
import com.simple.backend.models.UserPrincipal;
import com.simple.backend.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found in database with username: " + username));

        return new UserPrincipal(userEntity);
    }

    public UserDTO registerUser(UserDTO userDTO) {
        if(userDTO == null){
            throw new UsernameNotFoundException("User not found");
        }
        UserEntity newUser = new UserEntity();
        newUser.setUsername(userDTO.username());
        newUser.setPassword(encoder.encode(userDTO.password()));
        System.out.println(newUser.getPassword());

        userRepository.save(newUser);

        return new UserDTO(
                newUser.getUsername(),
                newUser.getPassword()
        );
    }

    @Override
    public UserDTO loginUser(UserDTO userDTO) {
        UserEntity userEntity = userRepository.findByUsername(userDTO.username())
                .orElseThrow(() -> new EntityNotFoundException("User not found in database with username: " + userDTO.username()));

        encoder.matches(userDTO.password(), userEntity.getPassword());
        return new UserDTO(userEntity.getUsername(), userEntity.getPassword());
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(username -> {
                    return new UserDTO(
                            username.getUsername(),
                            username.getPassword()
                    );
                })
                .collect(Collectors.toList());
    }
}
