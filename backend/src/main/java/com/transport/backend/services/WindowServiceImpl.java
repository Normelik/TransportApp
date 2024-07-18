package com.transport.backend.services;

import com.transport.backend.models.Window;
import com.transport.backend.repositories.WindowRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WindowServiceImpl implements WindowService {

    private final WindowRepository windowRepository;

    public WindowServiceImpl(WindowRepository windowRepository) {
        this.windowRepository = windowRepository;
    }

    @Override
    public List<Window> getAllWindows() {
        return windowRepository.findAll();
    }
}
