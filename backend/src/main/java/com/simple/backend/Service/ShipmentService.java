package com.simple.backend.Service;

import com.simple.backend.DTO.ShipmentDTO;
import com.simple.backend.models.Shipment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShipmentService {
    Shipment getShipment(int id);
    List<Shipment> getAllShipments();

    int addShipment(ShipmentDTO shipment);

    String deleteShipment(int id);

    ShipmentDTO updateShipment(int id, ShipmentDTO newShipment);
}
