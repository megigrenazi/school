package com.sch.school.controllers;

import com.sch.school.entity.Attendance;
import com.sch.school.repository.AttendanceRepository;
import com.sch.school.service.AttendanceSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendaceControllers {
    @Autowired
    private AttendanceSevice attendanceService;
    @GetMapping("/getAllAttendances")
    public List<Attendance> getAllAttendances() {
        return attendanceService.getAll();
    }
    @GetMapping("/course/{courseId}")
    public List<Attendance> getAttendancesByCourse(@PathVariable Long courseId) {
        return attendanceService.getAttendanceByCourseId(courseId);
    }
    @PostMapping("/create")
    public Attendance createAttendance(@RequestBody Attendance attendance) {
        return attendanceService.saveAttendance(attendance);
    }
    @PutMapping("/update/{id}")
    public Attendance updateAttendance(@PathVariable Long id, @RequestBody Attendance attendance) {
        return attendanceService.updateAttendance(id, attendance);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteAttendanceById(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
    }


}
