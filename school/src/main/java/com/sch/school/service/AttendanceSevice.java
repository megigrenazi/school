package com.sch.school.service;

import com.sch.school.entity.Attendance;
import com.sch.school.entity.Course;
import com.sch.school.repository.AttendanceRepository;
import com.sch.school.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceSevice {
    //cdo servis dhet te kete te pakten  nje objekt
    @Autowired
    private CourseService courseService;

    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Attendance> getAttendanceByCourseId(Long courseId) {
        Course course = courseService.getCourseById(courseId);
        return attendanceRepository.findByCourse(course);
    }

    public List<Attendance> getAll() {
        return attendanceRepository.findAll();
    }

    //therrsain metodat e gatshme ne repository
    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public Attendance updateAttendance(Long id, Attendance updateattendance) {
        Attendance existingAttendance = attendanceRepository.findById(id).orElse(null);
        if (existingAttendance != null) {
            existingAttendance.setDate(updateattendance.getDate());
            existingAttendance.setPresenceStatus(updateattendance.getPresenceStatus());
            existingAttendance.setStudent(updateattendance.getStudent());
            existingAttendance.setCourse(updateattendance.getCourse());
            return attendanceRepository.save(existingAttendance);

        } else {
            throw new IllegalArgumentException("Attendance not found with id: " + id);

        }
    }

    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}
