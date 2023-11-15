package com.faculty.managementsystem.controller;

import com.faculty.managementsystem.model.Course;
import com.faculty.managementsystem.service.CourseServiceImp;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/course")
@AllArgsConstructor
public class CourseController {
    private final CourseServiceImp courseServiceImp;
    @PostMapping("/addCourse")
    void addCourse(@RequestBody Course course){
        courseServiceImp.addCourse(course);
        log.info("Cursul {} a fost adaugat cu succes",course.toString());
    }
    @DeleteMapping("/deleteCourse/{id}")
    void deleteCousceById(@PathVariable("id") Integer id){
        courseServiceImp.deleteCousceById(id);
        log.info("Cursul {} a fost sters cu succes",id);

    }
    @GetMapping("/getAllCouse")
    List<Course> getAllCousce(){
        log.info("Toate cursurile {}",courseServiceImp.getAllCourse().toString());
        return courseServiceImp.getAllCourse();
    }
}
