package com.example.service;

import com.example.model.Artist;
import com.example.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistServiceImp implements ArtistService{

    private ArtistRepository artistRepository;

    @Autowired
    public ArtistServiceImp(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }


    @Override
    public List<Artist> findAll() {
        List<Artist> artists = new ArrayList<>();
        Iterable<Artist> artistsIterable = artistRepository.findAll();
        artistsIterable.forEach(artists::add);
        return artists;
    }
}
