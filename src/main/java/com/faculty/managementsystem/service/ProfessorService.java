package com.faculty.managementsystem.service;

import com.faculty.managementsystem.model.Professor;

import java.util.List;
import java.util.Optional;

public interface ProfessorService {
    List<Professor> getProfessors();
    Professor getProfessorById(Integer id);
    void addNewProfessor(Professor professor);
    void deleteProfessor(Integer professorId);
    void updateProfessor(Integer professorId,
                         String newName,
                         String department);
}