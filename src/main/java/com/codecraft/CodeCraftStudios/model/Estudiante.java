package com.codecraft.CodeCraftStudios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {

    private int id;
    private String nombre; //nombre completo
    private int edad;
    private char genero;
    private String correo;
    private int telefono;

}
