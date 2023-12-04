package com.faculty.managementsystem.service;

import com.faculty.managementsystem.model.Student;
import com.faculty.managementsystem.repository.StudentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImp studentService;

    @Test
    public void StudentServiceSaveStudentRetunStudent() {
        Student student = Student.builder().name("Veceslav").gender("Male").department("Informatica").build();

        when(studentRepository.save(Mockito.any(Student.class))).thenReturn(student);

        Student studentsaved = studentService.addStudent(student);

        Assertions.assertThat(studentsaved).isNotNull();
    }
    @Test
    public void StudentServieGetStudentByName(){
        List<Student> students = Mockito.mock(List.class);

        when(studentRepository.findStudentByName("Veaceslav")).thenReturn(Optional.ofNullable(students));

        Optional<List<Student>> savedStudent = studentService.getStudentByName("Veaceslav");

        Assertions.assertThat(savedStudent).isNotNull();
    }
    @Test
    public void StudentServiceGetStudentByIdReturnStudent(){
        Student student = Student.builder().name("Veceslav").gender("Male").department("Informatica").build();

        when(studentRepository.findById(1)).thenReturn(Optional.ofNullable(student));

        Student studentsaved = studentService.getStudentById(1);

        Assertions.assertThat(studentsaved).isNotNull();
    }

    @Test
    public void StudentServiceGetAllStudentReturnAllStudent() {
        Page<Student> studentPage = Mockito.mock(Page.class);

        when(studentRepository.findAll(Mockito.any(Pageable.class))).thenReturn(studentPage);

        List<Student> studentAll = studentService.getAllStudents(PageRequest.of(0,5));

        Assertions.assertThat(studentAll).isNotNull();
    }
    @Test void StudentServiceUpdateStudentRetrun(){
        Student student = Student.builder().name("Veceslav").gender("Male").department("Informatica").build();

        when(studentRepository.findById(1)).thenReturn(Optional.ofNullable(student));
        when(studentRepository.save(Mockito.any(Student.class))).thenReturn(student);

        Student studentsaved = studentService.updateStudent(1, student);

        Assertions.assertThat(studentsaved).isNotNull();
    }
    @Test
    public void StudentServiceDeleteById(){
        Student student = Student.builder().id(1).name("Veceslav").gender("Male").department("Informatica").build();

        assertAll(() -> studentRepository.deleteById(1));
    }
}
