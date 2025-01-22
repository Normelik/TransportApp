package com.simple.backend.Service.impl;

import com.simple.backend.DTO.ShipmentDTO;
import com.simple.backend.Service.ShipmentService;
import com.simple.backend.models.Shipment;
import com.simple.backend.repositories.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    @Override
    public int addShipment(ShipmentDTO shipment) {
        Shipment newShipment = new Shipment();
        newShipment.setPlateNumber(shipment.plateNumber());
        newShipment.setTime(shipment.time());
        newShipment.setIsBooked(shipment.isBooked());

        shipmentRepository.save(newShipment);

        return newShipment.getId();
    }

    @Override
    public String deleteShipment(int id) {
        shipmentRepository.deleteById(id);
        return "Shipment was successfully deleted";
    }
}
