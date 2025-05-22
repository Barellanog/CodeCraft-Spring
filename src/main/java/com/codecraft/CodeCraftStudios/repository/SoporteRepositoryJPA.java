package com.codecraft.CodeCraftStudios.repository;

import com.codecraft.CodeCraftStudios.model.Soporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoporteRepositoryJPA extends JpaRepository<Soporte, Integer> {
    Soporte findById(int id);
    Soporte findByEmail(String email); // búsqueda adicional útil para soporte
}
