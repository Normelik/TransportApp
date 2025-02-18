package com.simple.backend.Service;

import com.simple.backend.DTO.WarehouseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WarehouseService {
    WarehouseDTO getWarehouse(int id);

    List<WarehouseDTO> getAllWarehouses();

    int addWarehouse(WarehouseDTO warehouseDTO);

    String deleteWarehouse(int id);

    WarehouseDTO updateWarehouse(int id, WarehouseDTO warehouseDTO);
}
