package com.sch.school.entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Teacher {
    @Id  //percakton se kush eshte pk
    @GeneratedValue(strategy =  GenerationType.IDENTITY)  //sherben qe fusha qe eshte posht ksaj qe te increment , dhe sherben qe do sherbej si entitet i tabeles qe po punoj momentalisht
    //gjeja e pare shtojme siper klases entity
    private Long id;
    private String firstName;
    private String lastName;
    private String qualification;
    //si cdo tabel duhet te kete nje primery key per mos te hedhur error
    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;

    public Teacher() {
    }

    public Teacher(Long id, String firstName, String lastName, String qualification) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.qualification = qualification;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "qualification='" + qualification + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
