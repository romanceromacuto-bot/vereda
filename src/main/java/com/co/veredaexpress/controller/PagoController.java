package com.co.veredaexpress.controller;

import com.co.veredaexpress.dto.PagoResponse;
import com.co.veredaexpress.dto.PagoUpdateRequest;
import com.co.veredaexpress.mapper.EntityMapper;
import com.co.veredaexpress.service.PagoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagos")
@Tag(name = "Pagos", description = "API para gestión de pagos")
public class PagoController {
    
    @Autowired
    private PagoService pagoService;
    
    @Autowired
    private EntityMapper entityMapper;
    
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar pago", description = "Actualiza un pago existente")
    public ResponseEntity<PagoResponse> actualizarPago(@PathVariable Long id, @Valid @RequestBody PagoUpdateRequest request) {
        return pagoService.actualizarPago(id, request)
            .map(entityMapper::toPagoResponse)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Obtener pago", description = "Obtiene un pago por su ID")
    public ResponseEntity<PagoResponse> obtenerPago(@PathVariable Long id) {
        return pagoService.obtenerPagoPorId(id)
            .map(entityMapper::toPagoResponse)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}