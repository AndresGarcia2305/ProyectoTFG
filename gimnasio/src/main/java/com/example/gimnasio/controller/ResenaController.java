package com.example.gimnasio.controller;
import com.example.gimnasio.model.Resena;
import com.example.gimnasio.repository.ResenaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ResenaController {

    private final ResenaRepository resenaRepository;

    public ResenaController(ResenaRepository resenaRepository) {
        this.resenaRepository = resenaRepository;
    }

    @GetMapping("/resenas")
    public String mostrarResenas(Model model) {
        model.addAttribute("resena", new Resena());
        model.addAttribute("resenas", resenaRepository.findAll());
        return "resenas";
    }

    @PostMapping("/resenas/guardar")
    public String guardarResena(@ModelAttribute Resena resena) {
        resenaRepository.save(resena);
        return "redirect:/resenas";
    }
}
