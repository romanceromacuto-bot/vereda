package com.co.veredaexpress.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "servicios")
public class Servicio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String nombre;
    
    @Column(nullable = false)
    private Double costo;
    
    @Column(name = "capacidad_maxima_kilos", nullable = false)
    private Double capacidadMaximaKilos;
}