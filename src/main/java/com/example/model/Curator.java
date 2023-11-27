package com.example.model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Curator extends Person{

    public Curator(String name, int yearBorn){
        super(name, yearBorn);
    }

    @OneToOne(mappedBy = "curator")
    private Museum museum;
}
