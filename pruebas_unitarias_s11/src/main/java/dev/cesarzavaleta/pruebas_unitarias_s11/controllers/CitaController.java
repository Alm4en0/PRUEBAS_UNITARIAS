package dev.cesarzavaleta.pruebas_unitarias_s11.controllers;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Cita;
import dev.cesarzavaleta.pruebas_unitarias_s11.services.CitaServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {

    private final CitaServices citaServices;

    public CitaController(CitaServices citaServices) {
        this.citaServices = citaServices;
    }

    @GetMapping
    public List<Cita> getAllCitas() {
        return citaServices.findAll();
    }

    @GetMapping("/{id}")
    public Cita getCitaById(@PathVariable Long id) {
        return citaServices.findById(id);
    }
}
