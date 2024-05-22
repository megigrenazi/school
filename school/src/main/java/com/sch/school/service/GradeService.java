package com.sch.school.service;

import com.sch.school.entity.Course;
import com.sch.school.entity.Grade;
import com.sch.school.entity.Student;
import com.sch.school.entity.Teacher;
import com.sch.school.repository.CourseRepository;
import com.sch.school.repository.GradeRepository;
import com.sch.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private StudentService studentService1;
    @Autowired
    private CourseService courseService1;

    public List<Grade> getAll() {
        return gradeRepository.findAll();
    }
    public Grade saveGrade(Grade grade) {
        return gradeRepository.save(grade);
    }


    public Grade updateGrade(Long id, Grade updategrade) {
        Grade existingGrade = gradeRepository.findById(id).orElse(null);
        if (existingGrade != null) {
            existingGrade.setGrade(updategrade.getGrade());
            existingGrade.setType(updategrade.getType());
            existingGrade.setStudent(updategrade.getStudent());
            existingGrade.setCourse(updategrade.getCourse());
            return gradeRepository.save(existingGrade);
        }else{
            throw new IllegalArgumentException("Course not found with id: "+id);
        }
    }
    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }
    public List<Grade> getGradeByStudent(Long student_id) {
        Student student = studentService1.getStudentById(student_id);

        return gradeRepository.findByStudent(student);
    }
    public List<Grade> getGradeByCourse(Long course_id) {
        Course course = courseService1.getCourseById(course_id);

        return gradeRepository.findByCourse(course);
    }
}

