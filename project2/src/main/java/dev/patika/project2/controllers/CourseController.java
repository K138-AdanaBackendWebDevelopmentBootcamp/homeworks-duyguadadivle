package dev.patika.project2.controllers;

import dev.patika.project2.models.Course;
import dev.patika.project2.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    //@Autowired
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    //ok
    @GetMapping("/courses")
    public List<Course> findAllCourses(){
        return courseService.findAllCourses();
    }

    @GetMapping("/courses/{id}")
    public Course findCourseById(@PathVariable Integer id){
        return courseService.findCoursedById(id);
    }

    //ok
    @DeleteMapping("/courses/{id}")
    public String deleteCourseById(@PathVariable("id") Integer id){
        courseService.deleteCourseById(id);

        return "Deleted Successfully";
    }

    @DeleteMapping("/courses/{course}")
    public String deleteOneCourse(@PathVariable("course") Course course){
        courseService.deleteOneCourse(course);
        return "Deleted Successfully";
    }

    @PostMapping("/courses")
    public Course saveOneCourse(@RequestBody Course course){
        return courseService.saveOneCourse(course);
    }

}
