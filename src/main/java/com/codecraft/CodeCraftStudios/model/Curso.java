package com.codecraft.CodeCraftStudios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {

    private int id;
    private String name;
    private String description;
    private Date fecha;
    private String horaCurso;

}
