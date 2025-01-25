package com.simple.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "plate_number", nullable = false)
    @NotBlank(message = "Plate number is missing")
    private String plateNumber;

    @Column(name = "is_booked", nullable = false)
    @BooleanFlag
    private Boolean isBooked;

    @Column(nullable = false)
    @NotBlank(message = "Unloading time is missing")
    private String unloadingTime;

    @Column(name = "unloading_place")
    @NotBlank(message = "Unloading place is missing")
    private String unloadingPlace;

    public @NotBlank(message = "Unloading place is missing") String getUnloadingPlace() {
        return unloadingPlace;
    }

    public void setUnloadingPlace(@NotBlank(message = "Unloading place is missing") String unloadingPlace) {
        this.unloadingPlace = unloadingPlace;
    }

    @ManyToOne()
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Boolean getIsBooked() {
        return isBooked;
    }

    public void setIsBooked(Boolean booked) {
        isBooked = booked;
    }

    public String getUnloadingTime() {
        return unloadingTime;
    }

    public void setUnloadingTime(String unloadingTime) {
        this.unloadingTime = unloadingTime;
    }
}
