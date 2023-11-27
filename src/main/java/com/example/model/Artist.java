package com.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Artist extends Person{

    private int yearDead;

    public Artist(String name, int yearBorn, int yearDead){
        super(name, yearBorn);
        this.yearDead = yearDead;
    }

    @OneToMany(mappedBy = "artist")
    @JsonManagedReference
    private List<Art> artList;

}
