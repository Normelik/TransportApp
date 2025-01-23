package com.simple.backend.DTO;

import lombok.NonNull;

public record ShipmentDTO(
        @NonNull String plateNumber,
        @NonNull Boolean isBooked,
        @NonNull String unloadingTime
) {
}
