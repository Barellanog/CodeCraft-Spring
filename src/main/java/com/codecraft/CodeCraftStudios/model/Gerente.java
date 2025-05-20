package com.codecraft.CodeCraftStudios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Gerente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gerente {

    @Id
    public int id;
    @Column(nullable = false)
    public String nombre; // nombre completo
    @Column(nullable = false, length = 50)
    public String email;
    @Column(nullable = false)
    public String rol; // Ejemplo: "Gerente de Curso"
    @Column(nullable = false)
    public int cursosAsignados;// Lista de reportes generados por el gerente
    @Column(nullable = false)
    public String reportesGenerados;//Lista de reportes generados por el gerente
}
