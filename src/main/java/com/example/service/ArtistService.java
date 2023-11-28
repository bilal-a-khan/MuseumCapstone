package com.example.service;

import com.example.model.Art;
import com.example.model.Artist;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ArtistService {

    List<Artist> findAll();
    Artist findById(Long id);
    List<Artist> searchByName(String name);

    Artist save(Artist artist);
    void deleteById(Long id);

    List<Artist> findSortedAll();
}
