package com.simple.backend.DTO;

import com.simple.backend.models.Shipment;

import java.util.List;

public record WarehouseDTO (
        String name,
        List<Shipment> plannedShipments,
        String owner) {
}
