package com.simple.backend.Service;

import com.simple.backend.DTO.ShipmentDTO;

import java.util.List;

public interface ShipmentService {
    List<ShipmentDTO> getAllShipments();
    ShipmentDTO getShipmentById(Long id);
    ShipmentDTO createShipment(ShipmentDTO shipmentDTO);
    ShipmentDTO updateShipment(Long id, ShipmentDTO shipmentDTO);
    void deleteShipment(Long id);
}
