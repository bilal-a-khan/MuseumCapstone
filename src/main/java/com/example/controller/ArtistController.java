package com.example.controller;


import com.example.model.Artist;
import com.example.service.ArtistService;
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
        List<Artist> people = Collections.emptyList();
        people = artistService.findAll();
        people.sort(Comparator.comparing(Artist::getName));
        return people;
    }

    @GetMapping("/artist/{id}")
    public Artist getMessage(@PathVariable Long id){
        return artistService.findById(id);
    }

    @PostMapping("/artist")
    public Artist createArtist(@RequestBody Artist artist){
        return artistService.save(artist);
    }

    @PutMapping("/artist")
    public Artist updateArtist(@RequestBody Artist artist){
        return artistService.save(artist);
    }

    @PutMapping("/artist/{id}")
    public void createArtist(@PathVariable Long id){
        artistService.deleteById(id);
        log.debug("Artist object with id = " + id + " has been deleted.");
    }

}
