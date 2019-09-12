package com.example.asx.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name= "student_courses",
        joinColumns = @JoinColumn(name = "Course_id"),
        inverseJoinColumns = @JoinColumn(name="student_id")
    )
    @JsonIgnore
    private Set<Student> students = new HashSet<>();

    public Course(String name) {
        this.name = name;
    }

    private Course(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void addStudents(Student student){
        students.add(student);
    }
}
