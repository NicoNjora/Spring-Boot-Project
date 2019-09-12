package com.example.asx.services;

import com.example.asx.models.Student;
import com.example.asx.models.University;

import java.util.List;

public interface UniversityService {

    List<University> findAll();

    University findById(Long id);

    void delete(Long id);

    University createUniversity(University university);

    University update(University university);

    University update(Long id, University university);

    Student createStudent(Long id, Student student);
}
