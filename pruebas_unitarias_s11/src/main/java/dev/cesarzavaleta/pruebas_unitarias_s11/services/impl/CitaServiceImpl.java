package dev.cesarzavaleta.pruebas_unitarias_s11.services.impl;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Cita;
import dev.cesarzavaleta.pruebas_unitarias_s11.model.Cliente;
import dev.cesarzavaleta.pruebas_unitarias_s11.repository.CitaRepository;
import dev.cesarzavaleta.pruebas_unitarias_s11.services.CitaServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaServiceImpl implements CitaServices {

    private final CitaRepository citaRepository;

    public CitaServiceImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Override
    public List<Cita> findAll() {
        return (List<Cita>) citaRepository.findAll();
    }


    @Override
    public Cita findById(Long id) {
        Optional<Cita> cita=citaRepository.findById(id);
        return cita.orElse(null);
    }

    @Override
    public Cita save(Cita cita) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
