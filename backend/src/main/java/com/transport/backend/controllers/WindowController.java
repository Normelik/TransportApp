package com.transport.backend.controllers;

import com.transport.backend.models.Window;
import com.transport.backend.services.WindowServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class WindowController {

    private final WindowServiceImpl windowServiceImpl;

    public WindowController(WindowServiceImpl windowServiceImpl) {
        this.windowServiceImpl = windowServiceImpl;
    }

    @GetMapping("/windows")
    public ResponseEntity<List<Window>> getAllWindows (){
        return ResponseEntity.ok(windowServiceImpl.getAllWindows());
    }

}
