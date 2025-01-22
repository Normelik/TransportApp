package com.simple.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shipment {
    @Id
    private int id;
    private String plateNumber;
    private Boolean isBooked;
    private String time;
}
