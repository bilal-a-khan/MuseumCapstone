package com.example.utils;

import com.example.dto.ArtDto;
import com.example.model.Art;

public class ArtDtoConverter {

    public static ArtDto convert(Art art){
        return new ArtDto(art.getId(), art.getName(), art.getArtist(),
                art.getMedium(), MuseumDtoConverter.convert(art.getMuseum()),
                art.getYearCompleted(), art.getBackStory());
    }
}
