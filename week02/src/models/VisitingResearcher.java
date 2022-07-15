package models;

import javax.persistence.Entity;

@Entity
public class VisitingResearcher extends Instructor{
    private Double hourlySalary;


    public VisitingResearcher(String name, String address, String phoneNumber, Double hourlySalary) {
        super(name, address, phoneNumber);
        this.hourlySalary = hourlySalary;
    }

    public VisitingResearcher() {
    }

    public Double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(Double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    @Override
    public String toString() {
        return "VisitingResearcher{" +
                "hourlySalary=" + hourlySalary +
                '}';
    }
}
