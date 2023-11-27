package com.example.controller;

import com.example.model.Art;
import com.example.model.Painting;
import com.example.model.Sculpture;
import com.example.service.ArtService;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ArtController {

    private ArtService artService;

    public ArtController(ArtService artService) {
        this.artService = artService;
    }

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
        log.debug("Fetching all sculptures");
        return artService.findAllSculptures();
    }

    @GetMapping("/art/{id}")
    public Art findById(@PathVariable long id) {
        log.debug("Fetching art by ID: " + id);
        return artService.findById(id);
    }

}
