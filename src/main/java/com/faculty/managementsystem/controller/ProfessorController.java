package com.faculty.managementsystem.controller;

import com.faculty.managementsystem.model.Professor;
import com.faculty.managementsystem.service.ProfessorService;
import com.faculty.managementsystem.service.ProfessorServiceImp;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/professor")
@AllArgsConstructor
public class ProfessorController {

    private final ProfessorServiceImp professorServiceImp;

    @GetMapping
    public List<Professor> getProfessors() {
        return professorServiceImp.getProfessors();
    }

    @PostMapping
    public void registerNewProfessor(@RequestBody Professor professor) {
        professorServiceImp.addNewProfessor(professor);
    }

    @DeleteMapping(path = "{professorId}")
    public void deleteProfessor(@PathVariable(name = "professorId") Integer professorId) {
        professorServiceImp.deleteProfessor(professorId);
    }

    @PutMapping(path = "{professorId}")
    public void updateProfessor(@PathVariable("professorId") Integer professorId,
                                @RequestParam(required = false) String name,
                                @RequestParam(required = false) String department) {
        professorServiceImp.updateProfessor(professorId, name, department);
    }

}
