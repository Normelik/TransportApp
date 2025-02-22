package com.simple.backend.Service.impl;

import com.simple.backend.Service.UserService;
import com.simple.backend.entities.UserEntity;
import com.simple.backend.models.UserPrincipal;
import com.simple.backend.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found in database with username: " + username));

        return new UserPrincipal(userEntity);
    }

}
