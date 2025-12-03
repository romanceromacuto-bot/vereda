package com.co.veredaexpress.service;

import com.co.veredaexpress.model.Servicio;
import com.co.veredaexpress.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioService {
    
    @Autowired
    private ServicioRepository servicioRepository;
    
    public Servicio crearServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }
    
    public void eliminarServicio(Long id) {
        servicioRepository.deleteById(id);
    }
    
    public List<Servicio> obtenerTodosLosServicios() {
        return servicioRepository.findAll();
    }
    
    public Optional<Servicio> obtenerServicioPorId(Long id) {
        return servicioRepository.findById(id);
    }
}