package com.simple.backend.models;

import jakarta.validation.constraints.NotBlank;
import jdk.jfr.BooleanFlag;
import lombok.*;


@Builder
public class Shipment {

    @NotBlank(message = "unloading time can't be empty")
    private String unloadingTime;

    @NotBlank(message = "unloading place can't be empty")
    private String unloadingPlace;

    @NotBlank(message = "plate number can't be empty")
    private String plateNumber;

    @BooleanFlag
    private Boolean isBooked;

    private String text;

    private int duration;

    public Shipment() {
    }

    public Shipment( String unloadingTime, String unloadingPlace, String plateNumber, Boolean isBooked, String text, int duration) {
        this.unloadingTime = unloadingTime;
        this.unloadingPlace = unloadingPlace;
        this.plateNumber = plateNumber;
        this.isBooked = isBooked;
        this.text = text;
        this.duration = duration;
    }

    public @NotBlank(message = "unloading time can't be empty") String getUnloadingTime() {
        return unloadingTime;
    }

    public void setUnloadingTime(@NotBlank(message = "unloading time can't be empty") String unloadingTime) {
        this.unloadingTime = unloadingTime;
    }

    public @NotBlank(message = "unloading place can't be empty") String getUnloadingPlace() {
        return unloadingPlace;
    }

    public void setUnloadingPlace(@NotBlank(message = "unloading place can't be empty") String unloadingPlace) {
        this.unloadingPlace = unloadingPlace;
    }

    public @NotBlank(message = "plate number can't be empty") String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(@NotBlank(message = "plate number can't be empty") String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Boolean getBooked() {
        return isBooked;
    }

    public void setBooked(Boolean booked) {
        isBooked = booked;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
