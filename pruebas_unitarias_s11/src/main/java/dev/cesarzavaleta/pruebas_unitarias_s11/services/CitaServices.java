package dev.cesarzavaleta.pruebas_unitarias_s11.services;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Cita;
import dev.cesarzavaleta.pruebas_unitarias_s11.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CitaServices {
    List<Cita> findAll();
    Cita findById(Long id);
    Cita save(Cita cita);
    void deleteById(Long id);
}
