package com.faculty.managementsystem.model;

import jakarta.persistence.*;
import lombok.*;

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
    @Column
    private String name;
    @Column
    private String gender;
    @Column
    private String department;


    public Student(String name, String gender, String department) {
        this.name = name;
        this.gender = gender;
        this.department = department;
    }
}
