package com.simple.backend.Service.impl;

import com.simple.backend.DTO.ShipmentDTO;
import com.simple.backend.Service.ShipmentService;
import com.simple.backend.ShipmentMapper;
import com.simple.backend.controllers.ShipmentController;
import com.simple.backend.entities.ShipmentEntity;
import com.simple.backend.models.Shipment;
import com.simple.backend.repositories.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;

    private final ShipmentMapper shipmentMapper;

    @Autowired
    public ShipmentServiceImpl(ShipmentRepository shipmentRepository, ShipmentMapper shipmentMapper) {
        this.shipmentRepository = shipmentRepository;
        this.shipmentMapper = shipmentMapper;
    }

    public ShipmentDTO getShipment(long id) {
        ShipmentEntity shipmentEntity = shipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Shipment entity with id " + id +" was not found in database"));
        return shipmentMapper.getShipmentDTOFromShipmentEntity(shipmentEntity);
    }

//    @Override
//    public List<ShipmentDTO> getAllShipments() {
//        List<ShipmentEntity> shipments = shipmentRepository.findAll();
//        return shipments.stream()
//                .map(ShipmentServiceImpl::getShipmentFromShipmentEntity)
//                .map(ShipmentServiceImpl::getShipmentDTOFromShipment)
//                .collect(Collectors.toList());
//    }
//
    @Override
    public ShipmentDTO addShipment(Shipment shipment) {
        ShipmentEntity shipmentToSave = shipmentMapper.getShipmentEntityFromShipment(shipment);
        // check if the shipment already exists in db
        ShipmentEntity savedShipment = shipmentRepository.save(shipmentToSave);
        return shipmentMapper.getShipmentDTOFromShipmentEntity(savedShipment);
    }

//    @Override
//    public String deleteShipment(int id) {
//        shipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Shipment with id " + id +" was not found"));
//        shipmentRepository.deleteById(id);
//        return "Shipment with id " + id +" was successfully deleted";
//    }

//    @Override
//    public ShipmentDTO updateShipment(int id,ShipmentDTO newShipment) {
//        Shipment updatedShipment = shipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Shipment with id " + id +" was not found"));
//        updatedShipment.setPlateNumber(newShipment.plateNumber());
//        updatedShipment.setUnloadingTime(newShipment.unloadingTime());
//        updatedShipment.setIsBooked(newShipment.isBooked());
//
//        shipmentRepository.save(updatedShipment);
//
//        return newShipment;
//    }
}
