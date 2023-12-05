package com.faculty.managementsystem.repository;

import com.faculty.managementsystem.model.Grades;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class GradesRepositoryTests {
    @Autowired
    private GradesRepository gradesRepository;

    @Test
    public void GradesRepository_findAll_ShouldReturnMoreThenOneGrades() {

        Grades grades = Grades.builder()
                .romanian(10d)
                .english(10d)
                .mathematics(8d)
                .geography(8d).build();

        Grades grades2 = Grades.builder()
                .romanian(10d)
                .english(10d)
                .mathematics(8d)
                .geography(8d).build();

        gradesRepository.save(grades);
        gradesRepository.save(grades2);

        List<Grades> gradesList = gradesRepository.findAll();

        Assertions.assertNotNull(gradesList);
        Assertions.assertEquals(gradesList.size(), 2);
    }

    @Test
    public void GradesRepository_findById_ShouldReturnGradeById() {

        Grades grades = Grades.builder()
                .romanian(10d)
                .english(10d)
                .mathematics(8d)
                .geography(8d).build();

        gradesRepository.save(grades);

        Grades testGrades = gradesRepository.findById(grades.getId()).get();

        Assertions.assertNotNull(testGrades);

    }
}
