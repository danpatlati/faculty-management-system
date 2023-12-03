package com.faculty.managementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "course")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Course {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String department;
    @JsonIgnore
    @ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY)
    private Set<Student> student;
    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Professor professor;


    public Course(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public void enrollProfesor(Professor professor) {
        this.professor = professor;;
    }
}
