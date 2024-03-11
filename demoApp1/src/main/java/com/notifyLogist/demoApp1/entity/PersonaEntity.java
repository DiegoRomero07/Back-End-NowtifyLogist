package com.notifyLogist.demoApp1.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Personas")
@Data
@Getter
@Setter
@NoArgsConstructor
public class PersonaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Persona")
    private Integer idPersona;

    @Column(name = "Nombres", nullable = false, length = 255)
    private String Nombres;
    @Column(name = "Apellidos", nullable = false, length = 255)
    private String Apellidos;
    @Column(name = "Email", nullable = false, length = 255, unique = true)
    private String Email;
    @Column(name = "Telefono", nullable = false, length = 11, unique = true)
    private String Telefono;

    @OneToMany(mappedBy = "persona")
    private List<UsuarioEntity> usuarioEntity;
}
