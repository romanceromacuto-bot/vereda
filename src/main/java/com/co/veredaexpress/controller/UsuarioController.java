package com.co.veredaexpress.controller;

import com.co.veredaexpress.dto.LoginRequest;
import com.co.veredaexpress.dto.RegistroRequest;
import com.co.veredaexpress.dto.UsuarioResponse;
import com.co.veredaexpress.mapper.EntityMapper;
import com.co.veredaexpress.model.Usuario;
import com.co.veredaexpress.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
@Tag(name = "Usuarios", description = "API para gestión de usuarios")
public class UsuarioController {
    
    private final UsuarioService usuarioService;
    private final EntityMapper entityMapper;
    
    @PostMapping("/registro")
    @Operation(summary = "Registrar usuario", description = "Crea un nuevo usuario en el sistema")
    public ResponseEntity<?> registrar(@Valid @RequestBody RegistroRequest request) {
        try {
            Usuario usuario = usuarioService.registrar(request);
            return ResponseEntity.ok(entityMapper.toUsuarioResponse(usuario));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PostMapping("/login")
    @Operation(summary = "Iniciar sesión", description = "Autentica un usuario en el sistema")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        try {
            Usuario usuario = usuarioService.login(request);
            return ResponseEntity.ok(entityMapper.toUsuarioResponse(usuario));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
