package com.co.veredaexpress.dto;

import com.co.veredaexpress.model.EstadoPedido;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PedidoResponse {
    
    private Long id;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaEntrega;
    private EstadoPedido estado;
    private EstadoPedido estadoAnterior;
    private Long usuarioId;
    private String usuarioUsername;
    private Long servicioId;
    private String servicioNombre;
    private Long pagoId;
    private String localizacionEntrega;
    private String localizacionRecoleccion;
}