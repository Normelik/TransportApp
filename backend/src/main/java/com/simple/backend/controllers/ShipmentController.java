package com.simple.backend.controllers;

import com.simple.backend.Service.ShipmentService;
import com.simple.backend.Service.impl.ShipmentServiceImpl;
import com.simple.backend.models.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Shipment getShipment( @PathVariable int id) {
        return shipmentServiceImpl.getShipment(id);
    }

    @GetMapping()
    public List<Shipment> getAllShipments() {
        return shipmentServiceImpl.getAllShipments();
    }








}
