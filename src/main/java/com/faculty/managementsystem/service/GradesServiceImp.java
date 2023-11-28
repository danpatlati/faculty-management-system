package com.faculty.managementsystem.service;

import com.faculty.managementsystem.model.Grades;
import com.faculty.managementsystem.repository.GradesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GradesServiceImp implements GradesService {
    private final GradesRepository gradesRepository;

    @Override
    public List<Grades> getAllGrades() {
        return gradesRepository.findAll();
    }
    @Override
    public Optional<Grades> getAllGradesById(Long id) {
        return gradesRepository.findById(id);
    }

    @Override
    public void addGrades(Grades grades) {
        gradesRepository.save(grades);
    }
    @Override
    public void updateGrades(Long id, Grades grades) {
        grades.setId(id);
        gradesRepository.save(grades);
    }
    @Override
    public void deleteGradesById(Long id) {
        gradesRepository.deleteById(id);

    }

    @Override
    public void deleteAllGrades() {
        gradesRepository.deleteAll();
    }
}
