package services;

import models.Course;
import models.Student;
import repositories.CrudRepository;
import repositories.StudentRepository;
import utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentService implements CrudRepository<Student> , StudentRepository {

    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Student> findAll() {
        List<Student> studentList = em.createQuery("FROM Student", Student.class).getResultList();
        return studentList;
    }

    @Override
    public Student findById(int id) {
        return em.find(Student.class, id);
    }

    @Override
    public void saveToDatabase(Student student) {
        try{
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {

        }
    }

    @Override
    public void deleteFromDatabase(Student student) {
        try{
            em.getTransaction().begin();

            em.remove(student);
            System.out.println("Deleted..");

            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {

        }
    }

    @Override
    public void deleteFromDatabase(int id) {

        try{
            em.getTransaction().begin();

            Student foundStudent = findById(id);

            em.remove(foundStudent);
            System.out.println("Deleted..");

            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {

        }

    }

    @Override
    public void updateOnDatabase(Student student, int id) {

        try{
            em.getTransaction().begin();

            em.merge(student);

            em.getTransaction().commit();
            System.out.println("Deleted..");
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {

        }

    }

    @Override
    public void deleteStudentWithId(int id) {

        try{
            em.getTransaction().begin();

            Student foundStudent = em.createQuery("FROM Student s WHERE s.id =:stdId", Student.class)
                    .setParameter("stdId", id)
                    .getSingleResult();
            em.remove(foundStudent);



            em.getTransaction().commit();
            System.out.println("Deleted..");
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {

        }

    }

    @Override
    public List<Course> getStudentCourseList(Student student) {
        Student foundStudent = em.find(Student.class, student.getId());
        return foundStudent.getCourseList();
    }
}
