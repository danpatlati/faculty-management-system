package com.faculty.managementsystem.service;

import com.faculty.managementsystem.model.Professor;

import java.util.List;

public interface ProfessorService {
    List<Professor> getProfessors();
    void addNewProfessor(Professor professor);
    void deleteProfessor(Integer professorId);
    void updateProfessor(Integer professorId,
                         String newName,
                         String department);
}