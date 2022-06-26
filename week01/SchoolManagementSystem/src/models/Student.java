package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {
    private String name;
    private LocalDate bithday;
    private String address;
    private String gender;


    private List<Course> courseList = new ArrayList<>();


    public Student(String name, LocalDate bithday, String address, String gender) {
        this.name = name;
        this.bithday = bithday;
        this.address = address;
        this.gender = gender;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBithday() {
        return bithday;
    }

    public void setBithday(LocalDate bithday) {
        this.bithday = bithday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name) && bithday.equals(student.bithday) && address.equals(student.address) && gender.equals(student.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, bithday, address, gender);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", bithday=" + bithday +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
