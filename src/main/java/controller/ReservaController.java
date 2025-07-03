package com.edu.reservas.controller;

import com.edu.reservas.entity.Asiento;
import com.edu.reservas.entity.Reserva;
import com.edu.reservas.service.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.edu.reservas.dto.ReservaRequest;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }


    @PostMapping
    public ResponseEntity<?> reservar(@RequestBody ReservaRequest reservaRequest) {
        try {
            Reserva reserva = reservaService.reservarAsiento(
                    reservaRequest.getNumero(),
                    reservaRequest.getCliente()
            );
            return ResponseEntity.ok(reserva);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/asientos")
    public List<Asiento> listarAsientos() {
        return reservaService.listarAsientos();
    }

    @GetMapping("/cliente")
    public List<Reserva> porCliente(@RequestParam String nombre) {
        return reservaService.reservasPorCliente(nombre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelarReserva(@PathVariable Long id) {
        try {
            reservaService.cancelarReserva(id);
            return ResponseEntity.ok("Reserva cancelada correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
