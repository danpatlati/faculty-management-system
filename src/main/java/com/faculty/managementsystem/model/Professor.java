package com.faculty.managementsystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "professor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Professor {

    @Id
    @SequenceGenerator(
            name = "professor_id_seq",
            sequenceName = "professor_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "professor_id_seq"
    )
    private Long id;
    private String name;
    private String gender;
    private String department;

    public Professor(String name, String gender, String department) {
        this.name = name;
        this.gender = gender;
        this.department = department;
    }
}
