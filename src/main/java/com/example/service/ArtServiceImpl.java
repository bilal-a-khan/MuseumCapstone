package com.example.service;

import com.example.model.Art;
import com.example.model.Painting;
import com.example.model.Sculpture;
import com.example.repository.ArtRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class ArtServiceImpl implements ArtService {

    private ArtRepository artRepository;

    @Autowired
    public void setArtRepository(ArtRepository artRepository) {
        this.artRepository = artRepository;
    }

    @Override
    public List<Art> findAll() {
        List<Art> arts = new ArrayList<>();
        Iterable<Art> artsIts = artRepository.findAll();
        artsIts.forEach(arts::add);
        return arts;
    }

    @Override
    public List<Painting> findAllPaintings() {
        return artRepository.findAllPaintings();
    }

    @Override
    public List<Sculpture> findAllSculptures() {
        return artRepository.findAllSculptures();
    }

    @Override
    public Art findById(long id) {
        Optional<Art> art = artRepository.findById(id);
        return art.orElseThrow();
    }

}
