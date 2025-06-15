package com.simple.backend.mappers;

import com.simple.backend.DTO.RequestShipmentDTO;
import com.simple.backend.DTO.response.ResponseShipmentDTO;
import com.simple.backend.entities.ShipmentEntity;
import org.springframework.stereotype.Component;

@Component
public class ShipmentMapper {

    public ShipmentEntity toEntity(RequestShipmentDTO dto) {
        ShipmentEntity shipmentEntity = new ShipmentEntity();
        shipmentEntity.setUnloadingTime(dto.unloadingTime());
        shipmentEntity.setUnloadingPlace(dto.unloadingPlace());
        shipmentEntity.setPlateNumber(dto.plateNumber());
        shipmentEntity.setBooked(dto.isBooked());
        shipmentEntity.setText(dto.text());
        shipmentEntity.setDuration(dto.duration() != null ? dto.duration() : 0);
        return shipmentEntity;
    }

    public RequestShipmentDTO toDTO(ShipmentEntity shipment) {
        return new RequestShipmentDTO(
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
