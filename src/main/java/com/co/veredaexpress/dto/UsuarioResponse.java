package com.co.veredaexpress.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UsuarioResponse {
    
    private Long id;
    private String username;
    private String email;
    private String fisicaladdress;
    private LocalDateTime fechaCreacion;
    private LocalDateTime ultimoAcceso;
    private Boolean activo;
}