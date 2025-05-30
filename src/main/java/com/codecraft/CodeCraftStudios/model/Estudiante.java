package com.codecraft.CodeCraftStudios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "Estudiante")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {

    @Id
    private int id;
    @Column(nullable = false)
    private String nombre; //nombre completo
    @Column(nullable = false, length = 50)
    private int edad;
    @Column(nullable = false)
    private char genero;
    @Column(nullable = false)
    private String correo;
    @Column(nullable = false)
    private int telefono;

}
