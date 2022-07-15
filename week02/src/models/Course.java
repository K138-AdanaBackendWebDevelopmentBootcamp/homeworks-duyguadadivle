package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String courseName;
    private String courseCode;
    private Integer creditScore;

    @ManyToMany
    private List<Student> studentList = new ArrayList<>();

    @ManyToOne
    private Instructor instructor;

    public Course(String courseName, String courseCode, Integer creditScore) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditScore = creditScore;
    }

    public Course() {
    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Integer getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }


    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseCode.equals(course.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", creditScore=" + creditScore +
                '}';
    }
}
