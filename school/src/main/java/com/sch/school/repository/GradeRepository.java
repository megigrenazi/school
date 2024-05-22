package com.sch.school.repository;

import com.sch.school.entity.Course;
import com.sch.school.entity.Grade;
import com.sch.school.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findByStudent (Student student);
    List<Grade> findByCourse (Course course);

}
