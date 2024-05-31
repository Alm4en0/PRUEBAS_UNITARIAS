package dev.cesarzavaleta.pruebas_unitarias_s11.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private long idCliente;
    @Column(nullable = false, length = 255)
    private String nombre;
    @Column(nullable = false, length = 255)
    private String apellido;
    @Column(nullable = false, length = 255)
    private String direccion;
    @Column(nullable = false, length = 20)
    private String telefono;
    @Column(name = "correo_electronico", unique = true, length = 50)
    private String correoElectronico;

}
