package com.co.veredaexpress.service;

import com.co.veredaexpress.dto.PagoUpdateRequest;
import com.co.veredaexpress.model.Pago;
import com.co.veredaexpress.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PagoService {
    
    @Autowired
    private PagoRepository pagoRepository;
    
    public Optional<Pago> actualizarPago(Long id, PagoUpdateRequest request) {
        return pagoRepository.findById(id)
            .map(pago -> {
                if (request.getMonto() != null) {
                    pago.setMonto(request.getMonto());
                }
                if (request.getFechaPago() != null) {
                    pago.setFechaPago(request.getFechaPago());
                }
                if (request.getMetodoPago() != null) {
                    pago.setMetodoPago(request.getMetodoPago());
                }
                return pagoRepository.save(pago);
            });
    }
    
    public Optional<Pago> obtenerPagoPorId(Long id) {
        return pagoRepository.findById(id);
    }
}