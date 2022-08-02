package dev.patika.project2.services;

import dev.patika.project2.models.Student;
import dev.patika.project2.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{

    //@Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<Student> findAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student findStudentById(Integer id) {
        return null;
    }

    @Override
    public Student saveOneStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateOneStudent(Student student, Integer id) {
        return null;
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteOneStudent(Student student) {
        studentRepository.delete(student);
    }
}
