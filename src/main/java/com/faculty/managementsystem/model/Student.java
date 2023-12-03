package com.faculty.managementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String gender;
    private String department;
    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses;
    @JsonIgnore
    @OneToOne(mappedBy = "student")
    private Grades grades;

    public Student(Integer id, String name, String gender, String department) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
    }

    public Student(String name, String gender, String department) {
        this.name = name;
        this.gender = gender;
        this.department = department;
    }

    public void enrollCourse(Course course) {
        courses.add(course);
    }
}
