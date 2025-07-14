package com.edu.reservas.repository;


import com.edu.reservas.entity.Asiento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AsientoRepository extends JpaRepository<Asiento, Long> {
    Optional<Asiento> findByNumero(String numero);
}

