package com.patika.dev.dao;

import com.patika.dev.exceptions.AllreadyExistsExceptions;
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
        return (Student) entityManager.createQuery("From Student s Where s.id =:idParam")
                .setParameter("idParam",id).getSingleResult();
    }

    @Transactional
    @Override
    public Student save(Student student) {
        // checkingObjectExistence(student);
        // return entityManager.merge(student); //persist return type void. persist just save. but in merge if object exists, fistly is updated and than is saved.

        List<Student> studentList = entityManager.createQuery("From Student s Where s.id =:id", Student.class)
                .setParameter("id", student.getId()).getResultList();
        if(studentList.size() > 0) {
            throw new AllreadyExistsExceptions("Employee is already exists with id no : " + student.getId());
        }
        return entityManager.merge(student);
    }



    @Transactional
    @Override
    public void deleteById(int id) {
        Student foundStudent = this.findById(id);
        entityManager.remove(foundStudent);
    }

    @Transactional
    @Override
    public Student update(Student student) {
        return entityManager.merge(student);
    }


    private void checkingObjectExistence(Student student){

        List<Student> foundStudents = entityManager.createQuery("FROM Student s WHERE s.name =:nameParam AND s.bithday=:birthDateParam AND s.address=:addressParam",Student.class)
                .setParameter("nameParam",student.getName())
                .setParameter("bithDateParam",student.getBithday())
                .setParameter("addressParam",student.getAddress())
                .getResultList();
        if(foundStudents.size() > 0)
            throw new AllreadyExistsExceptions(""+student+"\n"+"this student already exists !");
    }




}
