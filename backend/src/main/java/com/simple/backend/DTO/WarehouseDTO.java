package com.simple.backend.DTO;

import java.util.List;

public record WarehouseDTO (
        String name,
        String unloadingPlace,
        List<ShipmentDTO> plannedShipments,
        String owner,
        String supplier
) {
}
