package com.simple.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "Unloading place is missing")
    private String unloadingPlace;
    @OneToMany(mappedBy = "warehouse",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @NotNull
    private List<Shipment> plannedShipments = new ArrayList<>(12);
    private String owner;
    private String supplier;
}
