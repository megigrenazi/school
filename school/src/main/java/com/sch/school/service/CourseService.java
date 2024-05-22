package com.sch.school.service;

import com.sch.school.entity.Attendance;
import com.sch.school.entity.Course;
import com.sch.school.entity.Teacher;
import com.sch.school.repository.AttendanceRepository;
import com.sch.school.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAll() {

        return courseRepository.findAll();
    }

    public Course saveCourse(Course course) {

        return courseRepository.save(course);
    }

    public Course getCourseById(Long id) {

        return courseRepository.findById(id).orElse(null);
    }

    public List<Course> getCourseByTeacher(Teacher teacher) {
        return courseRepository.findByTeacher(teacher);
    }


    public Course updateCourse(Long id, Course updatecourse) {
        Course existingCourse = courseRepository.findById(id).orElse(null);
        if (existingCourse != null) {
            existingCourse.setName(updatecourse.getName());
            existingCourse.setDescription(updatecourse.getDescription());
            existingCourse.setSchedule(updatecourse.getSchedule());
            existingCourse.setTeacher(updatecourse.getTeacher());
            return courseRepository.save(existingCourse);
        } else {
            throw new IllegalArgumentException("Course not found with id: " + id);
        }
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
