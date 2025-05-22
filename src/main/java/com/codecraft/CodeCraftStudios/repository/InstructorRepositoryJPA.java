package com.codecraft.CodeCraftStudios.repository;

import com.codecraft.CodeCraftStudios.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepositoryJPA extends JpaRepository<Instructor, Integer> {

    Instructor findById(int id);
    Instructor findByCorreo(String correo);
}