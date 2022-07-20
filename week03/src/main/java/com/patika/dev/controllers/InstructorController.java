package com.patika.dev.controllers;

import com.patika.dev.models.Instructor;
import com.patika.dev.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstructorController {
    InstructorService instructorService;


    //@Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }


    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> getAllStudents(){
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/instructors/{id}")
    public ResponseEntity <Instructor> getInstructorById(@PathVariable int id){
        return new ResponseEntity<> ((Instructor) instructorService.findById(id), HttpStatus.OK);
    }


    @PostMapping("/instructors")
    public ResponseEntity<Instructor> saveInstructor(@RequestBody Instructor instructor){
        return new ResponseEntity<>((Instructor) instructorService.save(instructor), HttpStatus.OK);
    }


    @PutMapping("/instructors/{id}")
    public ResponseEntity<Instructor> updateInstructor(@RequestBody Instructor instructor, @PathVariable int id){
        return new ResponseEntity<>((Instructor) instructorService.update(instructor), HttpStatus.OK);
    }


    @DeleteMapping("/instructors/{id}")
    public String deleteInstructorById(@PathVariable int id){
        instructorService.deleteById(id);
        return "Deleted.";
    }

}
