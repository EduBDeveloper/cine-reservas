<<<<<<< HEAD
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

=======
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

>>>>>>> ea833c195e8072fb6038c54333ff5336eb37ee03
