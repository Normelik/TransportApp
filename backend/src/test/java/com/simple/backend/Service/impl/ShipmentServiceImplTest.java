package com.simple.backend.Service.impl;

import com.simple.backend.DTO.ShipmentDTO;
import com.simple.backend.models.Shipment;
import com.simple.backend.models.Warehouse;
import com.simple.backend.repositories.ShipmentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ShipmentServiceImplTest {

    @Mock
    private ShipmentRepository shipmentRepository;

    @InjectMocks
    private ShipmentServiceImpl shipmentService;

    @Test
    void testGetShipment_WhenShipmentExistsInDatabase_ThenReturnShipmentDTO() {
        int id = 1;

        Shipment shipment = new Shipment();
        shipment.setId(id);
        shipment.setPlateNumber("ABC123");
        shipment.setIsBooked(true);
        shipment.setUnloadingTime("2025-01-23T12:30:00");
        shipment.setUnloadingPlace("Prague");

        Mockito.when(shipmentRepository.findById(id)).thenReturn(Optional.of(shipment));

        ShipmentDTO result = shipmentService.getShipment(id);

        assertNotNull(result);
        assertEquals("ABC123", result.plateNumber());
        assertTrue(result.isBooked());
        assertEquals("2025-01-23T12:30:00", result.unloadingTime());
        assertEquals("Prague", result.unloadingPlace());

        verify(shipmentRepository, times(1)).findById(id);
    }


    @Test
    void testGetAllShipments_WhenAllShipmentsExistInDatabase_ThenReturnListWithAllShipmentDTOs() {
        Warehouse warehouse1 = new Warehouse();
        Warehouse warehouse2 = new Warehouse();
        Shipment shipment1 = new Shipment(1,"ABC123", true, "2025-01-23T12:30:00","Prague", warehouse1);
        Shipment shipment2 = new Shipment(1,"DEF456", false, "2000-01-23T06:00:00","London", warehouse2);

        List<Shipment> shipments = Arrays.asList(shipment1, shipment2);
        when(shipmentRepository.findAll()).thenReturn(shipments);

        List<ShipmentDTO> shipmentDTOs = shipmentService.getAllShipments();

        assertEquals(shipments.size(), shipmentDTOs.size());

        assertEquals("ABC123", shipmentDTOs.getFirst().plateNumber());
        assertEquals(true, shipmentDTOs.getFirst().isBooked());
        assertEquals("Prague", shipmentDTOs.getFirst().unloadingPlace());
        assertEquals("2025-01-23T12:30:00", shipmentDTOs.getFirst().unloadingTime());
        assertEquals(warehouse1, shipmentDTOs.getFirst().warehouse());

        assertEquals("DEF456", shipmentDTOs.get(1).plateNumber());
        assertEquals(false, shipmentDTOs.get(1).isBooked());
        assertEquals("London", shipmentDTOs.get(1).unloadingPlace());
        assertEquals("2000-01-23T06:00:00", shipmentDTOs.get(1).unloadingTime());
        assertEquals(warehouse2, shipmentDTOs.get(1).warehouse());
    }

    @Test
    void testAddShipment_WhenNewShipmentWasSuccessfullySavedToDatabase_ThenReturnNewShipmentId() {
        Shipment savedShipment = new Shipment(0,"ABC123", true, "2025-01-23T12:30:00","Prague", null);

        ShipmentDTO shipmentDTO = new ShipmentDTO("ABC123", true, "2025-01-23T12:30:00","Prague", null);
        when(shipmentRepository.save(any(Shipment.class))).thenReturn(savedShipment);

        int shipmentId = shipmentService.addShipment(shipmentDTO);
        assertEquals(0, shipmentId);

    }

    @Test
    void testDeleteShipment_WhenTheShipmentWasSuccessfullyDeletedFromDatabase_ThenReturnDeletedMessageWithShipmentId() {
        int shipmentId = 1;
        Shipment shipment = new Shipment();
        shipment.setId(shipmentId);

        when(shipmentRepository.findById(shipmentId)).thenReturn(Optional.of(shipment));

        String result = shipmentService.deleteShipment(shipmentId);

        assertEquals("Shipment with id 1 was successfully deleted", result);
        verify(shipmentRepository).deleteById(shipmentId);

    }

    @Test
    void testUpdateShipment_WhenTheShipmentWasSuccessfullyUpdatedFromDatabase_ThenReturnShipmentDTO() {
        int shipmentId = 1;
        Shipment existingShipment = new Shipment(0,"ABC123", true, "2025-01-23T12:30:00","Prague", null);
        Warehouse warehouse = new Warehouse();
        ShipmentDTO updatedShipmentDTO = new ShipmentDTO("NEW123", false, "New unloading place","1414-01-23T05:00:00", warehouse);

        when(shipmentRepository.findById(shipmentId)).thenReturn(Optional.of(existingShipment));
        when(shipmentRepository.save(any(Shipment.class))).thenReturn(existingShipment);

        ShipmentDTO result = shipmentService.updateShipment(shipmentId, updatedShipmentDTO);

        // Assert: Verify updated values and repository calls
        assertEquals("NEW123", existingShipment.getPlateNumber());
        assertEquals(false, existingShipment.getIsBooked());
        assertEquals("1414-01-23T05:00:00",existingShipment.getUnloadingTime());
        assertEquals("New unloading place", existingShipment.getUnloadingPlace());
        assertEquals(null, existingShipment.getWarehouse());

        assertEquals(updatedShipmentDTO, result);

        verify(shipmentRepository).findById(shipmentId);
        verify(shipmentRepository).save(existingShipment);
    }
}