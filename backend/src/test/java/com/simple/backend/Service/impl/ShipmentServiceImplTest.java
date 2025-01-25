//package com.simple.backend.Service.impl;
//
//import com.simple.backend.DTO.ShipmentDTO;
//import com.simple.backend.models.Shipment;
//import com.simple.backend.repositories.ShipmentRepository;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
//class ShipmentServiceImplTest {
//
//    @Mock
//    private ShipmentRepository shipmentRepository;
//
//    @InjectMocks
//    private ShipmentServiceImpl shipmentService;
//
//
//    @Test
//    void shouldReturnShipmentDTOIfTheShipmentExistsInDatabase() {
//        int id = 1;
//        Shipment shipment = new Shipment();
//        shipment.setId(id);
//        shipment.setPlateNumber("ABC123");
//        shipment.setIsBooked(true);
//        shipment.setUnloadingTime("2025-01-23T12:30:00");
//
//        Mockito.when(shipmentRepository.findById(id)).thenReturn(Optional.of(shipment));
//
//        ShipmentDTO expectedResult = shipmentService.getShipment(id);
//
////        assertNotNull(expectedResult);
////        assertEquals("ABC123", result.getPlateNumber());
////        assertTrue(result.getIsBooked());
////        assertEquals("2025-01-23T12:30:00", result.getUnloadingTime());
////
////        verify(shipmentRepository, times(1)).findById((long) shipmentId);
//    }
//
//    @Test
//    void getAllShipments() {
//    }
//
//    @Test
//    void addShipment() {
//    }
//
//    @Test
//    void deleteShipment() {
//    }
//
//    @Test
//    void updateShipment() {
//    }
//}