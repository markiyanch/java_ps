package com.project_java_ps.mchakloshl3.controller;

// Importy
import com.project_java_ps.mchakloshl3.model.Student;
import com.project_java_ps.mchakloshl3.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Klasa kontrolera RESTowego dla Studenta
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // Pobranie wszystkich studentów
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(@RequestParam(required = false) String firstName) {
        try {
            List<Student> students = new ArrayList<>();

            if (firstName == null)
                studentRepository.findAll().forEach(students::add);
            else
                studentRepository.findByFirstNameContainingIgnoreCase(firstName).forEach(students::add);

            if (students.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Pobranie studenta po ID
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long id) {
        Optional<Student> studentData = studentRepository.findById(id);

        if (studentData.isPresent()) {
            return new ResponseEntity<>(studentData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Dodanie nowego studenta
    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        try {
            Student _student = studentRepository.save(new Student(
                    student.getFirstName(),
                    student.getLastName(),
                    student.getEmail(),
                    student.getEnrollmentDate(),
                    student.getPassword(),
                    student.getFaculties(),
                    student.isEnrolled()
            ));
            return new ResponseEntity<>(_student, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Aktualizacja danych studenta
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
        Optional<Student> studentData = studentRepository.findById(id);

        if (studentData.isPresent()) {
            Student _student = studentData.get();
            _student.setFirstName(student.getFirstName());
            _student.setLastName(student.getLastName());
            _student.setEmail(student.getEmail());
            _student.setEnrollmentDate(student.getEnrollmentDate());
            _student.setPassword(student.getPassword());
            _student.setFaculties(student.getFaculties());
            _student.setEnrolled(student.isEnrolled());

            return new ResponseEntity<>(studentRepository.save(_student), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Usunięcie studenta po ID
    @DeleteMapping("/students/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("id") long id) {
        try {
            studentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Usunięcie wszystkich studentów
    @DeleteMapping("/students")
    public ResponseEntity<HttpStatus> deleteAllStudents() {
        try {
            studentRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Pobranie studentów, którzy są zapisani
    @GetMapping("/students/enrolled")
    public ResponseEntity<List<Student>> findEnrolledStudents() {
        try {
            List<Student> students = studentRepository.findByEnrolled(true);

            if (students.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
