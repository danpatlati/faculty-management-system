package com.faculty.managementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "professor")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Professor {

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
    @JsonIgnore
    @OneToMany(mappedBy = "professor",cascade = CascadeType.ALL)
    private List<Course> courses;

    public Professor(String name, String gender, String department) {
        this.name = name;
        this.gender = gender;
        this.department = department;
    }
}
