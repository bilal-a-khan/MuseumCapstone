package com.example.service;

import com.example.model.Art;
import com.example.model.Museum;
import com.example.repository.ArtRepository;
import com.example.repository.MuseumRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class MuseumServiceImpl implements MuseumService {

    private MuseumRepository museumRepository;

    @Override
    public List<Museum> findAll() {
        List<Museum> museums = new ArrayList<>();
        Iterable<Museum> museumIterable = museumRepository.findAll();
        museumIterable.forEach(museums::add);
        return museums;
    }

    @Override
    public Museum findById(Long id) {
        Optional<Museum> museum = museumRepository.findById(id);
        return museum.orElseThrow();
    }
}
