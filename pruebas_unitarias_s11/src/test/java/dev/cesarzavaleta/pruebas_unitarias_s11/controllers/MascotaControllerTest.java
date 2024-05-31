package dev.cesarzavaleta.pruebas_unitarias_s11.controllers;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Mascota;
import dev.cesarzavaleta.pruebas_unitarias_s11.services.MascotaServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;

class MascotaControllerTest {
    private MascotaController mascotaController;
    private MascotaServices mascotaServices;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        mascotaServices = mock(MascotaServices.class);
        mascotaController = new MascotaController(mascotaServices);
        mockMvc = MockMvcBuilders.standaloneSetup(mascotaController).build();
    }

    @Test
    void getAllMascotas() throws Exception{
        Mascota mascota1 = new Mascota();
        mascota1.setIdMascota(1L);
        mascota1.setNombre("Lucas");
        Mascota mascota2 = new Mascota();
        mascota2.setIdMascota(2L);
        mascota2.setNombre("Luna");

        List<Mascota> mascotas = Arrays.asList(mascota1, mascota2);

        when(mascotaServices.findAll()).thenReturn(mascotas);
        mockMvc.perform(get("/mascotas"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].idMascota", is(1)))
                .andExpect(jsonPath("$[0].nombre", is("Lucas")));
    }

    @Test
    void getMascotaById() throws Exception {
        Mascota mascota = new Mascota();
        mascota.setIdMascota(1L);
        mascota.setNombre("Lucas");

        when(mascotaServices.findById(1L)).thenReturn(mascota);

        mockMvc.perform(get("/mascotas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idMascota", is(1)))
                .andExpect(jsonPath("$.nombre", is("Lucas")));
    }

    @Test
    void saveMascota() throws Exception {
        Mascota newMascota = new Mascota();
        newMascota.setNombre("Max");

        Mascota savedMascota = new Mascota();
        savedMascota.setIdMascota(3L);
        savedMascota.setNombre("Max");

        when(mascotaServices.save(any(Mascota.class))).thenReturn(savedMascota);

        mockMvc.perform(post("/mascotas")
                        .contentType(APPLICATION_JSON)
                        .content("{\"nombre\": \"Max\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.idMascota", is(3)))
                .andExpect(jsonPath("$.nombre", is("Max")));
    }

    @Test
    void deleteMascotaById() throws Exception {
        doNothing().when(mascotaServices).deleteById(1L);

        mockMvc.perform(delete("/mascotas/1"))
                .andExpect(status().isNoContent());

        verify(mascotaServices, times(1)).deleteById(1L);
    }
}
