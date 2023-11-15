package com.faculty.managementsystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "student_name")
    String name;
    @Column(name = "student_gender")
    String gender;
    @Column(name = "student_department")
    String departament;

    public Student(String name, String gender, String departament) {
        this.name = name;
        this.gender = gender;
        this.departament = departament;
    }
}
