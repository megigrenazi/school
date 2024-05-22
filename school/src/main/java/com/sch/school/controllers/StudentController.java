package com.sch.school.controllers;

import com.sch.school.entity.Student;
import com.sch.school.entity.Teacher;
import com.sch.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/getbyid/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/search")
    public List<Student> getStudentByFirstName(@RequestParam String firstname) {
        return studentService.findStudentByName(firstname);

    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);


    }


    @DeleteMapping("/delete/{id}")// me { do zevendesohet me ni vlere reale
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/updt/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student student1 = studentService.getStudentById(id);
        if (student1 == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "STUDENT NOT FOUND WITH ID" + id
            );
        }
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());
        student1.setDateOfBirth(student.getDateOfBirth());
        return studentService.saveStudent(student1);


    }





}


