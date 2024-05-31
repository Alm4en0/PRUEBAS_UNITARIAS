package dev.cesarzavaleta.pruebas_unitarias_s11.repository;

import ch.qos.logback.core.model.Model;
import dev.cesarzavaleta.pruebas_unitarias_s11.model.HistorialMedico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialMedicoRepository extends CrudRepository<HistorialMedico,Long> {
}
