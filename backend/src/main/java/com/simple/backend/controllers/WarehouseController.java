package com.simple.backend.controllers;

import com.simple.backend.DTO.WarehouseDTO;
import com.simple.backend.Service.impl.WarehouseServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouses")
@RequiredArgsConstructor
public class WarehouseController {

    private final WarehouseServiceImpl warehouseServiceImpl;

    @GetMapping
    public List<WarehouseDTO> getAllWarehouses() {
        return warehouseServiceImpl.getAllWarehouses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WarehouseDTO> getWarehouseById(@PathVariable Long id) {
        return ResponseEntity.ok(warehouseServiceImpl.getWarehouseById(id));
    }

    @PostMapping
    public ResponseEntity<WarehouseDTO> createWarehouse(@Valid @RequestBody WarehouseDTO warehouseDTO) {
        return ResponseEntity.ok(warehouseServiceImpl.createWarehouse(warehouseDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WarehouseDTO> updateWarehouse(@PathVariable Long id, @RequestBody WarehouseDTO warehouseDTO) {
        return ResponseEntity.ok(warehouseServiceImpl.updateWarehouse(id, warehouseDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarehouse(@PathVariable Long id) {
        warehouseServiceImpl.deleteWarehouse(id);
        return ResponseEntity.noContent().build();
    }
}
