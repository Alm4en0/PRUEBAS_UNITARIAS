package dev.cesarzavaleta.pruebas_unitarias_s11.services.impl;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Cliente;
import dev.cesarzavaleta.pruebas_unitarias_s11.model.Mascota;
import dev.cesarzavaleta.pruebas_unitarias_s11.repository.ClienteRepository;
import dev.cesarzavaleta.pruebas_unitarias_s11.repository.MascotaRepository;
import dev.cesarzavaleta.pruebas_unitarias_s11.services.ClienteServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteServices {
    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        Optional<Cliente> cliente=clienteRepository.findById(id);
        return cliente.orElse(null);
    }


    @Override
    public Cliente save(Cliente cliente) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
