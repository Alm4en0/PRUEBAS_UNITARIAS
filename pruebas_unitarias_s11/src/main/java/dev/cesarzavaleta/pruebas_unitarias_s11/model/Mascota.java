package dev.cesarzavaleta.pruebas_unitarias_s11.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mascotas")
@Getter
@Setter
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private long idMascota;
    @Column(nullable = false, length = 255)
    private String nombre;
    @Column(nullable = false, length = 50)
    private String especie;
    @Column(nullable = false, length = 50)
    private String raza;
    @Column(nullable = false, length = 50)
    private String sexo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name="fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;
}
