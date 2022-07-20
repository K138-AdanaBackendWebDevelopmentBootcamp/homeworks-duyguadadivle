package com.patika.dev.services;

import com.patika.dev.dao.InstructorDAO;
import com.patika.dev.models.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService<Instructor>{


    InstructorDAO instructorDAO;

    @Autowired
    public InstructorServiceImpl(InstructorDAO instructorDAO) {
        this.instructorDAO = instructorDAO;
    }

    @Override
    public List<Instructor> findAll() {
        return instructorDAO.findAll();
    }

    @Override
    public Instructor findById(int id) {
        return (Instructor) instructorDAO.findById(id);
    }

    @Override
    public Instructor save(Instructor instructor) {
        return (Instructor) instructorDAO.save(instructor);
    }

    @Override
    public void deleteById(int id) {
        instructorDAO.deleteById(id);
    }

    @Override
    public Instructor update(Instructor instructor) {
        return (Instructor) instructorDAO.save(instructor);
    }
}
