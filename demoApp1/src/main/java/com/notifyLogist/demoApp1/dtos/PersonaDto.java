package com.notifyLogist.demoApp1.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDto {

    private Integer idPersona;
    private String Nombres;
    private String Apellidos;
    private String Email;
    private String Telefono;
}
