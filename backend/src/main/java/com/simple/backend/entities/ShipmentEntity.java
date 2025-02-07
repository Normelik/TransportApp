package com.simple.backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "shipment_entity")
public class ShipmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "shipment_entity_seq")
    @SequenceGenerator(name = "shipment_entity_seq", sequenceName = "shipment_entity_sequence", allocationSize = 1)
    private int id;

    @Column(name = "unloading_time", nullable = false)
    @NotBlank(message = "unloading time can't be empty")
    private String unloadingTime;

    @Column(name = "unloading_place", nullable = false)
    @NotBlank(message = "unloading place can't be empty")
    private String unloadingPlace;

    private String text;

    private int duration;

    @Column(name = "plate_number", nullable = false)
    @NotBlank(message = "plate number can't be empty")
    private String plateNumber;

    @Column(name = "is_booked")
    @BooleanFlag
    private Boolean isBooked;

}
