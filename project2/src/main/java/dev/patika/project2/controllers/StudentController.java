package dev.patika.project2.controllers;

import dev.patika.project2.models.Student;
import dev.patika.project2.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    //@Autowired
    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> findAllStudents(){
        return studentService.findAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student findStudentById(@PathVariable Integer id){
        return studentService.findStudentById(id);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudentById(@PathVariable("id") Integer id){
        studentService.deleteStudentById(id);

        return "Deleted Successfully";
    }

    @DeleteMapping("/{students}/{student}")
    public String deleteOneStudent(@PathVariable("student") Student student){
        studentService.deleteOneStudent(student);
        return "Deleted Successfully";
    }

    @PostMapping("/students")
    public Student saveOneStudent(@RequestBody Student student){
        return studentService.saveOneStudent(student);
    }



}
