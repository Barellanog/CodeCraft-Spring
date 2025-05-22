package com.codecraft.CodeCraftStudios.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Curso")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {

    @Id
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fecha;
    @Column(nullable = false)
    private String horaCurso;
}