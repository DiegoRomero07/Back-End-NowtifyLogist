package com.notifyLogist.demoApp1.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDto {

    private Integer idCategoria;
    private String nombreCategoria;
    private String Descripcion;
}
