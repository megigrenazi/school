package com.sch.school.repository;

import com.sch.school.entity.Attendance;
import com.sch.school.entity.Course;
import com.sch.school.entity.Grade;
import com.sch.school.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Long> { //merr entitetin e attendenc dhe data type e pk

    List<Attendance> findByStudent (Student student);
    List<Attendance> findByCourse (Course course);


}
