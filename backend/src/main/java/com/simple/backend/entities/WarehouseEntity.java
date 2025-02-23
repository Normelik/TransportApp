package com.simple.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "warehouses")
public class WarehouseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "warehouse_seq")
    @SequenceGenerator(name = "warehouse_seq",initialValue = 1,allocationSize = 10)
    private Long id;
    @Column(name = "warehouse_name")
    private String name;
    @Column(name = "unloading_place")
    private String unloadingPlace;
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ShipmentEntity> plannedShipments = new ArrayList<>(12);
    private String owner;
    private String supplier;
}
