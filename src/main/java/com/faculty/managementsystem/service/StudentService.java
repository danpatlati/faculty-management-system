package com.faculty.managementsystem.service;

import com.faculty.managementsystem.model.Student;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public interface StudentService {
     Student addStudent(Student student);

     Student getStudentById(Integer id) ;

     List<Student> getAllStudents();
     Student updateStudent(Integer id,Student updatedStudent);
     void deleteStudentById(Integer id) ;
     Optional<List<Student>> getStudentByName(String name);
}
