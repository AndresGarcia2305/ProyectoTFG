package com.example.gimnasio.controller;

import com.example.gimnasio.model.Reserva;
import com.example.gimnasio.service.ReservaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public String mostrarReservas(Model model) {
        model.addAttribute("reservas", reservaService.listarTodas());
        model.addAttribute("reserva", new Reserva());
        return "reservas";
    }

    @PostMapping("/guardar")
    public String guardarReserva(@ModelAttribute Reserva reserva) {
        reservaService.guardarReserva(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/cancelar/{id}")
    public String cancelarReserva(@PathVariable Long id) {
        reservaService.cancelarReserva(id);
        return "redirect:/reservas";
    }
}
