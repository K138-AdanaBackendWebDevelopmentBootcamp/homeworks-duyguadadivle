package com.patika.dev.controllers;

import com.patika.dev.models.Course;
import com.patika.dev.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses(){
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }



    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable int id){
        return new ResponseEntity<>((Course) courseService.findById(id), HttpStatus.OK);
    }


    @PostMapping("/courses")
    public ResponseEntity<Course> saveCourse (@RequestBody Course course){
        return new ResponseEntity<>((Course) courseService.save(course), HttpStatus.OK);
    }


    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable int id){
        return new ResponseEntity<>((Course) courseService.update(course), HttpStatus.OK);
    }

    @DeleteMapping("/courses/{id}")
    public String deleteCourseById(@PathVariable int id){
        courseService.deleteById(id);
        return "Deleted.";
    }



}
