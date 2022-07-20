package com.patika.dev.services;

import com.patika.dev.dao.CourseDAO;
import com.patika.dev.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService<Course> {


    CourseDAO courseDAO;

    @Autowired
    public CourseServiceImpl(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public List<Course> findAll() {
        return courseDAO.findAll();
    }

    @Override
    public Course findById(int id) {
        return (Course) courseDAO.findById(id);
    }

    @Override
    public Course save(Course course) {
        return (Course) courseDAO.save(course);
    }

    @Override
    public void deleteById(int id) {
        courseDAO.deleteById(id);
    }

    @Override
    public Course update(Course course) {
        return (Course) courseDAO.save(course);
    }
}
