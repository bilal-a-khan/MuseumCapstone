package com.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Data
public abstract class Art {
    @Id
    @GeneratedValue
    private Long id;
    String name;
    Artist artist;
    Medium medium;
    int yearCompleted;
    String backStory;
}
