package com.patika.dev.utils;

import com.patika.dev.models.*;
import com.patika.dev.repositories.CourseRepository;
import com.patika.dev.repositories.InstructorRepository;
import com.patika.dev.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;



@Component
@RequiredArgsConstructor
public class InitializerRunner implements CommandLineRunner {


    private static final Logger logger = LoggerFactory.getLogger(InitializerRunner.class);

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;


    @Override
    @Transactional
    public void run(String... args) throws Exception {


        studentRepository.deleteAll();
        courseRepository.deleteAll();
        instructorRepository.deleteAll();



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




        studentRepository.save(student1);
        studentRepository.save(student2);
        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);
        courseRepository.save(course4);
        instructorRepository.save(permanentInstructor1);
        instructorRepository.save(permanentInstructor2);
        instructorRepository.save(visitingResearcher1);
        instructorRepository.save(visitingResearcher2);

        logger.info("All test data saved..");



    }
}
