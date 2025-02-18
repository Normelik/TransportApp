package com.simple.backend.Service.impl;

import com.simple.backend.DTO.ShipmentDTO;
import com.simple.backend.Service.ShipmentService;
import com.simple.backend.ShipmentMapper;
import com.simple.backend.entities.ShipmentEntity;
import com.simple.backend.repositories.ShipmentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final ShipmentMapper shipmentMapper;

    @Override
    public List<ShipmentDTO> getAllShipments() {
        return shipmentRepository.findAll()
                .stream()
                .map(shipmentMapper::toDTO)
                .toList();
    }

    @Override
    public ShipmentDTO getShipmentById(Long id) {
        ShipmentEntity shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Shipment not found with ID: " + id));
        return shipmentMapper.toDTO(shipment);
    }

    @Override
    public ShipmentDTO createShipment(ShipmentDTO shipmentDTO) {
        ShipmentEntity shipment = shipmentMapper.toEntity(shipmentDTO);
        try {
            ShipmentEntity savedShipment = shipmentRepository.save(shipment);
            return shipmentMapper.toDTO(savedShipment);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public ShipmentDTO updateShipment(Long id, ShipmentDTO shipmentDTO) {
        ShipmentEntity existingShipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Shipment not found with ID: " + id));

        if(shipmentDTO.unloadingTime() != null) existingShipment.setUnloadingTime(shipmentDTO.unloadingTime());
        if(shipmentDTO.unloadingPlace() != null) existingShipment.setUnloadingPlace(shipmentDTO.unloadingPlace());
        if(shipmentDTO.plateNumber() != null) existingShipment.setPlateNumber(shipmentDTO.plateNumber());
        existingShipment.setBooked(shipmentDTO.isBooked());
        if(shipmentDTO.text() != null) existingShipment.setText(shipmentDTO.text());
        if(shipmentDTO.duration() != null) existingShipment.setDuration(shipmentDTO.duration());

        ShipmentEntity updatedShipment = shipmentRepository.save(existingShipment);
        return shipmentMapper.toDTO(updatedShipment);
    }

    @Override
    public void deleteShipment(Long id) {
        ShipmentEntity shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Shipment not found with ID: " + id));
        shipmentRepository.delete(shipment);
    }
}
