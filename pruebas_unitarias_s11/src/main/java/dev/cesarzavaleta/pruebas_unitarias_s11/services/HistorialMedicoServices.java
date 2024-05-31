package dev.cesarzavaleta.pruebas_unitarias_s11.services;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Cita;
import dev.cesarzavaleta.pruebas_unitarias_s11.model.HistorialMedico;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HistorialMedicoServices {
    List<HistorialMedico> findAll();
    HistorialMedico findById(Long id);
    HistorialMedico save(HistorialMedico historialMedico);
    void deleteById(Long id);
}
