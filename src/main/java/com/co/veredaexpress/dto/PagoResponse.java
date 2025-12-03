package com.co.veredaexpress.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PagoResponse {
    
    private Long id;
    private Double monto;
    private LocalDateTime fechaPago;
    private String metodoPago;
    private Long pedidoId;
}