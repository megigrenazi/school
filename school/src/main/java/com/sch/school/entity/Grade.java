package com.sch.school.entity;

import jakarta.persistence.*;

@Entity
public class Grade {
    @Id  //percakton se kush eshte pk
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private double grade;
    private String type;
    @ManyToOne
    @JoinColumn(name="student_id", nullable=false)//nuk e lejojme qe te jete null sepse do hidhet error sepse nje note nuk mun te ekzistoje pa nje student
    private Student student;
    @ManyToOne
    @JoinColumn(name="course_id", nullable=false)
    private Course course;

    //duke qene se nuk mbajme dot te gjitha te dhenat e studentit do  mbajme vetem id prnd do ndertojme nje join colum

    public Grade() {
    }

    public Grade(Long id, double grade, String type, Student student, Course course) {
        this.id = id;
        this.grade = grade;
        this.type = type;
        this.student = student;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", grade=" + grade +
                ", type='" + type + '\'' +
                ", student=" + student +
                ", course=" + course +
                '}';
    }
}
