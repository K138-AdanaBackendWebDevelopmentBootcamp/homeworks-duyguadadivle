package controllers;

import models.Course;
import models.Student;
import services.StudentService;

import java.util.List;

public class StudentController {

    private StudentService studentService = new StudentService();

    public List<Student> findAllStudents(){
        return studentService.findAll();
    }

    public Student findStudentById(int id){
        return studentService.findById(id);
    }

    public void saveStudent(Student student){
        studentService.saveToDatabase(student);
    }

    public void deleteStudent(Student student){
        studentService.deleteFromDatabase(student);
    }

    public void deleteStudent(int id){
        studentService.deleteFromDatabase(id);
    }

    public void deleteStudentWithPrimaryId(int id){
        studentService.deleteStudentWithId(id);
    }

    public void updateStudent(Student student, int id){
        studentService.updateOnDatabase(student, id);
    }

    public List<Course> getStudentCourseList(Student student) {
        return studentService.getStudentCourseList(student);
    }


}
