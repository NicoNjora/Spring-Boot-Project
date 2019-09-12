package com.example.asx;

import com.example.asx.models.Course;
import com.example.asx.models.Student;
import com.example.asx.models.University;
import com.example.asx.repositories.CourseRepository;
import com.example.asx.repositories.StudentRepository;
import com.example.asx.repositories.UniversityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DummyData implements CommandLineRunner {

    private final UniversityRepository universityRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public DummyData(UniversityRepository universityRepository,
                     CourseRepository courseRepository,
                     StudentRepository studentRepository) {
        this.universityRepository = universityRepository;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        University strath = new University("Strathmore", "Ole Sangale");

        University jkuat = new University("JKUAT", "JUJA");

        universityRepository.save(strath);
        universityRepository.save(jkuat);

        Course course = courseRepository.save(new Course("Application Programming for the internet"));

        Course dow = courseRepository.save(new Course("Distributed Objects and Web Services"));


        Student student = studentRepository.save(new Student("Nicollet", "Njora", strath));

        course.addStudents(student);
        courseRepository.save(course);

    }
}
