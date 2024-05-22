package com.sch.school.controllers;

import com.sch.school.entity.Grade;
import com.sch.school.entity.Student;
import com.sch.school.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @GetMapping
    public List<Grade> getAllGrade() {
        return gradeService.getAll();
    }

    @PostMapping("/create")
    public Grade createGrade(@RequestBody Grade grade) {
        return gradeService.saveGrade(grade);


    }


    @DeleteMapping("/delete/{id}")// me { do zevendesohet me ni vlere reale
    public void deleteGrade(@PathVariable Long id) {
        gradeService.deleteGrade(id);
    }

    @PutMapping("/updt/{id}")
    public Grade updateGrade(@PathVariable Long id, @RequestBody Grade grade) {
        return gradeService.saveGrade(grade);


    }
    @GetMapping("/student/{studentId}")
    public List<Grade> getGradesByStudent(@PathVariable Long studentId) {
        return gradeService.getGradeByStudent(studentId);
    }
    @GetMapping("/course/{courseId}")
    public List<Grade> getGradesByCourse(@PathVariable Long courseId) {
        return gradeService.getGradeByCourse(courseId);
    }

}
