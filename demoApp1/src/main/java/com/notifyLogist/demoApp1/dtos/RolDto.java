package com.notifyLogist.demoApp1.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolDto {

    private Integer idRol;
    private String nombreRol;
    private String DescripcionRol;
}
