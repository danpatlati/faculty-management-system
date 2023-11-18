package com.faculty.managementsystem.repository;

import com.faculty.managementsystem.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    @Query("SELECT p FROM Professor p WHERE p.name = ?1")
    Optional<Professor> findProfessorByName(String name);
}
