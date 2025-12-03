package com.co.veredaexpress.dto;

import lombok.Data;

@Data
public class ServicioResponse {
    
    private Long id;
    private String nombre;
    private Double costo;
    private Double capacidadMaximaKilos;
}