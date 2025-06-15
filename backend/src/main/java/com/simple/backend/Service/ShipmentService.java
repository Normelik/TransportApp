package com.simple.backend.Service;

import com.simple.backend.DTO.RequestShipmentDTO;
import com.simple.backend.DTO.response.ResponseShipmentDTO;

import java.util.List;

public interface ShipmentService {
    List<ResponseShipmentDTO> getAllShipments();
    ResponseShipmentDTO getShipmentById(Long id);
    ResponseShipmentDTO createShipment(RequestShipmentDTO requestShipmentDTO);
    RequestShipmentDTO updateShipment(Long id, RequestShipmentDTO requestShipmentDTO);
    void deleteShipment(Long id);
}
