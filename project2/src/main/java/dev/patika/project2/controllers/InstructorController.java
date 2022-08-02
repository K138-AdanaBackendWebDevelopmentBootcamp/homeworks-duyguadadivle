package dev.patika.project2.controllers;

import dev.patika.project2.models.Instructor;
import dev.patika.project2.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstructorController {

    InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;

    }


    @GetMapping("/instructors")
    public List<Instructor> findAll(){
        return instructorService.findAllInstructors();
    }

    @GetMapping("/instructors/{id}")
    public Instructor findInstructorById(@PathVariable Integer id){
        return instructorService.findInstructorById(id);
    }


    @DeleteMapping("/instructors/{id}")
    public String deleteInstructorById(@PathVariable("id") Integer id){
        instructorService.deleteInstructorById(id);

        return "Deleted Successfully";
    }


    @DeleteMapping("/instructors/{instructors}")
    public String deleteOneInstructor(@PathVariable("instructor") Instructor instructor){
        instructorService.deleteOneInstructor(instructor);
        return "Deleted Successfully";
    }

    @PostMapping("/instructors")
    public Instructor saveOneInstructor(@RequestBody Instructor instructor){
        return instructorService.saveOneInstructor(instructor);
    }

}
