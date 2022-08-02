package dev.patika.project2.services;

import dev.patika.project2.models.Course;
import dev.patika.project2.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CourseService implements ICourseService{

    //@Autowired
    CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findCoursedById(Integer id) {
        return null;
    }


    @Override
    public Course saveOneCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateOneCourse(Course course, Integer id) {
        return null;
    }

    @Override
    public void deleteCourseById(Integer id) {
        courseRepository.deleteById(id);
    }

    @Override
    public void deleteOneCourse(Course course) {
        courseRepository.delete(course);
    }


}
