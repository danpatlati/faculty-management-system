package com.faculty.managementsystem.service;


import com.faculty.managementsystem.model.Grades;
import com.faculty.managementsystem.repository.GradesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GradesServiceImpTest {

    @Mock
    private GradesRepository gradesRepository;

    @InjectMocks
    private GradesServiceImp gradesServiceImp;

    @Test
    public void GradesServiceImp_addGrades_ShouldReturnGrades() {
        Grades grades = Grades.builder()
                .english(8d)
                .romanian(8d)
                .mathematics(8d)
                .geography(8d)
                .build();

        when(gradesRepository.save(Mockito.any(Grades.class))).thenReturn(grades);

        Grades savedGrades = gradesServiceImp.addGrades(grades);

        Assertions.assertNotNull(savedGrades);

    }
}
