package com.example.controller;


import com.example.model.Artist;
import com.example.service.ArtistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
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
    public List<Artist> getAllPeople(){
        log.debug("Getting all artists from DB...");
        List<Artist> people = Collections.emptyList();

        people = artistService.findAll();
        return people;
    }



}
