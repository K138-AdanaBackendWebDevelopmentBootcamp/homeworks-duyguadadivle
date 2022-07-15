package models;

import javax.persistence.Entity;

@Entity
public class PermanentInstructor extends Instructor{
    private Double fixedSalary;

    public PermanentInstructor(String name, String address, String phoneNumber, Double fixedSalary) {
        super(name, address, phoneNumber);
        this.fixedSalary = fixedSalary;
    }

    public PermanentInstructor() {
    }

    public Double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(Double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    @Override
    public String toString() {
        return "PermanentInstructor{" +
                "fixedSalary=" + fixedSalary +
                '}';
    }
}

