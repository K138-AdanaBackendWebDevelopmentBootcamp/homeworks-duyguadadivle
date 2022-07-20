package com.patika.dev.controllers;

import com.patika.dev.models.Student;
import com.patika.dev.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
        return new ResponseEntity<>((Student) studentService.findById(id), HttpStatus.OK);
    }


    @PostMapping("/students")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<>((Student) studentService.save(student), HttpStatus.OK);
    }


    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int id){
        return new ResponseEntity<>((Student) studentService.update(student), HttpStatus.OK);
    }


    @DeleteMapping("/students/{id}")
    public String deleteStudentById(@PathVariable int id){
        studentService.deleteById(id);
        return "Deleted.";
    }


}
