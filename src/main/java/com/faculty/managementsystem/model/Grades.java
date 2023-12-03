package com.faculty.managementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    @PrePersist
    @PreUpdate
    private void calculateFinalGrade() {
        this.final_grade = (english + romanian + mathematics + geography) / 4;
    }
    public void enrollStudent(Student student){
        this.student = student;
    }
    public Grades(Double english, Double romanian, Double mathematics, Double geography) {
        this.english = english;
        this.romanian = romanian;
        this.mathematics = mathematics;
        this.geography = geography;

    }
}
