package dev.patika.project2.services;

import dev.patika.project2.models.Course;

import java.util.List;
import java.util.Optional;

public interface ICourseService {

    List<Course> findAllCourses();
    Course findCoursedById(Integer id);
    Course saveOneCourse(Course course);
    Course updateOneCourse(Course course, Integer id);
    void deleteCourseById(Integer id);
    void deleteOneCourse(Course course);


}
