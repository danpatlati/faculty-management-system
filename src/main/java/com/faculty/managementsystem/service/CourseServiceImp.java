package com.faculty.managementsystem.service;

import com.faculty.managementsystem.model.Course;
import com.faculty.managementsystem.repository.CourseRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CourseServiceImp implements CourseService{
    private final CourseRepository courseRepository;


    @Override
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void deleteCousceById(Integer id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }
}
