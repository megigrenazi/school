package com.sch.school.service;

import com.sch.school.entity.Student;
import com.sch.school.entity.Teacher;
import com.sch.school.repository.StudentRepository;
import com.sch.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);

    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);


    }
    public List<Student> findStudentByName(String name) {
        return studentRepository.findStudentByFirstName(name);
    }
}


