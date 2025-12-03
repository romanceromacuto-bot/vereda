package com.co.veredaexpress.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pagos")
public class Pago {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Double monto;
    
    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago;
    
    @Column(length = 50)
    private String metodoPago;
    
    @OneToOne(mappedBy = "pago")
    private Pedido pedido;
}