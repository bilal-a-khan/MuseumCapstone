package com.example.controller;

import com.example.model.*;
import com.example.service.ArtService;
import io.micrometer.common.util.StringUtils;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class ArtController {

    private ArtService artService;

    @GetMapping("/art")
    public List<Art> getAllArt() {
        log.debug("Fetching all art");
        return artService.findAll();
    }

    @GetMapping("/painting")
    public List<Painting> getAllPaintings() {
        log.debug("Fetching all paintings");
        return artService.findAllPaintings();
    }

    @GetMapping("/sculpture")
    public List<Sculpture> findAllSculptures(@PathParam("museum") Long museumId, @PathParam("artist") Long artistId) {
        List<Sculpture> sculptures;
        log.debug("Fetching all sculptures");
        if (StringUtils.isNotBlank(String.valueOf(museumId)) &&
                StringUtils.isNotBlank(String.valueOf(artistId))){
            sculptures = artService.findAllSculpturesByArtistAndMuseum(artistId, museumId);
        } else {
            sculptures = artService.findAllSculptures();
        }
        return sculptures;
    }

    @GetMapping("/art/{id}")
    public Art findById(@PathVariable Long id) {
        log.debug("Fetching art by ID: " + id);
        return artService.findById(id);
    }

    @GetMapping("/sculpture/first/{id}")
    public Sculpture findFirstSculptureByArtist(@PathVariable Long id) {
        log.debug("Fetching first sculpture by artist with id" + id);
        return artService.findFirstSculptureByArtist(id);
    }

    @GetMapping("/location")
    public List<Location> findLocationByName(@PathParam("name") String name){
        List<Art> artList = artService.searchByName(name);
        List<Location> locations = new ArrayList<>();

        artList.forEach( (art) -> {
            locations.add(art.getMuseum().getLocation());
        });
        return locations;
    }

    @PostMapping("/painting")
    public Painting createArt(@RequestBody Painting painting){
        return artService.save(painting);
    }
    @PostMapping("/sculpture")
    public Sculpture createArt(@RequestBody Sculpture sculpture){
        return artService.save(sculpture);
    }

    @PutMapping ("/painting")
    public Painting updatingArt(@RequestBody Painting painting){
        return artService.save(painting);
    }
    @PutMapping("/sculpture")
    public Sculpture updatingArt(@RequestBody Sculpture sculpture){
        return artService.save(sculpture);
    }

    @DeleteMapping("/artist/{id}")
    public void deleteArt(@PathVariable Long id){
        artService.deleteById(id);
        log.debug("Artist object with id = " + id + " has been deleted.");
    }



}
