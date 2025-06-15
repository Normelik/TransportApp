package com.simple.backend.DTO;

import java.util.List;

public record WarehouseDTO (
        String name,
        String unloadingPlace,
        List<RequestShipmentDTO> plannedShipments,
        String owner,
        String supplier
) {
}
