package com.example.gimnasio.service;

import com.example.gimnasio.model.Reserva;
import com.example.gimnasio.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Reserva guardarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public List<Reserva> listarReservasUsuario(Long idUsuario) {
        return reservaRepository.findByUsuarioIdUsuario(idUsuario);
    }

    public List<Reserva> listarTodas() {
        return reservaRepository.findAll();
    }

    public void cancelarReserva(Long idReserva) {
        reservaRepository.deleteById(idReserva);
    }
}