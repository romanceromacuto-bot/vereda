package com.co.veredaexpress.controller;

import com.co.veredaexpress.dto.ServicioRequest;
import com.co.veredaexpress.dto.ServicioResponse;
import com.co.veredaexpress.mapper.EntityMapper;
import com.co.veredaexpress.service.ServicioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/servicios")
@Tag(name = "Servicios", description = "API para gestión de servicios")
public class ServicioController {
    
    @Autowired
    private ServicioService servicioService;
    
    @Autowired
    private EntityMapper entityMapper;
    
    @PostMapping
    @Operation(summary = "Crear servicio", description = "Crea un nuevo servicio")
    public ResponseEntity<ServicioResponse> crearServicio(@Valid @RequestBody ServicioRequest request) {
        var servicio = entityMapper.toServicio(request);
        var nuevoServicio = servicioService.crearServicio(servicio);
        return ResponseEntity.ok(entityMapper.toServicioResponse(nuevoServicio));
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar servicio", description = "Elimina un servicio existente")
    public ResponseEntity<Void> eliminarServicio(@PathVariable Long id) {
        servicioService.eliminarServicio(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping
    @Operation(summary = "Obtener todos los servicios", description = "Obtiene la lista de todos los servicios")
    public ResponseEntity<List<ServicioResponse>> obtenerTodosLosServicios() {
        List<ServicioResponse> servicios = servicioService.obtenerTodosLosServicios()
            .stream().map(entityMapper::toServicioResponse).collect(Collectors.toList());
        return ResponseEntity.ok(servicios);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Obtener servicio", description = "Obtiene un servicio por su ID")
    public ResponseEntity<ServicioResponse> obtenerServicio(@PathVariable Long id) {
        return servicioService.obtenerServicioPorId(id)
            .map(entityMapper::toServicioResponse)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}