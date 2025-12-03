package com.co.veredaexpress.dto;

import com.co.veredaexpress.model.EstadoPedido;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PedidoUpdateRequest {
    
    private EstadoPedido estado;
    private LocalDateTime fechaEntrega;
}