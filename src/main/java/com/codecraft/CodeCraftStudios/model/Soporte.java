package com.codecraft.CodeCraftStudios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Soporte")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Soporte {

    @Id
    private int id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String especialidad; // Ej: "Redes", "Hardware", "Software"
    @Column(nullable = false)
    private String disponibilidad; // Ej: "Lunes a Viernes 9:00-18:00"
    @Column(nullable = true)
    private String telefono; // de contacto interno o externo
    @Column(nullable = true)
    private String observaciones; // notas internas, historial de asistencia, etc.
}