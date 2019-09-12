package com.example.asx.services;

import com.example.asx.NotFoundException;
import com.example.asx.models.Student;
import com.example.asx.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(()-> new NotFoundException("No student with id " +id +" found"));
    }

    @Override
    public void delete(Long id){
        studentRepository.deleteById(id);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student) {
        Student found = findById(student.getId());

        found.setDob(student.getDob());
        found.setLast_name(student.getLast_name());
        found.setFirst_name(student.getFirst_name());
        return studentRepository.save(found);
    }

    @Override
    public Student update(Long id, Student student) {
        Student found = findById(id);
        found.setDob(student.getDob());
        found.setLast_name(student.getLast_name());
        found.setFirst_name(student.getFirst_name());
        return studentRepository.save(found);
    }
}
