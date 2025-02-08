package com.simple.backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.BooleanFlag;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity(name = "shipment_entity")
public class ShipmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "shipment_entity_seq")
    @SequenceGenerator(name = "shipment_entity_seq", sequenceName = "shipment_entity_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "unloading_time", nullable = false)
    @NotBlank(message = "unloading time can't be empty")
    private String unloadingTime;

    @Column(name = "unloading_place", nullable = false)
    @NotBlank(message = "unloading place can't be empty")
    private String unloadingPlace;

    @Column(name = "plate_number", nullable = false)
    @NotBlank(message = "plate number can't be empty")
    private String plateNumber;

    @Column(name = "is_booked", nullable = false)
    @BooleanFlag
    private Boolean isBooked;

    private String text;

    @Column(name = "duration", nullable = false)
    @NotNull
    @Min(value = 1, message = "Duration must be at least 1")
    private Integer duration;

    public Long getId() {
        return id;
    }

    public String getUnloadingTime() {
        return unloadingTime;
    }

    public String getUnloadingPlace() {
        return unloadingPlace;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public Boolean getIsBooked() {
        return isBooked;
    }

    public String getText() {
        return text;
    }

    public int getDuration() {
        return duration;
    }

    public ShipmentEntity(Long id, String unloadingTime, String unloadingPlace, String plateNumber, Boolean isBooked, String text, int duration) {
        this.id = id;
        this.unloadingTime = unloadingTime;
        this.unloadingPlace = unloadingPlace;
        this.plateNumber = plateNumber;
        this.isBooked = isBooked;
        this.text = text;
        this.duration = duration;
    }

    public ShipmentEntity() {
    }

    public ShipmentEntity(String unloadingTime, String unloadingPlace, String plateNumber, Boolean isBooked, String text, int duration) {
        this.unloadingTime = unloadingTime;
        this.unloadingPlace = unloadingPlace;
        this.plateNumber = plateNumber;
        this.isBooked = isBooked;
        this.text = text;
        this.duration = duration;
    }
}
