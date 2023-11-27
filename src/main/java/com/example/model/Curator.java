package com.example.model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Curator extends Person{

    public Curator(String name, int yearBorn){
        super(name, yearBorn);
    }
}
