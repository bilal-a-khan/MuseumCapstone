package com.example.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Artist extends Person{

    private int yearDead;

    public Artist(String name){
        this.setName(name);
    }

    public Artist(String name, int yearBorn, int yearDead){
        super(name, yearBorn);
        this.yearDead = yearDead;
    }

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
  //  @JsonManagedReference(value = "art-artist")
    @JsonIgnore
    private List<Art> artList;

//    public int getArtCount(){
//        return this.artList.size();
//    }

}
