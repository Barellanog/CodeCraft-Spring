package com.codecraft.CodeCraftStudios.repository;

import com.codecraft.CodeCraftStudios.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepositoryJPA extends JpaRepository<Curso, Integer> {

    Curso findById(int id);
}