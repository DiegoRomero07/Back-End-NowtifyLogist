package com.notifyLogist.demoApp1.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "Categorias")
@Data
@Getter
@Setter
@NoArgsConstructor
public class CategoriaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Categoria", nullable = false)
    private Integer idCategoria;

    @Column(nullable = false, length = 50, unique = true)
    private String nombreCategoria;

    @Column(nullable = false, length = 150)
    private String Descripcion;


}
