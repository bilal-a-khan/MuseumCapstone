package com.example.dto;

import com.example.model.Art;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
public class ArtistDto {

    private Long id;
    private String name;
    private int yearBorn;
    private int yearDead;

    private List<ArtDto> artList;

    public ArtistDto(Long id, String name, int yearBorn, int yearDead) {
        this.id = id;
        this.name = name;
        this.yearBorn = yearBorn;
        this.yearDead = yearDead;
        // this.artList = Collections.emptyList();
    }
}
