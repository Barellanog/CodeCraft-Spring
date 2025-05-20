package com.codecraft.CodeCraftStudios.repository;

import com.codecraft.CodeCraftStudios.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepositoryJPA extends JpaRepository<Estudiante, Integer> {

    Estudiante findById(int id);
    Estudiante findByCorreo(String correo); // útil para búsquedas personalizadas
}