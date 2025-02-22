package com.simple.backend.Service;

import com.simple.backend.DTO.WarehouseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WarehouseService {
    List<WarehouseDTO> getAllWarehouses();
    WarehouseDTO getWarehouseById(Long id);
    WarehouseDTO createWarehouse(WarehouseDTO warehouseDTO);
    WarehouseDTO updateWarehouse(Long id, WarehouseDTO warehouseDTO);
    void deleteWarehouse(Long id);

}
