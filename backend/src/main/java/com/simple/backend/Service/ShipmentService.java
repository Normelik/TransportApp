package com.simple.backend.Service;

import com.simple.backend.DTO.ShipmentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShipmentService {
    ShipmentDTO getShipment(int id);
    
    List<ShipmentDTO> getAllShipments();

    int addShipment(ShipmentDTO shipment);

    String deleteShipment(int id);

    ShipmentDTO updateShipment(int id, ShipmentDTO newShipment);
}
