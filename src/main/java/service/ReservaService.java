package com.edu.reservas.service;


import com.edu.reservas.entity.Asiento;
import com.edu.reservas.entity.Reserva;
import com.edu.reservas.repository.AsientoRepository;
import com.edu.reservas.repository.ReservaRepository;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservaService {

    private final AsientoRepository asientoRepo;
    private final ReservaRepository reservaRepo;

    public ReservaService(AsientoRepository asientoRepo, ReservaRepository reservaRepo) {
        this.asientoRepo = asientoRepo;
        this.reservaRepo = reservaRepo;
    }

    public Reserva reservarAsiento(String numero, String nombreCliente) {
        Asiento asiento = asientoRepo.findByNumero(numero)
                .orElseThrow(() -> new RuntimeException("Asiento no existe"));

        if (asiento.isReservado()) {
            throw new RuntimeException("Asiento ya está reservado");
        }

        asiento.setReservado(true);
        asientoRepo.save(asiento);

        Reserva reserva = new Reserva();
        reserva.setNombreCliente(nombreCliente);
        reserva.setFechaHora(LocalDateTime.now());
        reserva.setAsiento(asiento);
        return reservaRepo.save(reserva);
    }

    public List<Asiento> listarAsientos() {
        return asientoRepo.findAll();
    }

    public List<Reserva> reservasPorCliente(String nombreCliente) {
        return reservaRepo.findByNombreCliente(nombreCliente);
    }
    public void cancelarReserva(Long reservaId) {
        Reserva reserva = reservaRepo.findById(reservaId)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        Asiento asiento = reserva.getAsiento();
        asiento.setReservado(false);
        asientoRepo.save(asiento);

        reservaRepo.delete(reserva); // o marcar como cancelada si tenés campo status
    }

}

