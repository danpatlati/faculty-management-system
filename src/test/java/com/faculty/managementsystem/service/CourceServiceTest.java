package com.faculty.managementsystem.service;

import com.faculty.managementsystem.model.Course;
import com.faculty.managementsystem.repository.CourseRepository;
import org.assertj.core.api.Assertions;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CourceServiceTest {
    @Mock
    CourseRepository courseRepository;
    @InjectMocks
    CourseServiceImp courseService;

    @Test
    public void CourseServicegetAllCourse() {
        List<Course> courses = Mockito.mock(List.class);

        when(courseRepository.findAll()).thenReturn(courses);

        List<Course> coursesaved = courseService.getAllCourse();

        Assertions.assertThat(coursesaved).isNotNull();
    }

    @Test
    public void CourseServicesearch() {
        List<Course> courses = Mockito.mock(List.class);

        when(courseRepository.search("info")).thenReturn(courses);

        List<Course> coursessaved = courseService.search("info");

        Assertions.assertThat(coursessaved).isNotNull();
        Assertions.assertThat(coursessaved).isEqualTo(courses);
    }

    @Test
    public void CourseServicegetCourseById() {
        Course course = Mockito.mock(Course.class);

        when(courseRepository.findById(1)).thenReturn(Optional.ofNullable(course));

        Course coursesaved = courseService.getCourseById(1);


        Assertions.assertThat(coursesaved).isNotNull();
        Assertions.assertThat(coursesaved).isEqualTo(course);
    }

    @Test
    public void CourseServiceaddCourse() {
        Course course = Mockito.mock(Course.class);

        when(courseRepository.save(Mockito.any(Course.class))).thenReturn(course);

        Course coursesaved = courseService.addCourse(course);

        Assertions.assertThat(coursesaved).isNotNull();
        Assertions.assertThat(coursesaved).isEqualTo(course);
    }

    @Test
    public void CourseServicefindByProfessorId() {
        List<Course> course = Mockito.mock(List.class);

        when(courseRepository.findByProfessorId(1)).thenReturn(course);

        List<Course> coursessaved = courseService.findByProfessorId(1);

        Assertions.assertThat(coursessaved).isNotNull();
    }

    @Test
    public void CourseServicedeleteCousceById() {
        Course course = Mockito.mock(Course.class);

        assertAll(() -> courseService.deleteCourseById(1));
    }

}
