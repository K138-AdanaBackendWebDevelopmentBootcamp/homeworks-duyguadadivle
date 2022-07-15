package client;

import controllers.StudentController;
import models.*;
import utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class TestInsuranceClient {

    public static void main(String[] args) {
        if(checkTestData() == 0){
            saveTestData();
        }


        StudentController studentController = new StudentController();

        // Student newStudent = new Student("Selma", LocalDate.of(2001,05,2), "İzmir", "kadın");
        // studentController.saveStudent(newStudent);



        // studentController.deleteStudent(studentList.get(2));
        // studentController.deleteStudent(1);
        // studentController.deleteStudentWithPrimaryId(2);

        List<Student> studentList = studentController.findAllStudents();

        Student foundStudent = studentList.get(0);

        List<Course> courseList = studentController.getStudentCourseList(foundStudent);
        for (Course course : courseList) {
            System.out.println(course);
        }

        // foundStudent.setName("duygu ada");
        // studentController.updateStudent(foundStudent, foundStudent.getId());


        /*for (Student student : studentList) {
            System.out.println(student);
        }*/


       // System.out.println("-----------------------");

       // for (int i = 0; i < studentList.size(); i++) {
       //     System.out.println(studentList.get(i));

       // }

       // System.out.println("-----------------------");

       // Iterator<Student> studentIterator = studentList.iterator();
       // while (studentIterator.hasNext()){
       //     System.out.println(studentIterator.next());
       // }

       // System.out.println("-----------------------");

        /*studentList.forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.println(student);
            }
        });*/

        //lamda expression
        //studentList.forEach((s) -> System.out.println(s));
        //studentList.forEach(System.out::println);


        // findById
        // System.out.println(studentController.findStudentById(1));


    }

    private static int checkTestData() {
        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
        return em.createQuery("FROM Student", Student.class).getResultList().size();
    }

    private static void saveTestData() {

        Student student1 = new Student("Duygu", LocalDate.of(1997,11,2), "Adana", "kadın");
        Student student2 = new Student("Ada", LocalDate.of(1990,11,2), "Mersin", "kadın");

        Course course1 = new Course("Math", "CEN123",6);
        Course course2 = new Course("Algorithm", "CEN124",6);
        Course course3 = new Course("Digital", "CEN987",6);
        Course course4 = new Course("Electronics", "CEN986",6);

        Instructor permanentInstructor1 = new PermanentInstructor("Ayşe", "Adana", "5435434343", 500000.0);
        Instructor permanentInstructor2 = new PermanentInstructor("Fatma", "İstanbul", "5213212121", 400000.0);

        Instructor visitingResearcher1 = new VisitingResearcher("Eda", "Mersin", "5435434343", 300000.0);
        Instructor visitingResearcher2 = new VisitingResearcher("Ece", "Hatay", "5906787878", 500000.0);


        course1.setInstructor(permanentInstructor1);
        course2.setInstructor(permanentInstructor2);
        course3.setInstructor(visitingResearcher1);
        course4.setInstructor(visitingResearcher2);

        course1.getStudentList().add(student1);
        course2.getStudentList().add(student1);
        course3.getStudentList().add(student2);
        course4.getStudentList().add(student2);

        //permanentInstructor1.getCourseList().add(course1);
        //permanentInstructor2.getCourseList().add(course2);
        //visitingResearcher1.getCourseList().add(course3);
        //visitingResearcher1.getCourseList().add(course4);


        // persistance-unit in META-INF persistence.xml
        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        // start transaction
        // persist
        // save in DB with commit keyword



        try{
            System.out.printf("All data persisted...");

            em.getTransaction().begin();

            em.persist(student1);
            em.persist(student2);
            em.persist(course1);
            em.persist(course2);
            em.persist(course3);
            em.persist(course4);
            em.persist(permanentInstructor1);
            em.persist(permanentInstructor2);
            em.persist(visitingResearcher1);
            em.persist(visitingResearcher2);


            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            EntityManagerUtils.closeEntityManager(em);
        }


    }
}
