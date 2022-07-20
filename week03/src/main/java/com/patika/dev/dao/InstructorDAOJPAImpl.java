package com.patika.dev.dao;

import com.patika.dev.exceptions.AllreadyExistsExceptions;
import com.patika.dev.models.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class InstructorDAOJPAImpl implements  InstructorDAO<Instructor>{

    EntityManager entityManager;

    //@Autowired
    public InstructorDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public List<Instructor> findAll() {
        return entityManager.createQuery("From Instructor", Instructor.class).getResultList();
    }

    @Transactional
    @Override
    public Instructor findById(int id) {
        return (Instructor) entityManager.createQuery("From Instructor i Where i.id =:idParam")
                .setParameter("idParam",id).getSingleResult();
    }

    @Transactional
    @Override
    public Instructor save(Instructor instructor) {
        // checkingObjectExistence(instructor);
        // return entityManager.merge(instructor);

        List<Instructor> instructorList = entityManager.createQuery("From Instructor i Where i.id =:id", Instructor.class)
                .setParameter("id", instructor.getId()).getResultList();
        if(instructorList.size() > 0) {
            throw new AllreadyExistsExceptions("Instructor is already exists with id no : " + instructor.getId());
        }
        return entityManager.merge(instructor);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        Instructor foundInstructor = this.findById(id);
        entityManager.remove(foundInstructor);
    }

    @Transactional
    @Override
    public Instructor update(Instructor instructor) {
        return entityManager.merge(instructor);
    }
}
