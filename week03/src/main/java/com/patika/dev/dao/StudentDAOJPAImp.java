package com.patika.dev.dao;

import com.patika.dev.models.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class StudentDAOJPAImp implements StudentDAO<Student> {


    EntityManager entityManager;

    //@Autowired
    public StudentDAOJPAImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public List<Student> findAll() {

        return entityManager.createQuery("From Student", Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public Student save(Student object) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Student update(Student object) {
        return null;
    }
}
