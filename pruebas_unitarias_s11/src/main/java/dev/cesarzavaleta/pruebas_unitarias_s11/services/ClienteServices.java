package dev.cesarzavaleta.pruebas_unitarias_s11.services;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ClienteServices {
    List<Cliente> findAll();
    Cliente findById(Long id);
    Cliente save(Cliente cliente);
    void deleteById(Long id);
}
