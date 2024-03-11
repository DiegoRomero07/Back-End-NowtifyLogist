package com.notifyLogist.demoApp1.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Roles")
@Data
@Getter
@Setter
@NoArgsConstructor
public class RolEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Rol", nullable = false)
    private Integer idRol;

    @Column(name = "nombreRol", nullable = false, length = 50, unique = true)
    private String nombreRol;

    @Column(name = "DescripcionRol", nullable = false, length = 150)
    private String DescripcionRol;

    @OneToMany(mappedBy = "rol")
    private List<UsuarioEntity> usuarioEntity;
}
