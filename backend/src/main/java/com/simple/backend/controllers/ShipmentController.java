package com.simple.backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simple.backend.DTO.ShipmentDTO;
import com.simple.backend.Service.impl.ShipmentServiceImpl;
import com.simple.backend.ShipmentMapper;
import com.simple.backend.models.Shipment;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {

    private final ShipmentServiceImpl shipmentServiceImpl;

    private final ShipmentMapper shipmentMapper;

    @Autowired
    public ShipmentController(ShipmentServiceImpl shipmentServiceImpl, ShipmentMapper shipmentMapper, ShipmentMapper shipmentMapper1) {
        this.shipmentServiceImpl = shipmentServiceImpl;
        this.shipmentMapper = shipmentMapper1;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShipmentDTO> getShipment(@PathVariable("id") long id) {
        return new ResponseEntity<>(shipmentServiceImpl.getShipment(id), HttpStatus.OK);
    }

//    @GetMapping()
//    public ResponseEntity<List<ShipmentDTO>> getAllShipments() {
//        return new ResponseEntity<>(shipmentServiceImpl.getAllShipments(),HttpStatus.OK);
//    }
//
    @PostMapping()
    public ResponseEntity<ShipmentDTO> createShipment(@Valid @RequestBody ShipmentDTO shipmentDTO) {
        Shipment newShipment = shipmentMapper.getShipmentFromShipmentDTO(shipmentDTO);
        System.out.println(newShipment);
        return new ResponseEntity<>(shipmentServiceImpl.addShipment(newShipment),HttpStatus.CREATED);
    }

//    @DeleteMapping("/{id}")
//    public String deleteShipment(@PathVariable int id) {
//        return shipmentServiceImpl.deleteShipment(id);
//    }
//
//    @PutMapping("/{id}")
//    public ShipmentDTO updateShipment(@PathVariable("id") int id,@Valid @RequestBody ShipmentDTO newShipment) {
//        return shipmentServiceImpl.updateShipment(id,newShipment);
//    }








}
