package com.simple.backend.controllers;

import com.simple.backend.DTO.ShipmentDTO;
import com.simple.backend.DTO.response.ResponseShipmentDTO;
import com.simple.backend.Service.ShipmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
@RequiredArgsConstructor
public class ShipmentController {

    private final ShipmentService shipmentService;

    @GetMapping
    public List<ResponseShipmentDTO> getAllShipments() {
        return shipmentService.getAllShipments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseShipmentDTO> getShipmentById(@PathVariable Long id) {
        return ResponseEntity.ok(shipmentService.getShipmentById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseShipmentDTO> createShipment(@Valid @RequestBody ShipmentDTO shipmentDTO) {
        return ResponseEntity.ok(shipmentService.createShipment(shipmentDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShipmentDTO> updateShipment(@PathVariable Long id, @RequestBody ShipmentDTO shipmentDTO) {
        return ResponseEntity.ok(shipmentService.updateShipment(id, shipmentDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShipment(@PathVariable Long id) {
        shipmentService.deleteShipment(id);
        return ResponseEntity.noContent().build();
    }
}
