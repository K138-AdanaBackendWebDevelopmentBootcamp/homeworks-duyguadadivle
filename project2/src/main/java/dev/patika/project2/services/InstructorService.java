package dev.patika.project2.services;

import dev.patika.project2.models.Instructor;
import dev.patika.project2.repositories.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService implements IInstructorService{

    //@Autowired
    InstructorRepository instructorRepository;

    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> findAllInstructors() {
        return (List<Instructor>) instructorRepository.findAll();
    }

    @Override
    public Instructor findInstructorById(Integer id) {
        return null;
    }

    @Override
    public Instructor saveOneInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateOneInstructor(Instructor instructor, Integer id) {
        return null;
    }

    @Override
    public void deleteInstructorById(Integer id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public void deleteOneInstructor(Instructor instructor) {
        instructorRepository.delete(instructor);
    }
}
