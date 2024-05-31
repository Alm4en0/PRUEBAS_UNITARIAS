package dev.cesarzavaleta.pruebas_unitarias_s11.controllers;

import dev.cesarzavaleta.pruebas_unitarias_s11.model.Mascota;
import dev.cesarzavaleta.pruebas_unitarias_s11.services.MascotaServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    private final MascotaServices mascotaServices;

    public MascotaController(MascotaServices mascotaServices){
        this.mascotaServices = mascotaServices;
    }

    @GetMapping
    public List<Mascota> getAllMascotas(){
        return mascotaServices.findAll();
    }

    @GetMapping("/{id}")
    public Mascota getMascotaById(@PathVariable Long id){
        return mascotaServices.findById(id);
    }

    @PostMapping
    public ResponseEntity<Mascota> save(@RequestBody Mascota mascota){
        Mascota savedMascota = mascotaServices.save(mascota);
        return new ResponseEntity<>(savedMascota, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        mascotaServices.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
