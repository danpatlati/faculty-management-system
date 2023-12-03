package com.faculty.managementsystem.controller;

import com.faculty.managementsystem.exception.GradesNotFoundException;
import com.faculty.managementsystem.model.Grades;
import com.faculty.managementsystem.model.Student;
import com.faculty.managementsystem.service.GradesServiceImp;
import com.faculty.managementsystem.service.StudentServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grades")
@AllArgsConstructor
public class GradesController {
    private final GradesServiceImp gradesServiceImp;
    private final StudentServiceImp studentServiceImp;

    @GetMapping("/all")
    public List<Grades> getAllGrades() {
        return gradesServiceImp.getAllGrades();
    }

    @GetMapping("/all/{id}")
    public Optional<Grades> getAllGradesById(@PathVariable Long id) {
        return gradesServiceImp.getGradesById(id);
    }


    @PostMapping("/add")
    public String addGrades(@RequestBody Grades grades) {
        gradesServiceImp.addGrades(grades);
        return "Grades were successfully saved!";
    }

    @PutMapping("/update/{id}")
    public String updateGrades(@PathVariable Long id, @RequestBody Grades grades) {
        gradesServiceImp.updateGrades(id, grades);
        return String.format("The grades at id: %s were updated!", id);
    }

    @PutMapping("/{gradesid}/student/{studentid}")
    public Grades enrollStudentToGrades(
            @PathVariable Long gradesid,
            @PathVariable Integer studentid
    ) {
        Optional<Grades> optionalGrades = gradesServiceImp.getGradesById(gradesid);

        return gradesServiceImp.addGrades(optionalGrades.map(grades -> {
            Student student = studentServiceImp.getStudentById(studentid);
            grades.enrollStudent(student);
            return grades;
        }).orElseThrow(() -> new GradesNotFoundException("Grades not found for id: " + gradesid)));
    }


    @DeleteMapping("/deleteAll")
    public String deleteAllGrades() {
        gradesServiceImp.deleteAllGrades();
        return "All of the grades were deleted!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteGrades(@PathVariable Long id) {
        gradesServiceImp.deleteGradesById(id);
        return String.format("The grades at id: %s were deleted!", id);
    }


}
