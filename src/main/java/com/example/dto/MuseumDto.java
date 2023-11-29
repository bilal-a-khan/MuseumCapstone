package com.example.dto;


import com.example.model.Art;
import com.example.model.Curator;
import com.example.model.Location;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@AllArgsConstructor
public class MuseumDto {

    private Long id;

    private String name;

    private Curator curator;

    private List<ArtDto> artList;

    private Location location;

    public MuseumDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
