package com.co.veredaexpress.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ServicioRequest {
    
    @NotBlank
    private String nombre;
    
    @NotNull
    @Positive
    private Double costo;
    
    @NotNull
    @Positive
    private Double capacidadMaximaKilos;
}