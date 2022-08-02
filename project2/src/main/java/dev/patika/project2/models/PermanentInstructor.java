package dev.patika.project2.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Entity
@Data
@NoArgsConstructor
public class PermanentInstructor extends Instructor{

    private Double fixedSalary;

    public PermanentInstructor(Double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public PermanentInstructor(String name, String address, String phoneNumber, Double fixedSalary) {
        super(name, address, phoneNumber);
        this.fixedSalary = fixedSalary;
    }
}
