package com.example.controller;

import com.example.model.*;
import com.example.service.ArtistService;
import com.example.service.MuseumService;
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


    @GetMapping("/museum/most")
    public Museum findByMostFilter(@PathParam("style") String style, @PathParam("artistID") Long artistID){
        Museum museumByMost;

        if (StringUtils.isNotBlank(style) && artistID == null){
            log.debug("Fetching museum with most art of style: " + style);
            museumByMost = museumService.findByMostStyle(style);
        } else if (StringUtils.isNotBlank(String.valueOf(artistID)) && style == null) {
            log.debug("Fetching museum with most art of from Artist ID: " + artistID);
            museumByMost = museumService.findByMostArtist(artistID);
        } else{
            throw new IllegalArgumentException("invalid endpoint");
        }
        return museumByMost;
    }

    @DeleteMapping("/museum/{id}")
    public void deleteMuseum(@PathVariable Long id){
        museumService.deleteById(id);
        log.debug("Museum object with id = " + id + " has been deleted.");
    }

    @PostMapping("/museum")
    public Museum createMuseum(@RequestBody Museum museum){
        return museumService.save(museum);
    }

    @PutMapping ("/museum")
    public Museum updatingMuseum(@RequestBody Museum museum){
        return museumService.save(museum);
    }

}
