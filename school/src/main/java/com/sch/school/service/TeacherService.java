package com.sch.school.service;

import com.sch.school.entity.Course;
import com.sch.school.entity.Teacher;
import com.sch.school.repository.CourseRepository;
import com.sch.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

public List<Teacher> findAll() {
    return teacherRepository.findAll();
}

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);

    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);


    }
    public List<Teacher> findTeacherByName(String name) {
        return teacherRepository.findTeacherByFirstName(name);
    }
}
