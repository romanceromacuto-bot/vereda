package com.co.veredaexpress.dto;

import jakarta.validation.constraints.Positive;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PagoUpdateRequest {
    
    @Positive
    private Double monto;
    
    private LocalDateTime fechaPago;
    
    private String metodoPago;
}