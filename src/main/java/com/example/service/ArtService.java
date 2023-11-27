package com.example.service;

import com.example.model.Art;
import com.example.model.Painting;
import com.example.model.Sculpture;

import java.util.List;

public interface ArtService {
    List<Art> findAll();

    List<Painting> findAllPaintings();

    List<Sculpture> findAllSculptures();

    Art findById(long id);
}
