package com.simple.backend.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "warehouses")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String unloadingPlace;
    @OneToMany
    private List<Shipment> plannedShipments;
    private String owner;
    private String supplier;
}
