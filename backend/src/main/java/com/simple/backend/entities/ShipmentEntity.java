package com.simple.backend.entities;

import com.simple.backend.models.WarehouseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shipments")
public class ShipmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "shipment_entity_seq")
    @SequenceGenerator(name = "shipment_entity_seq", sequenceName = "shipment_entity_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "unloading_time", nullable = false)
    private String unloadingTime;

    @Column(name = "unloading_place", nullable = false)
    private String unloadingPlace;

    @Column(name = "plate_number", nullable = false)
    private String plateNumber;

    @Column(name = "is_booked", nullable = false)
    private boolean isBooked;

    @Column(name = "text")
    private String text;

    @Column(name = "duration", nullable = false)
    private int duration;

    @ManyToOne()
    private WarehouseEntity warehouse;
}
