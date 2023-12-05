package com.faculty.managementsystem.service;

import com.faculty.managementsystem.model.Grades;
import com.faculty.managementsystem.repository.GradesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GradesServiceImp implements GradesService {
    private final GradesRepository gradesRepository;

    @Override
    public List<Grades> getAllGrades() {
        return gradesRepository.findAll();
    }
    @Override
    public Optional<Grades> getGradesById(Long id) {
        return gradesRepository.findById(id);
    }

    @Override
    public Grades findByStudentId(Integer id) {
        return gradesRepository.findByStudentId(id);
    }

    @Override
    public Grades addGrades(Grades grades) {
        return gradesRepository.save(grades);
    }
    @Override
    public Grades updateGrades(Long id, Grades newGrades) {
        Optional<Grades> OptionalCurrentGrades = gradesRepository.findById(id);

        if (OptionalCurrentGrades.isPresent()) {
            Grades currentGrades = gradesRepository.findById(id).get();

            currentGrades.setEnglish(newGrades.getEnglish());
            currentGrades.setRomanian(newGrades.getRomanian());
            currentGrades.setMathematics(newGrades.getMathematics());
            currentGrades.setGeography(newGrades.getGeography());

            return gradesRepository.save(currentGrades);
        } else {
            throw new NoSuchElementException("There are no grades found with id: " + id);
        }
    }
    @Override
    public void deleteGradesById(Long id) {
        if (gradesRepository.findById(id).isPresent()) {
            gradesRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("There are no grades found with id: " + id);
        }

    }

    @Override
    public void deleteAllGrades() {
        gradesRepository.deleteAll();
    }
}
