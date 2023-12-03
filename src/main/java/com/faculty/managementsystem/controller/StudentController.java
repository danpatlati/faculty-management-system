package com.faculty.managementsystem.controller;

import com.faculty.managementsystem.model.Course;
import com.faculty.managementsystem.model.Student;
import com.faculty.managementsystem.service.CourseServiceImp;
import com.faculty.managementsystem.service.StudentServiceImp;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {
    private final StudentServiceImp studentServiceImp;

    private final CourseServiceImp courseServiceImp;

    @GetMapping("/getStudents")
    public ResponseEntity<List<Student>> getAllStudents (){
        List<Student> students = studentServiceImp.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @GetMapping("/getStudent/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id")Integer id){
        Student student = studentServiceImp.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/getStudentByName/{name}")
    public ResponseEntity<Optional<List<Student>>> getStudentByName (@PathVariable("name") String name) {
        Optional<List<Student>> students = studentServiceImp.getStudentByName(name);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Void> addStudent(@RequestBody Student student){
        studentServiceImp.addStudent(student);
        log.info("Studentul {} a fost adaugat", student.toString());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable("id") Integer id,@RequestBody Student updatedStudent){
        Student updated = studentServiceImp.updateStudent(id, updatedStudent);

        if (updated != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("{studentId}/course/{courseId}")
    public Student enrollStudentToCourse(
            @PathVariable Integer studentId,
            @PathVariable Integer courseId
    ){
        Student student = studentServiceImp.getStudentById(studentId);
        Course course = courseServiceImp.getCourseById(courseId);
        student.enrollCourse(course);
        return studentServiceImp.addStudent(student);
    }


    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable("id") Integer id){
        studentServiceImp.deleteStudentById(id);
        log.info("Studentul a fost sters cu acest id: {}", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
