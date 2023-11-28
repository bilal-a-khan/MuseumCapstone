package com.example.service;

import com.example.model.Art;
import com.example.model.Artist;
import com.example.model.Painting;
import com.example.model.Sculpture;

import java.util.List;

public interface ArtService {
    List<Art> findAll();

    List<Painting> findAllPaintings();

    List<Sculpture> findAllSculptures();

    Art findById(Long id);

    List<Sculpture> findAllSculpturesByArtistAndMuseum(Long artistId, Long museumId);

    Sculpture findFirstSculptureByArtist(Long artistId);

    List<Art> searchByName(String name);
}
