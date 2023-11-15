package com.faculty.managementsystem.controller;

import com.faculty.managementsystem.model.Student;
import com.faculty.managementsystem.service.StudentServiceImp;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {
    private final StudentServiceImp studentServiceImp;

    @GetMapping("/getStudents")
    public List<Student> getAllStudents (){
        return studentServiceImp.getAllStudents();
    }
    @GetMapping("/getStudent/{id}")
    public Student getStudentById(@PathVariable("id")Integer id){
        return studentServiceImp.getStudentById(id);
    }
    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student){
        studentServiceImp.addStudent(student);
        log.info("Studentul {} a fost adaugat", student.toString());

    }
    @DeleteMapping("/deleteStudent/{id}")
    void deleteStudentById(@PathVariable("id") Integer id){
        studentServiceImp.deleteStudentById(id);
        log.info("Studentul a fost sters cu acest id: {}", id);
    }
}
