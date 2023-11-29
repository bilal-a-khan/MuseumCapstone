package com.example.utils;

import com.example.dto.MuseumDto;
import com.example.model.Museum;

public class MuseumDtoConverter {

    public static MuseumDto convert(Museum museum){
        return new MuseumDto(museum.getId());
    }

}
