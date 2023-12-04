package com.faculty.managementsystem.service;

import com.faculty.managementsystem.exception.NotFoundExceptionProfessor;
import com.faculty.managementsystem.model.Professor;
import com.faculty.managementsystem.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProfessorServiceImp implements ProfessorService {
    private final ProfessorRepository professorRepository;

    @Override
    public List<Professor> getProfessors() {
        return professorRepository.findAll();
    }


    public Professor getProfessorById(Integer id){
        Optional<Professor> optionalProfessor = professorRepository.findById(id);
        Professor professor = optionalProfessor.orElseThrow(() -> {
            throw new NotFoundExceptionProfessor("Professor not found for id: " + id);
        });

        return professor;
    }

    @Override
    public void addNewProfessor(Professor professor) {
        Optional<Professor> professorOptional =
                professorRepository.findProfessorByName(professor.getName());

        if (professorOptional.isPresent())
            throw new IllegalStateException("Professor with name '" + professor.getName() + "' already exists!");
        professorRepository.save(professor);
    }

    @Override
    public void deleteProfessor(Integer professorId) {
        Optional<Professor> professorExists =
                professorRepository.findById(professorId);
        if (professorExists.isEmpty()) {
            throw new IllegalStateException("Professor with id '" + professorId + "' does not exist!");
        }
        professorRepository.deleteById(professorId);
    }

    @Override
    @Transactional
    public void updateProfessor(Integer professorId, String newName, String newDepartment) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new IllegalStateException(
                        "Professor with id " + professorId + " does not exist"
                ));

        if (newName != null && !newName.isEmpty() && !Objects.equals(professor.getName(), newName)) {
            Optional<Professor> professorOptional =
                    professorRepository.findProfessorByName(newName);
            if (professorOptional.isPresent()) {
                throw new IllegalStateException("Professor with name '" + newName + "' already exists!");
            }
            professor.setName(newName);
        }

        if (newDepartment != null && !newDepartment.isEmpty() && !Objects.equals(professor.getDepartment(), newDepartment)) {
            professor.setDepartment(newDepartment);
        }
    }
}
