package com.simple.backend.Service.impl;

import com.simple.backend.DTO.WarehouseDTO;
import com.simple.backend.Service.WarehouseService;
import com.simple.backend.entities.ShipmentEntity;
import com.simple.backend.mappers.ShipmentMapper;
import com.simple.backend.mappers.WarehouseMapper;
import com.simple.backend.models.WarehouseEntity;
import com.simple.backend.repositories.WarehouseRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository warehouseRepository;
    private final WarehouseMapper warehouseMapper;
    private final ShipmentMapper shipmentMapper;

    @Override
    public List<WarehouseDTO> getAllWarehouses() {
        return warehouseRepository.findAll()
                .stream()
                .map(warehouseMapper::toDTO)
                .toList();
    }

    @Override
    public WarehouseDTO getWarehouseById(Long id) {
        WarehouseEntity warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Warehouse not found with ID: " + id));
        return warehouseMapper.toDTO(warehouse);
    }

    @Override
    public WarehouseDTO createWarehouse(WarehouseDTO warehouseDTO) {
        WarehouseEntity warehouse = warehouseMapper.toEntity(warehouseDTO);
        try {
            WarehouseEntity savedWarehouse = warehouseRepository.save(warehouse);
            return warehouseMapper.toDTO(savedWarehouse);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public WarehouseDTO updateWarehouse(Long id, WarehouseDTO warehouseDTO) {
        WarehouseEntity existingWarehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Warehouse not found with ID: " + id));

        if (warehouseDTO.name() != null) existingWarehouse.setName(warehouseDTO.name());
        if (warehouseDTO.unloadingPlace() != null) existingWarehouse.setUnloadingPlace(warehouseDTO.unloadingPlace());

        if (!warehouseDTO.plannedShipments().isEmpty()) {
            List<ShipmentEntity> shipmentEntityList = warehouseDTO.plannedShipments().stream()
                    .map(shipmentMapper::toEntity)
                    .collect(Collectors.toList());
            existingWarehouse.setPlannedShipments(shipmentEntityList);
        }
        if (warehouseDTO.supplier() != null) existingWarehouse.setSupplier(warehouseDTO.supplier());
        if (warehouseDTO.owner() != null) existingWarehouse.setOwner(warehouseDTO.owner());

        WarehouseEntity updatedWarehouse = warehouseRepository.save(existingWarehouse);
        return warehouseMapper.toDTO(updatedWarehouse);

    }
    @Override
    public void deleteWarehouse(Long id) {
        WarehouseEntity warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Warehouse not found with ID: " + id));
        warehouseRepository.delete(warehouse);
    }
}

