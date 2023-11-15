package com.faculty.managementsystem.service;

import com.faculty.managementsystem.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {
    Student addStudent(Student student);
    Student getStudentById(Integer id);
    List<Student> getAllStudents();
    void deleteStudentById(Integer id);
}
