package com.example.controller;


import com.example.model.Art;
import com.example.model.Artist;
import com.example.service.ArtistService;
import com.fasterxml.jackson.databind.deser.CreatorProperty;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Slf4j
@RestController
public class ArtistController {

    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService){
        this.artistService = artistService;
    }

    @GetMapping("/artists")
    public List<Artist> getAllArtists(){
        List<Artist> artists = Collections.emptyList();
        artists = artistService.findAll();

        // Rank the artists by number of paintings hanging in museums
        // artists.sort(Comparator.comparing((artist) -> artist.getArtList().size()));

        artists.sort(Comparator.comparing(Artist::getName));
        return artists;
    }

//    @GetMapping("/sortedartists")
//    public List<Artist> getSortedArtists(){
//        List<Artist> artists = Collections.emptyList();
//        artists = artistService.findSortedAll();
//        return artists;
//    }

    @GetMapping("/artist/{id}")
    public Artist getMessage(@PathVariable Long id){
        return artistService.findById(id);
    }

    @GetMapping("/artist/search")
    public List<Artist> searchByName(@PathParam("name") String name){
        return artistService.searchByName(name);
    }

    @PostMapping("/artist")
    public Artist createArtist(@RequestBody Artist artist){
        return artistService.save(artist);
    }

    @PutMapping("/artist")
    public Artist updateArtist(@RequestBody Artist artist){
        return artistService.save(artist);
    }

    @DeleteMapping("/artist/{id}")
    public void deleteArtist(@PathVariable Long id){
        artistService.deleteById(id);
        log.debug("Artist object with id = " + id + " has been deleted.");
    }



}
