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
        return shipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Shipment with id " + id +" was not found"));
    }

    @Override
    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    @Override
    public int addShipment(ShipmentDTO shipmentDTO) {
        Shipment newShipment = new Shipment();
        newShipment.setPlateNumber(shipmentDTO.plateNumber());
        newShipment.setUnloadingTime(shipmentDTO.unloadingTime());
        newShipment.setIsBooked(shipmentDTO.isBooked());

        shipmentRepository.save(newShipment);

        return newShipment.getId();
    }

    @Override
    public String deleteShipment(int id) {
        shipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Shipment with id " + id +" was not found"));
        shipmentRepository.deleteById(id);
        return "Shipment with id " + id +" was successfully deleted";
    }

    @Override
    public ShipmentDTO updateShipment(int id,ShipmentDTO newShipment) {
        Shipment updatedShipment = shipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Shipment with id " + id +" was not found"));
        updatedShipment.setPlateNumber(newShipment.plateNumber());
        updatedShipment.setUnloadingTime(newShipment.unloadingTime());
        updatedShipment.setIsBooked(newShipment.isBooked());

        shipmentRepository.save(updatedShipment);

        return newShipment;
    }
}
