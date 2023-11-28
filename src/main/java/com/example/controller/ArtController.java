package com.example.controller;

import com.example.model.Art;
import com.example.model.Location;
import com.example.model.Painting;
import com.example.model.Sculpture;
import com.example.service.ArtService;
import io.micrometer.common.util.StringUtils;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Sculpture> findAllSculptures() {
        log.debug("Find all sculptures called");
        return artService.findAllSculptures();
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

    @GetMapping("/sculpture/last/{id}")
    public Sculpture findLastSculptureByArtist(@PathVariable Long id) {
        log.debug("Fetching last sculpture by artist with id" + id);
        return artService.findLastSculptureByArtist(id);
    }

    @GetMapping("/sculpture/{id1}/{id2}")
    public List<Sculpture> findSculptureByMuseumAndArtist(@PathVariable Long id1, @PathVariable Long id2) {
        return artService.findAllSculpturesByArtistAndMuseum(id1, id2);
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

}
