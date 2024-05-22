package com.sch.school.controllers;

import com.sch.school.entity.Teacher;
import com.sch.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
//aksesim url ne google
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.findAll();
    }
    @GetMapping("/search")
    public List<Teacher> getTeacherByFirstName(@RequestParam String firstname) {
        return teacherService.findTeacherByName(firstname);

    }
    @PostMapping("/create")
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherService.saveTeacher(teacher);
    }
    @DeleteMapping("/delete/{id}")// me { do zevendesohet me ni vlere reale
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }
}
