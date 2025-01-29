package com.simple.backend.DTO;

import com.simple.backend.models.Warehouse;
import lombok.NonNull;
public record ShipmentDTO(
        @NonNull String plateNumber,
        @NonNull Boolean isBooked,
        @NonNull String unloadingPlace,
        @NonNull String unloadingTime,
        Warehouse warehouse
) {
}
