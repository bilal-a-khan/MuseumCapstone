package com.example.dto;

import com.example.model.Art;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@AllArgsConstructor
public class ArtistDto {

    private Long id;
    private String name;
    private int yearBorn;
    private int yearDead;

    private List<ArtDto> artList;


    public ArtistDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
