package com.simple.backend.Service.impl;

import com.simple.backend.Service.ShipmentService;
import com.simple.backend.models.Shipment;
import com.simple.backend.repositories.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private ShipmentRepository shipmentRepository;

    @Autowired
    public ShipmentServiceImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public Shipment getShipment(int id) {
        return shipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Shipment was not found"));
    }
}
