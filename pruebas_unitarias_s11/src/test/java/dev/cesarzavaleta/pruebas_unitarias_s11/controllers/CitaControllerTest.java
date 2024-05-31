package dev.cesarzavaleta.pruebas_unitarias_s11.controllers;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Cita;
import dev.cesarzavaleta.pruebas_unitarias_s11.model.Mascota;
import dev.cesarzavaleta.pruebas_unitarias_s11.services.CitaServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

class CitaControllerTest {
    private MockMvc mockMvc;
    private CitaServices citaServices;

    @BeforeEach
    void setUp() {
        citaServices = mock(CitaServices.class);
        CitaController citaController = new CitaController(citaServices);
        mockMvc = MockMvcBuilders.standaloneSetup(citaController).build();
    }

    @Test
    void getAllCitas() throws Exception {
        Mascota mascota1 = new Mascota();
        mascota1.setIdMascota(1L);
        mascota1.setNombre("Toby");

        Mascota mascota2 = new Mascota();
        mascota2.setIdMascota(2L);
        mascota2.setNombre("Luna");

        Cita cita1 = new Cita(1L, LocalDateTime.of(2024, 5, 25, 10, 0), "Revisión Anual", mascota1);
        Cita cita2 = new Cita(2L, LocalDateTime.of(2024, 6, 15, 15, 30), "Vacunación", mascota2);
        List<Cita> citas = Arrays.asList(cita1, cita2);

        when(citaServices.findAll()).thenReturn(citas);

        mockMvc.perform(get("/citas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].idCita", is(1)))
                .andExpect(jsonPath("$[0].motivoConsulta", is("Revisión Anual")))
                .andExpect(jsonPath("$[0].mascota.nombre", is("Toby")));
    }

    @Test
    void getCitaById() throws Exception {
        Mascota mascota = new Mascota();
        mascota.setIdMascota(1L);
        mascota.setNombre("Toby");

        Cita cita = new Cita(1L, LocalDateTime.of(2024, 5, 25, 10, 0), "Revisión Anual", mascota);

        when(citaServices.findById(1L)).thenReturn(cita);

        mockMvc.perform(get("/citas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idCita", is(1)))
                .andExpect(jsonPath("$.motivoConsulta", is("Revisión Anual")))
                .andExpect(jsonPath("$.mascota.nombre", is("Toby")));
    }
}
