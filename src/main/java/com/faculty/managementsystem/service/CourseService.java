package com.faculty.managementsystem.service;

import com.faculty.managementsystem.model.Course;
import com.faculty.managementsystem.repository.CourseRepository;

import java.util.List;

public interface CourseService {
     List<Course> getAllCourse();

     Course getCourseById(Integer id);
     Course addCourse(Course course);
     void deleteCousceById(Integer id);
}
