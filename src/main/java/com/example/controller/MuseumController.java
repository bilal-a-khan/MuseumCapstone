package com.example.controller;

import com.example.model.Art;
import com.example.model.Museum;
import com.example.model.Painting;
import com.example.service.ArtistService;
import com.example.service.MuseumService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class MuseumController {

    private final MuseumService museumService;

    @GetMapping("/museum")
    public List<Museum> getAllMuseum() {
        log.debug("Fetching all museums");
        return museumService.findAll();
    }

    @GetMapping("/museum/{id}")
    public Museum findByID(@PathVariable Long id) {
        log.debug("Fetching museum by ID: " + id);
        return museumService.findById(id);
    }

}
