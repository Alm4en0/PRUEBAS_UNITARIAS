package dev.cesarzavaleta.pruebas_unitarias_s11.controllers;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.HistorialMedico;
import dev.cesarzavaleta.pruebas_unitarias_s11.services.HistorialMedicoServices;
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

class HistorialMedicoControllerTest {
    private MockMvc mockMvc;
    private HistorialMedicoServices historialMedicoServices;

    @BeforeEach
    void setUp() {
        historialMedicoServices = mock(HistorialMedicoServices.class);
        HistorialMedicoController historialMedicoController = new HistorialMedicoController(historialMedicoServices);
        mockMvc = MockMvcBuilders.standaloneSetup(historialMedicoController).build();
    }

    @Test
    void getAllHistorialesMedicos() throws Exception {
        HistorialMedico historial1 = new HistorialMedico(1L, null, "Diagnóstico 1", "Tratamiento 1", "Observaciones 1");
        HistorialMedico historial2 = new HistorialMedico(2L, null, "Diagnóstico 2", "Tratamiento 2", "Observaciones 2");
        List<HistorialMedico> historiales = Arrays.asList(historial1, historial2);

        when(historialMedicoServices.findAll()).thenReturn(historiales);

        mockMvc.perform(get("/historialesMedicos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].idHistorial", is(1)))
                .andExpect(jsonPath("$[0].diagnostico", is("Diagnóstico 1")))
                .andExpect(jsonPath("$[0].tratamiento", is("Tratamiento 1")))
                .andExpect(jsonPath("$[0].observaciones", is("Observaciones 1")));
    }

    @Test
    void getHistorialMedicoById() throws Exception {
        HistorialMedico historial = new HistorialMedico(1L, null, "Diagnóstico 1", "Tratamiento 1", "Observaciones 1");

        when(historialMedicoServices.findById(1L)).thenReturn(historial);

        mockMvc.perform(get("/historialesMedicos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idHistorial", is(1)))
                .andExpect(jsonPath("$.diagnostico", is("Diagnóstico 1")))
                .andExpect(jsonPath("$.tratamiento", is("Tratamiento 1")))
                .andExpect(jsonPath("$.observaciones", is("Observaciones 1")));
    }
}
