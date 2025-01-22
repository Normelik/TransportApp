package com.simple.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Shipment {
    @Id
    private int id;
}
