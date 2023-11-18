package com.faculty.managementsystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "grades")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Grades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grades_id")
    private Long id;
    private Double english;
    private Double romanian;
    private Double mathematics;
    private Double geography;
    private Double final_grade;

    public Grades(Double english, Double romanian, Double mathematics, Double geography, Double final_grade) {
        this.english = english;
        this.romanian = romanian;
        this.mathematics = mathematics;
        this.geography = geography;
        this.final_grade = final_grade;
    }
}
