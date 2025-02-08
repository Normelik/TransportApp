package com.simple.backend.Service;

import com.simple.backend.DTO.ShipmentDTO;
import com.simple.backend.models.Shipment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ShipmentService {

    ShipmentDTO getShipment(long id);
    
//    List<ShipmentDTO> getAllShipments();
//
    ShipmentDTO addShipment(Shipment shipment);

//    String deleteShipment(int id);

//    ShipmentDTO updateShipment(int id, ShipmentDTO newShipment);
}
