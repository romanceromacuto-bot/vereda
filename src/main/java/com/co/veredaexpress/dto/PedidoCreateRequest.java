package com.co.veredaexpress.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PedidoCreateRequest {
    
    @NotNull
    private Long usuarioId;
    
    @NotNull
    private Long servicioId;
    
    private LocalDateTime fechaEntrega;
    
    private String localizacionEntrega;
    
    private String localizacionRecoleccion;
}