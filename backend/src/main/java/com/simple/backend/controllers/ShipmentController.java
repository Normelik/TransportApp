package com.simple.backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simple.backend.DTO.ShipmentDTO;
import com.simple.backend.Service.ShipmentService;
import com.simple.backend.Service.impl.ShipmentServiceImpl;
import com.simple.backend.models.Shipment;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shipments")
public class ShipmentController {

    private final ShipmentServiceImpl shipmentServiceImpl;

    @Autowired
    public ShipmentController( ShipmentServiceImpl shipmentServiceImpl) {
        this.shipmentServiceImpl = shipmentServiceImpl;
    }

    @GetMapping("/{id}")
    public Shipment getShipment(@PathVariable("id") int id) {
        return shipmentServiceImpl.getShipment(id);
    }

    @GetMapping()
    public List<ShipmentDTO> getAllShipments() {
        return shipmentServiceImpl.getAllShipments();
    }

    @PostMapping()
    public int createShipment(@Valid @RequestBody ShipmentDTO newShipment) {
        return shipmentServiceImpl.addShipment(newShipment);
    }

    @DeleteMapping("/{id}")
    public String deleteShipment(@PathVariable int id) {
        return shipmentServiceImpl.deleteShipment(id);
    }

    @PutMapping("/{id}")
    public ShipmentDTO updateShipment(@PathVariable("id") int id,@Valid @RequestBody ShipmentDTO newShipment) {
        return shipmentServiceImpl.updateShipment(id,newShipment);
    }








}
