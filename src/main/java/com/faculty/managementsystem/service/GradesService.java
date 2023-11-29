package com.faculty.managementsystem.service;

import com.faculty.managementsystem.model.Grades;

import java.util.List;
import java.util.Optional;

public interface GradesService {
    List<Grades> getAllGrades();

    Optional<Grades> getAllGradesById(Long id);

    void addGrades(Grades grades);

    void updateGrades(Long id, Grades grades);

    void deleteGradesById(Long id);

    void deleteAllGrades();




}
