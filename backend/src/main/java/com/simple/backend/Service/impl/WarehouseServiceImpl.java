package com.simple.backend.Service.impl;

import com.simple.backend.DTO.WarehouseDTO;
import com.simple.backend.Service.WarehouseService;
import com.simple.backend.models.Warehouse;
import com.simple.backend.repositories.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    private WarehouseRepository warehouseRepository;
    
    @Autowired
    public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    public WarehouseDTO getWarehouse(int id) {
        Warehouse warehouse = warehouseRepository.findById(id).orElseThrow(() -> new RuntimeException("Warehouse with id " + id +" was not found"));
        return new WarehouseDTO(
                warehouse.getName(),
                warehouse.getPlannedShipments(),
                warehouse.getOwner()
        );
    }

    @Override
    public List<WarehouseDTO> getAllWarehouses() {
        List<Warehouse> warehouses = warehouseRepository.findAll();
        return warehouses.stream()
                .map(warehouse -> new WarehouseDTO(
                        warehouse.getName(),
                        warehouse.getPlannedShipments(),
                        warehouse.getOwner()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public int addWarehouse(WarehouseDTO warehouseDTO) {
        Warehouse newWarehouse = new Warehouse();
        newWarehouse.setName(warehouseDTO.name());
        newWarehouse.setPlannedShipments(warehouseDTO.plannedShipments());
        newWarehouse.setOwner(warehouseDTO.owner());

        warehouseRepository.save(newWarehouse);

        return newWarehouse.getId();
    }

    @Override
    public String deleteWarehouse(int id) {
        warehouseRepository.findById(id).orElseThrow(() -> new RuntimeException("Warehouse with id " + id +" was not found"));
        warehouseRepository.deleteById(id);
        return "Warehouse with id " + id +" was successfully deleted";
    }

    @Override
    public WarehouseDTO updateWarehouse(int id,WarehouseDTO newWarehouse) {
        Warehouse updatedWarehouse = warehouseRepository.findById(id).orElseThrow(() -> new RuntimeException("Warehouse with id " + id +" was not found"));
        updatedWarehouse.setName(newWarehouse.name());
        updatedWarehouse.setPlannedShipments(newWarehouse.plannedShipments());
        updatedWarehouse.setOwner(newWarehouse.owner());

        warehouseRepository.save(updatedWarehouse);

        return newWarehouse;
    }
}

