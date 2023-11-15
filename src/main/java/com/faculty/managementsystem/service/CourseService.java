package com.faculty.managementsystem.service;

import com.faculty.managementsystem.model.Course;

import java.util.List;

public interface CourseService {
    void addCourse(Course course);
    void deleteCousceById(Integer id);
    List<Course> getAllCourse();
}
