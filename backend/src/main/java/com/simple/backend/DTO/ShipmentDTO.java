package com.simple.backend.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ShipmentDTO(
        @NotBlank String unloadingTime,
        @NotBlank String unloadingPlace,
        @NotBlank String plateNumber,
        @NotNull Boolean isBooked,
        String text,
        @NotNull Integer duration
) {
    @Override
    public String unloadingTime() {
        return unloadingTime;
    }

    @Override
    public String unloadingPlace() {
        return unloadingPlace;
    }

    @Override
    public String plateNumber() {
        return plateNumber;
    }

    @Override
    public Boolean isBooked() {
        return isBooked;
    }

    @Override
    public String text() {
        return text;
    }

    @Override
    public Integer duration() {
        return duration;
    }
}
