package com.patika.dev.services;

import com.patika.dev.dao.StudentDAO;
import com.patika.dev.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService<Student> {



    StudentDAO studentDAO;

    @Autowired
    public StudentServiceImp(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Student update(Student student) {
        return null;
    }
}
