package com.example.dto;

import com.example.model.Artist;
import com.example.model.Medium;
import com.example.model.Museum;
import com.example.model.Style;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Nullable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ArtDto {

    private Long id;
    private String name;

    private ArtistDto artist;

    @Enumerated(value = EnumType.STRING)
    private Medium medium;

    private MuseumDto museum;

    private int yearCompleted;
    private String backStory;

    @Enumerated(value = EnumType.STRING)
    private Style style;

    public ArtDto(Long id, String name, Medium medium, MuseumDto museum, int yearCompleted, String backStory) {
        this.id = id;
        this.name = name;
        this.medium = medium;
        this.museum = museum;
        this.yearCompleted = yearCompleted;
        this.backStory = backStory;
    }

    public ArtDto(Long id, String name, ArtistDto artist, Medium medium, int yearCompleted, String backStory, Style style) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.medium = medium;
        this.yearCompleted = yearCompleted;
        this.backStory = backStory;
        this.style = style;
    }

    public ArtDto(Long id, String name, ArtistDto artist, Medium medium, MuseumDto museum, int yearCompleted, String backStory) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.medium = medium;
        this.museum = museum;
        this.yearCompleted = yearCompleted;
        this.backStory = backStory;
    }
}
