package com.faculty.managementsystem.repository;

import com.faculty.managementsystem.model.Grades;
import com.faculty.managementsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<List<Student>> findStudentByName (String name);

}
