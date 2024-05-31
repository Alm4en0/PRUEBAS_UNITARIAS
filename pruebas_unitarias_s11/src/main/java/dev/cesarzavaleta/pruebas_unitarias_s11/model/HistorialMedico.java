package dev.cesarzavaleta.pruebas_unitarias_s11.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "historial_medico")
@Getter
@Setter
public class HistorialMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    private long idHistorial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cita", nullable = false)
    private Cita cita;

    @Column(length = 255)
    private String diagnostico;

    @Column(length = 255)
    private String tratamiento;

    @Column(columnDefinition = "TEXT")
    private String observaciones;
}
