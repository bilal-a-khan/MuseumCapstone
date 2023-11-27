package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "art_type", discriminatorType = DiscriminatorType.STRING)
@Entity
@Data
public abstract class Art {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

//    @ManyToOne
//    @JsonBackReference
    private Artist artist;

    @Enumerated(value = EnumType.STRING)
    private Medium medium;
//    @ManyToOne
//    @JsonBackReference
    private Museum museum;
    private int yearCompleted;
    private String backStory;
}
