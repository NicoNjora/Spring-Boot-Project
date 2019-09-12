package com.example.asx.controller;

import com.example.asx.models.Student;
import com.example.asx.services.StudentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping(value = "{id}")
    Student findById(@PathVariable Long id){
        return studentService.findById(id);
    }

    @PostMapping
    Student createStudent(@Validated(Student.Create.class)
                                @RequestBody Student student){
        return studentService.createStudent(student);
    }

    @DeleteMapping(value = "{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.delete(id);
    }

    @PatchMapping
    public Student updateStudent(@Validated(Student.Update.class)
                                       @RequestBody Student student){
        return studentService.update(student);
    }

    @PatchMapping(value = "{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
        return studentService.update(id, student);
    }
}
