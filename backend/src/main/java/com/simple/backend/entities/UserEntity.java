package com.simple.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "users")
@Getter
public class UserEntity {
    @Id
    private Long id;
    private String username;
    private String password;
}
