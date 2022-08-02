package repositories;

import models.Course;
import models.Student;

import java.util.List;

public interface StudentRepository {

    void deleteStudentWithId(int id);

    List<Course> getStudentCourseList(Student student);


}
