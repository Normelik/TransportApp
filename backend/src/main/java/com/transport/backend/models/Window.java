package com.transport.backend.models;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "windows")
public class Window {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "plate_number",unique = true)
    private String plateNumber;

    @Column(name = "name_of_Currier")
    private String nameOfCarrier;

    @Column(name = "unloading_place")
    private String unloadingPlace;

    @Column(name = "unloading_time", unique = true)
    private LocalDateTime unloadingTime;
}
