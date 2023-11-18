package com.faculty.managementsystem.service;

import com.faculty.managementsystem.model.Grades;
import com.faculty.managementsystem.repository.GradesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GradesService {
    private final GradesRepository gradesRepository;

    public List<Grades> getAllGrades() {
        return gradesRepository.findAll();
    }

    public Optional<Grades> getAllGradesById(Long id) {
        return gradesRepository.findById(id);
    }

    public void addGrades(Grades grades) {
        gradesRepository.save(grades);
    }

    public void updateGrades(Long id, Grades grades) {
        grades.setId(id);
        gradesRepository.save(grades);
    }


    public void deleteGradesById(Long id) {
        gradesRepository.deleteById(id);

    }


    public void deleteAllGrades() {
        gradesRepository.deleteAll();
    }
}
