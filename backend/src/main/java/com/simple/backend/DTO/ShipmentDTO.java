package com.simple.backend.DTO;

public record ShipmentDTO(
        String plateNumber,
        Boolean isBooked,
        String time
) {
}
