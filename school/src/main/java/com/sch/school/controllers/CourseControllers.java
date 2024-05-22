package com.sch.school.controllers;

import com.sch.school.entity.Course;
import com.sch.school.entity.Grade;
import com.sch.school.entity.Teacher;
import com.sch.school.service.CourseService;
import com.sch.school.service.GradeService;
import com.sch.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseControllers {
    @Autowired
    private CourseService courseService;
    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @PostMapping("/create")
    public Course createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);


    }


    @DeleteMapping("/delete/{id}")// me { do zevendesohet me ni vlere reale
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }

    @PutMapping("/updt/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        return courseService.saveCourse(course);


    }
    @GetMapping("/getCoursesByTeacher")
    public List<Course> getCoursesByTeacher(@RequestParam Long teacherId) {
        // You need to fetch the Teacher object from the database first
        Teacher teacher = teacherService.getTeacherById(teacherId);
        if (teacher != null) {
            return courseService.getCourseByTeacher(teacher);
        } else {
            throw new IllegalArgumentException("Teacher not found with id: " + teacherId);
        }
    }

}
