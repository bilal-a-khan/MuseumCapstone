package com.example.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Artist extends Person{

    private int yearDead;

    public Artist(String name, int yearBorn, int yearDead){
        super(name, yearBorn);
        this.yearDead = yearDead;
    }


}
