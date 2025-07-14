<<<<<<< HEAD
package com.edu.reservas.repository;

import com.edu.reservas.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByNombreCliente(String nombreCliente);
}
=======
package com.edu.reservas.repository;

import com.edu.reservas.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByNombreCliente(String nombreCliente);
}
>>>>>>> ea833c195e8072fb6038c54333ff5336eb37ee03
