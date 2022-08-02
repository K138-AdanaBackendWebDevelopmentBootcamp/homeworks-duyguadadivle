package dev.patika.project2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate birthday;
    private String address;
    private String gender;


    @JsonIgnore
    @ManyToMany(mappedBy = "studentList")
    private List<Course> courseList = new ArrayList<>();


    public Student(String name, LocalDate birthday, String address, String gender) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.gender = gender;
    }
}
