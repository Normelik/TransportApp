package com.simple.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "warehouses")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "warehouse_name")
    private String name;
    @OneToMany(mappedBy = "warehouse",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @NotNull
    private List<Shipment> plannedShipments = new ArrayList<>(12);
    private String owner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public @NotNull List<Shipment> getPlannedShipments() {
        return plannedShipments;
    }

    public void setPlannedShipments(@NotNull List<Shipment> plannedShipments) {
        this.plannedShipments = plannedShipments;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
