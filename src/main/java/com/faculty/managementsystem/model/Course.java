package com.faculty.managementsystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course {
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "course_name")
    String name;
    @Column(name = "course_departamnent")
    String department;

    public Course(String name, String department) {
        this.name = name;
        this.department = department;
    }
}
