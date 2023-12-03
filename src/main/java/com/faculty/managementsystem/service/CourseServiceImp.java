package com.faculty.managementsystem.service;

import com.faculty.managementsystem.model.Course;
import com.faculty.managementsystem.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CourseServiceImp implements CourseService{
    private final CourseRepository courseRepository;

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }
    public Course getCourseById(Integer id){
        return courseRepository.findById(id).orElse(null);
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }


    public void deleteCousceById(Integer id) {
        courseRepository.deleteById(id);
    }



}
