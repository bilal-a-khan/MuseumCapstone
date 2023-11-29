package com.example.dto;

import com.example.model.Artist;
import com.example.model.Medium;
import com.example.model.Museum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArtDto {

    private Long id;
    private String name;

    @JsonIgnore
    private Artist artist;

    @Enumerated(value = EnumType.STRING)
    private Medium medium;

    private MuseumDto museum;

    private int yearCompleted;
    private String backStory;
}
