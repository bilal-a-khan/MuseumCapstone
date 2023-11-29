package com.example.utils;

import com.example.dto.ArtDto;
import com.example.dto.ArtistDto;
import com.example.model.Art;
import com.example.model.Artist;

import java.util.ArrayList;
import java.util.List;

public class ArtistDtoConverter {

//    public static ArtistDto convert(Artist artist){
//        return new ArtistDto(artist.getId(), artist.getName(),
//                artist.getYearBorn(), artist.getYearDead());
//    }
    public static ArtistDto convert(Artist artist, List<ArtDto> dtos){
        return new ArtistDto(artist.getId(), artist.getName(),
                artist.getYearBorn(), artist.getYearDead(), dtos);
    }


//    public static ArtistDto convertWithArtList(Artist artist){
//
//        List<ArtDto> dtos = new ArrayList<>();
//        for(Art art : artist.getArtList())
//            dtos.add(ArtDtoConverter.convert(art));
//
//        return new ArtistDto(artist.getId(), artist.getName(),
//                artist.getYearBorn(), artist.getYearDead(), dtos);
//    }
}
