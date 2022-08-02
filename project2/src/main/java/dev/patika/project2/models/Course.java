package dev.patika.project2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String courseName;
    private String courseCode;
    private Integer creditScore;


    @JsonIgnore //
    @ManyToMany
    private List<Student> studentList = new ArrayList<>();

    @JsonIgnore //
    @ManyToOne
    private Instructor instructor;

    public Course(String courseName, String courseCode, Integer creditScore) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditScore = creditScore;
    }


}
