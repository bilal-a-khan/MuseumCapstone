package com.example.model;


import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@MappedSuperclass
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int yearBorn;

    public Person(String name, int dateOfBirth){
        this.name = name;
        this.yearBorn = yearBorn;
    }

}
