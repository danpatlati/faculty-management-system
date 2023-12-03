package com.faculty.managementsystem.service;

import com.faculty.managementsystem.model.Student;
import com.faculty.managementsystem.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImp implements StudentService{
    private final StudentRepository studentRepository;


    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Integer id) {
        Student student =  studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student with id " + id + " not found"));
        return student;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Student updateStudent(Integer id,Student updatedStudent){
        Optional<Student> existingStudentOptional = studentRepository.findById(id);

        if (existingStudentOptional.isPresent()) {
            Student existingStudent = existingStudentOptional.get();

            existingStudent.setName(updatedStudent.getName());
            existingStudent.setGender(updatedStudent.getGender());
            existingStudent.setDepartment(updatedStudent.getDepartment());
            existingStudent.setCourses(updatedStudent.getCourses());
            existingStudent.setGrades(updatedStudent.getGrades());

            return studentRepository.save(existingStudent);
        } else {
            throw new EntityNotFoundException("Studentul cu id-ul " + id + " nu a fost găsit.");
        }
    }
    public void deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
    }
    public Optional<List<Student>> getStudentByName(String name){
        return studentRepository.findStudentByName(name);
    }

}
