package dev.cesarzavaleta.pruebas_unitarias_s11.controllers;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.HistorialMedico;
import dev.cesarzavaleta.pruebas_unitarias_s11.services.HistorialMedicoServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/historialesMedicos")
public class HistorialMedicoController {

    private final HistorialMedicoServices historialMedicoServices;

    public HistorialMedicoController(HistorialMedicoServices historialMedicoServices) {
        this.historialMedicoServices = historialMedicoServices;
    }

    @GetMapping
    public List<HistorialMedico> getAllHistorialesMedicos() {
        return historialMedicoServices.findAll();
    }

    @GetMapping("/{id}")
    public HistorialMedico getHistorialMedicoById(@PathVariable Long id) {
        return historialMedicoServices.findById(id);
    }
}
