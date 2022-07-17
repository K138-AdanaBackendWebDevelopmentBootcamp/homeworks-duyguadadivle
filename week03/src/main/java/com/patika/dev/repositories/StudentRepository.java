package com.patika.dev.repositories;

import com.patika.dev.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("FROM Student s WHERE s.id=?1")
    Student findStudent(int id);

    Student findStudentById(int id);
}
