package com.notifyLogist.demoApp1.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Usuarios")
@Data
@Getter
@Setter
@NoArgsConstructor
public class UsuarioEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Usuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "Usuario", nullable = false, length = 50)
    private String Usuario;

    @Column(name = "Contraseña", nullable = false, length = 50)
    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "id_Rol", nullable = false, updatable = false, insertable = false)
    private RolEntity idRol;

}
