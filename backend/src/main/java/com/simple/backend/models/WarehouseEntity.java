package com.simple.backend.models;

import com.simple.backend.entities.ShipmentEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
