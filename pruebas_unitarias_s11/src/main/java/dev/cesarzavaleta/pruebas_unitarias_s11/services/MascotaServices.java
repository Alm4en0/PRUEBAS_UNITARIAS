package dev.cesarzavaleta.pruebas_unitarias_s11.services;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Mascota;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface  MascotaServices {
    List<Mascota>findAll();
    Mascota findById(Long id);
    Mascota save(Mascota mascota);
    void deleteById(Long id);
}
