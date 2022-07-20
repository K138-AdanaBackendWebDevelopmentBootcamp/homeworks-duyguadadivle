package com.patika.dev.dao;

import com.patika.dev.exceptions.AllreadyExistsExceptions;
import com.patika.dev.models.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CourseDAOJPAImpl implements CourseDAO<Course> {


    EntityManager entityManager;


    public CourseDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public List<Course> findAll() {
        return entityManager.createQuery("From Course", Course.class).getResultList();
    }

    @Transactional
    @Override
    public Course findById(int id) {
        //return entityManager.find(Course.class, Long.valueOf(id));
        return (Course) entityManager.createQuery("From Course c Where c.id =:idParam")
                .setParameter("idParam",id).getSingleResult();
    }

    @Transactional
    @Override
    public Course save(Course course) {
        List<Course> courseList = entityManager.createQuery("From Course c Where c.id =:id", Course.class)
                .setParameter("id", course.getId()).getResultList();
        if(courseList.size() > 0) {
            throw new AllreadyExistsExceptions("Course is already exists with id no : " + course.getId());
        }
        return entityManager.merge(course);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        Course foundCourse = this.findById(id);
        entityManager.remove(foundCourse);
    }

    @Transactional
    @Override
    public Course update(Course course) {
        return entityManager.merge(course);
    }
}
