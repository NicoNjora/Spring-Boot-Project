package com.example.asx.services;

import com.example.asx.models.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(Long id);

    void delete(Long id);

    Student createStudent(Student student);

    Student update(Student student);

    Student update(Long id, Student student);
}
