package com.faculty.managementsystem.repository;

import com.faculty.managementsystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}
