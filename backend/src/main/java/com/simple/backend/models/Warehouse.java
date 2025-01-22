package com.simple.backend.models;

import jakarta.persistence.*;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "warehouses")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "warehouse_name")
    private String name;
    @Column(name = "unloading_place")
    @NonNull
    private String unloadingPlace;
    @OneToMany
    private List<Shipment> plannedShipments = new ArrayList<>(12);
    private String owner;
    private String supplier;
}
