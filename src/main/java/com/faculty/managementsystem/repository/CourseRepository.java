package com.faculty.managementsystem.repository;

import com.faculty.managementsystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Integer> {

    List<Course> findByProfessorId(Integer id);
    @Query("SELECT c FROM Course c WHERE c.name LIKE %?1% OR c.department LIKE %?1%")
    List<Course> search(String keyword);

}
