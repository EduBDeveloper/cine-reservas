package com.edu.reservas.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCliente;
    private LocalDateTime fechaHora;

    @OneToOne
    private com.edu.reservas.entity.Asiento asiento;
}

