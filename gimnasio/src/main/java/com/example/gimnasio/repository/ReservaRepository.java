package com.example.gimnasio.repository;
import com.example.gimnasio.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByUsuarioIdUsuario(Long idUsuario);
}