package com.codecraft.CodeCraftStudios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {

    private int id;
    private String nombre;
    private String correo;
    private int telefono;
    private String direccion;
    private Curso curso;

}
