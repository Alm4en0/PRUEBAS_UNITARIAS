package dev.cesarzavaleta.pruebas_unitarias_s11.controllers;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Cliente;
import dev.cesarzavaleta.pruebas_unitarias_s11.services.ClienteServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

class ClienteControllerTest {
    private MockMvc mockMvc;
    private ClienteServices clienteServices;

    @BeforeEach
    void setUp() {
        clienteServices = mock(ClienteServices.class);
        ClienteController clienteController = new ClienteController(clienteServices);
        mockMvc = MockMvcBuilders.standaloneSetup(clienteController).build();
    }

    @Test
    void getAllClientes() throws Exception {
        Cliente cliente1 = new Cliente(1L, "Juan", "Pérez", "Calle Mayor 123", "951234567", "juan.perez@email.com");
        Cliente cliente2 = new Cliente(2L, "María", "García", "Avenida del Sol 456", "963214578", "maria.garcia@email.com");
        List<Cliente> clientes = Arrays.asList(cliente1, cliente2);

        when(clienteServices.findAll()).thenReturn(clientes);

        mockMvc.perform(get("/clientes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].idCliente", is(1)))
                .andExpect(jsonPath("$[0].nombre", is("Juan")));
    }

    @Test
    void getClienteById() throws Exception {
        Cliente cliente = new Cliente(1L, "Juan", "Pérez", "Calle Mayor 123", "951234567", "juan.perez@email.com");

        when(clienteServices.findById(1L)).thenReturn(cliente);

        mockMvc.perform(get("/clientes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idCliente", is(1)))
                .andExpect(jsonPath("$.nombre", is("Juan")));
    }
}
