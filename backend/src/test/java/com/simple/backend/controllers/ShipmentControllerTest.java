package com.simple.backend.controllers;

import com.simple.backend.Service.ShipmentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShipmentControllerTest {

    @Mock
    private ShipmentService shipmentService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetShipment_WhenShipmentExistsInDatabase_ThenReturnShipmentDTO() throws Exception {
//        mockMvc.perform(get("/api/hello")) // Simulate GET request
//                .andExpect(status().isOk()) // Expect HTTP 200 OK
//                .andExpect(content().string("Hello, World!"));
    }

}