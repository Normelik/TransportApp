package com.simple.backend.mappers;

import com.simple.backend.DTO.ShipmentDTO;
import com.simple.backend.DTO.WarehouseDTO;
import com.simple.backend.entities.ShipmentEntity;
import com.simple.backend.entities.WarehouseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class WarehouseMapper {

    private final ShipmentMapper shipmentMapper;

    public WarehouseEntity toEntity(WarehouseDTO dto) {
        WarehouseEntity warehouse = new WarehouseEntity();
        warehouse.setName(dto.name());
        warehouse.setUnloadingPlace(dto.unloadingPlace());
        if (dto.plannedShipments() != null && !dto.plannedShipments().isEmpty()) {
            List<ShipmentEntity> shipmentEntityList = dto.plannedShipments().stream()
                    .filter(Objects::nonNull)
                    .map(shipmentMapper::toEntity)
                    .collect(Collectors.toList());
            warehouse.setPlannedShipments(shipmentEntityList);
        } else {
            warehouse.setPlannedShipments(new ArrayList<>());
        }
        warehouse.setOwner(dto.owner());
        warehouse.setSupplier(dto.supplier());

        return warehouse;
    }

    public WarehouseDTO toDTO(WarehouseEntity warehouseEntity) {
        List<ShipmentDTO> dtoList = warehouseEntity.getPlannedShipments()
                .stream()
                .map(shipmentMapper::toDTO).toList();
        return new WarehouseDTO(
                warehouseEntity.getName(),
                warehouseEntity.getUnloadingPlace(),
                dtoList,
                warehouseEntity.getOwner(),
                warehouseEntity.getSupplier()
        );
    }
}
