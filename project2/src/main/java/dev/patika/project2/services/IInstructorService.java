package dev.patika.project2.services;

import dev.patika.project2.models.Instructor;

import java.util.List;

public interface IInstructorService {

    List<Instructor> findAllInstructors();
    Instructor findInstructorById(Integer id);
    Instructor saveOneInstructor(Instructor instructor);
    Instructor updateOneInstructor(Instructor instructor, Integer id);
    void deleteInstructorById(Integer id);
    void deleteOneInstructor(Instructor instructor);
}
