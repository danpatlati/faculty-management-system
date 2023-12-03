package com.faculty.managementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.faculty.managementsystem.model.Grades;

public interface GradesRepository extends JpaRepository<Grades, Long> {
    Grades findByStudentId(Integer id);
}
//TODO: Write findByStudentName
