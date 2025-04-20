package com.simple.backend.mappers;

import com.simple.backend.DTO.ShipmentDTO;
import com.simple.backend.DTO.response.ResponseShipmentDTO;
import com.simple.backend.entities.ShipmentEntity;
import org.springframework.stereotype.Component;

@Component
public class ShipmentMapper {

    public ShipmentEntity toEntity(ShipmentDTO dto) {
        ShipmentEntity shipment = new ShipmentEntity();
        shipment.setUnloadingTime(dto.unloadingTime());
        shipment.setUnloadingPlace(dto.unloadingPlace());
        shipment.setPlateNumber(dto.plateNumber());
        shipment.setBooked(dto.isBooked());
        shipment.setText(dto.text());
        shipment.setDuration(dto.duration() != null ? dto.duration() : 0);
        return shipment;
    }

    public ShipmentDTO toDTO(ShipmentEntity shipment) {
        return new ShipmentDTO(
                shipment.getUnloadingTime(),
                shipment.getUnloadingPlace(),
                shipment.getPlateNumber(),
                shipment.isBooked(),
                shipment.getText(),
                shipment.getDuration()
        );
    }
    public ResponseShipmentDTO toResponseDTO(ShipmentEntity shipment) {
        return new ResponseShipmentDTO(
                shipment.getId(),
                shipment.getUnloadingTime(),
                shipment.getUnloadingPlace(),
                shipment.getPlateNumber(),
                shipment.isBooked(),
                shipment.getText(),
                shipment.getDuration()
        );
    }
}
