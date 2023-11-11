package com.faculty.managementsystem.controller;

import com.faculty.managementsystem.model.Professor;
import com.faculty.managementsystem.service.ProfessorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
@AllArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping
    public List<Professor> getProfessors() {
        return professorService.getProfessors();
    }

    @PostMapping(path = "add-professor")
    public void registerNewProfessor(@RequestBody Professor professor) {
        professorService.addNewProfessor(professor);
    }

    @DeleteMapping(path = "delete-professor/{professorId}")
    public void deleteProfessor(@PathVariable(name = "professorId") Long professorId) {
        professorService.deleteProfessor(professorId);
    }

    @PutMapping(path = "update-professor/{professorId}")
    public void updateProfessor(@PathVariable("professorId") Long professorId,
                                @RequestParam(required = false) String name,
                                @RequestParam(required = false) String newDepartment) {
        professorService.updateProfessor(professorId, name, newDepartment);
    }

}
