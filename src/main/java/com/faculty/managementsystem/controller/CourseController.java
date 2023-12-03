package com.faculty.managementsystem.controller;

import com.faculty.managementsystem.model.Course;
import com.faculty.managementsystem.model.Professor;
import com.faculty.managementsystem.service.CourseServiceImp;
import com.faculty.managementsystem.service.ProfessorServiceImp;
import com.faculty.managementsystem.service.StudentServiceImp;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/course")
@AllArgsConstructor
public class CourseController {
    private final CourseServiceImp courseServiceImp;

    private final ProfessorServiceImp professorServiceImp;
    @GetMapping("/getAllCourse")
    public List<Course> getAllCourse(){
        return courseServiceImp.getAllCourse();
    }
    @PostMapping("/addCourse")
    public ResponseEntity<Void> addCourse(@RequestBody Course course){
        courseServiceImp.addCourse(course);
        log.info("Cursul {} a fost adaugat cu succes",course.toString());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/getCourse/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") Integer id){
        Course course = courseServiceImp.getCourseById(id);
        return new ResponseEntity<>(course,HttpStatus.OK);
    }
    @PutMapping("{courseid}/professor/{professorid}")
    public Course enrollCourseToProfessor(
            @PathVariable Integer courseid,
            @PathVariable Integer professorid
            ){
        Course course = courseServiceImp.getCourseById(courseid);
        Professor professor = professorServiceImp.getProfessorById(professorid);
        course.enrollProfesor(professor);
        return courseServiceImp.addCourse(course);
    }
    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity<Void> deleteCousceById(@PathVariable("id") Integer id){
        courseServiceImp.deleteCousceById(id);
        log.info("Cursul {} a fost sters cu succes",id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
