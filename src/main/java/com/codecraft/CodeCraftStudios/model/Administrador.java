package com.codecraft.CodeCraftStudios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Administrador")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administrador {

    @Id
    private int id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String cargo; // Ej: "Administrador General", "Administrador Académico"
    @Column(nullable = false)
    private String nivelAcceso; // Ej: "Total", "Limitado", "Solo Lectura"
    @Column(nullable = true)
    private String telefono;
    @Column(nullable = true)
    private String observaciones; // notas administrativas internas
}
