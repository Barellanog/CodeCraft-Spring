package com.codecraft.CodeCraftStudios.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Instructor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {

    @Id
    private int id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false, unique = true)
    private String correo;
    @Column(nullable = false)
    private int telefono;
    @Column(nullable = false)
    private String direccion;
    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;
}
