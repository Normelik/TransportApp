package com.simple.backend.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UserDTO(
        @NotBlank(message = "Username is required")
        @Pattern(regexp = "^[^0-9]*$", message = "Username cannot contain numbers")
        String username,
        @NotBlank(message = "Password is required") String password
) {}
