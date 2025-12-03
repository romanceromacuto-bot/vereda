package com.co.veredaexpress.service;

import com.co.veredaexpress.dto.PedidoCreateRequest;
import com.co.veredaexpress.dto.PedidoUpdateRequest;
import com.co.veredaexpress.model.Pedido;
import com.co.veredaexpress.repository.PedidoRepository;
import com.co.veredaexpress.repository.UsuarioRepository;
import com.co.veredaexpress.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private ServicioRepository servicioRepository;
    
    public Pedido crearPedido(PedidoCreateRequest request) {
        var usuario = usuarioRepository.findById(request.getUsuarioId())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        var servicio = servicioRepository.findById(request.getServicioId())
            .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));
        
        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);
        pedido.setServicio(servicio);
        pedido.setFechaEntrega(request.getFechaEntrega());
        
        return pedidoRepository.save(pedido);
    }
    
    public Optional<Pedido> actualizarPedido(Long id, PedidoUpdateRequest request) {
        return pedidoRepository.findById(id)
            .map(pedido -> {
                if (request.getEstado() != null && !request.getEstado().equals(pedido.getEstado())) {
                    pedido.setEstadoAnterior(pedido.getEstado());
                    pedido.setEstado(request.getEstado());
                }
                if (request.getFechaEntrega() != null) {
                    pedido.setFechaEntrega(request.getFechaEntrega());
                }
                return pedidoRepository.save(pedido);
            });
    }
    
    public List<Pedido> obtenerPedidosPorUsuario(Long usuarioId) {
        return pedidoRepository.findByUsuarioId(usuarioId);
    }
    
    public Optional<Pedido> obtenerPedidoPorId(Long id) {
        return pedidoRepository.findById(id);
    }
}