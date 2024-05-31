package dev.cesarzavaleta.pruebas_unitarias_s11.controllers;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Cliente;
import dev.cesarzavaleta.pruebas_unitarias_s11.model.Mascota;
import dev.cesarzavaleta.pruebas_unitarias_s11.services.ClienteServices;
import dev.cesarzavaleta.pruebas_unitarias_s11.services.MascotaServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteServices clienteServices;
    public ClienteController(ClienteServices clienteServices){
        this.clienteServices = clienteServices;
    }

    @GetMapping
    public List<Cliente> getAllClientes(){
        return clienteServices.findAll();
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id){
        return clienteServices.findById(id);}

}
