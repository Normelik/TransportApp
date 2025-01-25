package com.simple.backend.Service.impl;

import com.simple.backend.DTO.ShipmentDTO;
import com.simple.backend.Service.ShipmentService;
import com.simple.backend.models.Shipment;
import com.simple.backend.repositories.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private ShipmentRepository shipmentRepository;

    @Autowired
    public ShipmentServiceImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public ShipmentDTO getShipment(int id) {
        Shipment shipment = shipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Shipment with id " + id +" was not found"));
        return new ShipmentDTO(
                shipment.getPlateNumber(),
                shipment.getIsBooked(),
                shipment.getUnloadingPlace(),
                shipment.getUnloadingTime()
        );
    }

    @Override
    public List<ShipmentDTO> getAllShipments() {
        List<Shipment> shipments = shipmentRepository.findAll();
        return shipments.stream()
                .map(shipment -> new ShipmentDTO(
                        shipment.getPlateNumber(),
                        shipment.getIsBooked(),
                        shipment.getUnloadingPlace(),
                        shipment.getUnloadingTime()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public int addShipment(ShipmentDTO shipmentDTO) {
        Shipment newShipment = new Shipment();
        newShipment.setPlateNumber(shipmentDTO.plateNumber());
        newShipment.setUnloadingTime(shipmentDTO.unloadingTime());
        newShipment.setUnloadingPlace(shipmentDTO.unloadingPlace());
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
        updatedShipment.setUnloadingPlace(newShipment.unloadingPlace());

        shipmentRepository.save(updatedShipment);

        return newShipment;
    }
}
