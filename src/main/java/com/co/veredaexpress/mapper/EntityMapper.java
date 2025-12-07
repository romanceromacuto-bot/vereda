package com.co.veredaexpress.mapper;

import com.co.veredaexpress.dto.*;
import com.co.veredaexpress.model.*;
import org.springframework.stereotype.Component;

@Component
public class EntityMapper {
    
    public UsuarioResponse toUsuarioResponse(Usuario usuario) {
        UsuarioResponse response = new UsuarioResponse();
        response.setId(usuario.getId());
        response.setUsername(usuario.getUsername());
        response.setEmail(usuario.getEmail());
        response.setFisicaladdress(usuario.getFisicaladdress());
        response.setFechaCreacion(usuario.getFechaCreacion());
        response.setUltimoAcceso(usuario.getUltimoAcceso());
        response.setActivo(usuario.getActivo());
        return response;
    }
    
    public PedidoResponse toPedidoResponse(Pedido pedido) {
        PedidoResponse response = new PedidoResponse();
        response.setId(pedido.getId());
        response.setFechaCreacion(pedido.getFechaCreacion());
        response.setFechaEntrega(pedido.getFechaEntrega());
        response.setEstado(pedido.getEstado());
        response.setEstadoAnterior(pedido.getEstadoAnterior());
        response.setUsuarioId(pedido.getUsuario().getId());
        response.setUsuarioUsername(pedido.getUsuario().getUsername());
        response.setServicioId(pedido.getServicio().getId());
        response.setServicioNombre(pedido.getServicio().getNombre());
        if (pedido.getPago() != null) {
            response.setPagoId(pedido.getPago().getId());
        }
        response.setLocalizacionEntrega(pedido.getLocalizacionEntrega());
        response.setLocalizacionRecoleccion(pedido.getLocalizacionRecoleccion());
        return response;
    }
    
    public ServicioResponse toServicioResponse(Servicio servicio) {
        ServicioResponse response = new ServicioResponse();
        response.setId(servicio.getId());
        response.setNombre(servicio.getNombre());
        response.setCosto(servicio.getCosto());
        response.setCapacidadMaximaKilos(servicio.getCapacidadMaximaKilos());
        return response;
    }
    
    public Servicio toServicio(ServicioRequest request) {
        Servicio servicio = new Servicio();
        servicio.setNombre(request.getNombre());
        servicio.setCosto(request.getCosto());
        servicio.setCapacidadMaximaKilos(request.getCapacidadMaximaKilos());
        return servicio;
    }
    
    public PagoResponse toPagoResponse(Pago pago) {
        PagoResponse response = new PagoResponse();
        response.setId(pago.getId());
        response.setMonto(pago.getMonto());
        response.setFechaPago(pago.getFechaPago());
        response.setMetodoPago(pago.getMetodoPago());
        if (pago.getPedido() != null) {
            response.setPedidoId(pago.getPedido().getId());
        }
        return response;
    }
}