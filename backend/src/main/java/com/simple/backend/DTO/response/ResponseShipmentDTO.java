package com.simple.backend.DTO.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseShipmentDTO {
    Long id;
    @NotBlank(message = "Unloading time can't be empty") String unloadingTime;
    @NotBlank(message = "Unloading place can't be empty") String unloadingPlace;
    @NotBlank(message = "Plate number can't be empty") String plateNumber;
    boolean isBooked;
    String text;
    @NotNull(message = "Duration can't be empty")
    @Positive(message = "Duration can't be negative") Integer duration;
}
