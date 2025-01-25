package com.simple.backend.controllers;

import com.simple.backend.DTO.WarehouseDTO;
import com.simple.backend.Service.impl.WarehouseServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouses")
public class WarehouseController {

    private final WarehouseServiceImpl warehouseServiceImpl;

    @Autowired
    public WarehouseController(WarehouseServiceImpl warehouseServiceImpl) {
        this.warehouseServiceImpl = warehouseServiceImpl;
    }


    @GetMapping("/{id}")
    public WarehouseDTO getWarehouse(@PathVariable("id") int id) {
        return warehouseServiceImpl.getWarehouse(id);
    }

    @GetMapping()
    public List<WarehouseDTO> getAllWarehouses() {
        return warehouseServiceImpl.getAllWarehouses();
    }

    @PostMapping()
    public int createWarehouse(@Valid @RequestBody WarehouseDTO newWarehouse) {
        return warehouseServiceImpl.addWarehouse(newWarehouse);
    }

    @DeleteMapping("/{id}")
    public String deleteWarehouse(@PathVariable int id) {
        return warehouseServiceImpl.deleteWarehouse(id);
    }

    @PutMapping("/{id}")
    public WarehouseDTO updateWarehouse(@PathVariable("id") int id, @Valid @RequestBody WarehouseDTO newWarehouse) {
        return warehouseServiceImpl.updateWarehouse(id, newWarehouse);
    }
}
