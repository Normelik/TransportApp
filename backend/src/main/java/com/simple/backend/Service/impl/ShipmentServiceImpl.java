package com.simple.backend.Service.impl;

import com.simple.backend.DTO.RequestShipmentDTO;
import com.simple.backend.DTO.response.ResponseShipmentDTO;
import com.simple.backend.Service.ShipmentService;
import com.simple.backend.mappers.ShipmentMapper;
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
    public List<ResponseShipmentDTO> getAllShipments() {
        return shipmentRepository.findAll()
                .stream()
                .map(shipmentMapper::toResponseDTO)
                .toList();
    }

    @Override
    public ResponseShipmentDTO getShipmentById(Long id) {
        ShipmentEntity shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Shipment not found with ID: " + id));
        return shipmentMapper.toResponseDTO(shipment);
    }

    @Override
    public ResponseShipmentDTO createShipment(RequestShipmentDTO requestShipmentDTO) {
        ShipmentEntity shipment = shipmentMapper.toEntity(requestShipmentDTO);
        try {
            ShipmentEntity savedShipment = shipmentRepository.save(shipment);
            return shipmentMapper.toResponseDTO(savedShipment);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public RequestShipmentDTO updateShipment(Long id, RequestShipmentDTO requestShipmentDTO) {
        ShipmentEntity existingShipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Shipment not found with ID: " + id));

        if(requestShipmentDTO.unloadingTime() != null) existingShipment.setUnloadingTime(requestShipmentDTO.unloadingTime());
        if(requestShipmentDTO.unloadingPlace() != null) existingShipment.setUnloadingPlace(requestShipmentDTO.unloadingPlace());
        if(requestShipmentDTO.plateNumber() != null) existingShipment.setPlateNumber(requestShipmentDTO.plateNumber());
        existingShipment.setBooked(requestShipmentDTO.isBooked());
        if(requestShipmentDTO.text() != null) existingShipment.setText(requestShipmentDTO.text());
        if(requestShipmentDTO.duration() != null) existingShipment.setDuration(requestShipmentDTO.duration());

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
