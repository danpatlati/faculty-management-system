package com.faculty.managementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.faculty.managementsystem.model.Grades;
import org.springframework.stereotype.Repository;

@Repository
public interface GradesRepository extends JpaRepository<Grades, Long> {

}
