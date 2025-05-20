package com.codecraft.CodeCraftStudios.repository;

import com.codecraft.CodeCraftStudios.model.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerenteRepositoryJPA extends JpaRepository<Gerente, Integer> {
    Gerente findById(int id);
}