package com.faculty.managementsystem.controller;

import com.faculty.managementsystem.model.Professor;
import com.faculty.managementsystem.service.ProfessorServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/professor")
@AllArgsConstructor
public class ProfessorController {

    private final ProfessorServiceImp professorServiceImp;

    @GetMapping
    public ResponseEntity<List<Professor>> getProfessors() {
        return new ResponseEntity<>(
                professorServiceImp.getProfessors(),
                HttpStatus.OK);
    }

    @GetMapping(path = "{professorId}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable(name = "professorId") Integer professorId) {
        return new ResponseEntity<>(
                professorServiceImp.getProfessorById(professorId),
                HttpStatus.OK
        );
    }

    @PostMapping(path = "/add")
    public ResponseEntity<String> registerNewProfessor(@RequestBody Professor professor) {
        professorServiceImp.addNewProfessor(professor);
        return new ResponseEntity<>(
                "Professor added successfully!",
                HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{professorId}")
    public ResponseEntity<String> deleteProfessor(@PathVariable(name = "professorId") Integer professorId) {
        professorServiceImp.deleteProfessor(professorId);
        return new ResponseEntity<>(
                "Professor with id " + professorId + " deleted successfully!",
                HttpStatus.OK
        );
    }

    @PutMapping(path = "/update/{professorId}")
    public ResponseEntity<String> updateProfessor(@PathVariable("professorId") Integer professorId,
                                          @RequestParam(required = false) String name,
                                          @RequestParam(required = false) String department) {
        professorServiceImp.updateProfessor(professorId, name, department);
        return new ResponseEntity<>(
                "Professor with id " + professorId + " updated successfully!",
                HttpStatus.OK
        );
    }

}
