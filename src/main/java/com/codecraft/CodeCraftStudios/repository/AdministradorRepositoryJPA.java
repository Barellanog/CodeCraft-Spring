package com.codecraft.CodeCraftStudios.repository;

import com.codecraft.CodeCraftStudios.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepositoryJPA extends JpaRepository<Administrador, Integer> {
    Administrador findById(int id);
    Administrador findByEmail(String email);
}
