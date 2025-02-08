package com.simple.backend;

import com.simple.backend.DTO.ShipmentDTO;
import com.simple.backend.entities.ShipmentEntity;
import com.simple.backend.models.Shipment;
import org.springframework.stereotype.Component;

@Component
public class ShipmentMapper {

    public Shipment getShipmentFromShipmentDTO(ShipmentDTO shipmentDTO) {
        if (shipmentDTO == null) {
            return null;
        }
        return new Shipment(
                shipmentDTO.unloadingTime(),
                shipmentDTO.unloadingPlace(),
                shipmentDTO.plateNumber(),
                shipmentDTO.isBooked(),
                shipmentDTO.text(),
                shipmentDTO.duration()
        );
    }

    public ShipmentDTO getShipmentDTOFromShipment(Shipment shipment) {
        return new ShipmentDTO(
                shipment.getUnloadingTime(),
                shipment.getUnloadingPlace(),
                shipment.getPlateNumber(),
                shipment.getBooked(),
                shipment.getText(),
                shipment.getDuration()
        );
    }

    public ShipmentDTO getShipmentDTOFromShipmentEntity(ShipmentEntity shipmentEntity) {
        return new ShipmentDTO(
                shipmentEntity.getUnloadingTime(),
                shipmentEntity.getUnloadingPlace(),
                shipmentEntity.getPlateNumber(),
                shipmentEntity.getIsBooked(),
                shipmentEntity.getText(),
                shipmentEntity.getDuration()
        );
    }

    public ShipmentEntity getShipmentEntityFromShipment(Shipment shipment) {
        return new ShipmentEntity(
                shipment.getUnloadingTime(),
                shipment.getUnloadingPlace(),
                shipment.getPlateNumber(),
                shipment.getBooked(),
                shipment.getText(),
                shipment.getDuration()
        );
    }
}
