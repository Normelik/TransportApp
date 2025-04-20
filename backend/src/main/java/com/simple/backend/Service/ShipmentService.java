package com.simple.backend.Service;

import com.simple.backend.DTO.ShipmentDTO;
import com.simple.backend.DTO.response.ResponseShipmentDTO;

import java.util.List;

public interface ShipmentService {
    List<ResponseShipmentDTO> getAllShipments();
    ResponseShipmentDTO getShipmentById(Long id);
    ResponseShipmentDTO createShipment(ShipmentDTO shipmentDTO);
    ShipmentDTO updateShipment(Long id, ShipmentDTO shipmentDTO);
    void deleteShipment(Long id);
}
