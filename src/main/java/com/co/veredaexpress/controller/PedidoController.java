package com.co.veredaexpress.controller;

import com.co.veredaexpress.dto.*;
import com.co.veredaexpress.mapper.EntityMapper;
import com.co.veredaexpress.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pedidos")
@Tag(name = "Pedidos", description = "API para gestión de pedidos")
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;
    
    @Autowired
    private EntityMapper entityMapper;
    
    @PostMapping
    @Operation(summary = "Crear pedido", description = "Crea un nuevo pedido")
    public ResponseEntity<PedidoResponse> crearPedido(@Valid @RequestBody PedidoCreateRequest request) {
        var pedido = pedidoService.crearPedido(request);
        return ResponseEntity.ok(entityMapper.toPedidoResponse(pedido));
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar pedido", description = "Actualiza un pedido existente")
    public ResponseEntity<PedidoResponse> actualizarPedido(@PathVariable Long id, @Valid @RequestBody PedidoUpdateRequest request) {
        return pedidoService.actualizarPedido(id, request)
            .map(entityMapper::toPedidoResponse)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/usuario/{usuarioId}")
    @Operation(summary = "Obtener pedidos por usuario", description = "Obtiene todos los pedidos de un usuario")
    public ResponseEntity<List<PedidoResponse>> obtenerPedidosPorUsuario(@PathVariable Long usuarioId) {
        List<PedidoResponse> pedidos = pedidoService.obtenerPedidosPorUsuario(usuarioId)
            .stream().map(entityMapper::toPedidoResponse).collect(Collectors.toList());
        return ResponseEntity.ok(pedidos);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Obtener pedido", description = "Obtiene un pedido por su ID")
    public ResponseEntity<PedidoResponse> obtenerPedido(@PathVariable Long id) {
        return pedidoService.obtenerPedidoPorId(id)
            .map(entityMapper::toPedidoResponse)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}