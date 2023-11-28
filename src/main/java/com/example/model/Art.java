package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "art_type", discriminatorType = DiscriminatorType.STRING)
@Entity
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public abstract class Art {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
  //  @JsonBackReference(value = "art-artist")
    private Artist artist;

    @Enumerated(value = EnumType.STRING)
    private Medium medium;

    @ManyToOne
    @JsonBackReference
    private Museum museum;

    private int yearCompleted;
    private String backStory;
}
