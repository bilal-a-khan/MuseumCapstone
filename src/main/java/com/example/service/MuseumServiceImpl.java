package com.example.service;

import com.example.model.Art;
import com.example.model.Museum;
import com.example.model.Painting;
import com.example.model.Style;
import com.example.repository.ArtRepository;
import com.example.repository.MuseumRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
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

    @Override
    public Museum findByMostStyle(String style) {

        Style styleEnum = null;
        for (Style s : Style.values()) {
            if (s.toString().equalsIgnoreCase(style)) {
                styleEnum = s;
            }
        }
            if(styleEnum == null){
                log.debug("style not found. Throwing null pointer exception");
                throw new NullPointerException("Style not found");
            }


        List<Museum> museums = findAll();

        Style finalStyleEnum = styleEnum;
        Optional<Museum> museumMostByStyle = museums.stream().max(Comparator.comparingInt(museum -> countArtOfStyle(museum, finalStyleEnum)));
        return museumMostByStyle.orElse(null);

    }

    private static int countArtOfStyle(Museum museum, Style style) {
        List<Painting> paintingList = new ArrayList<>();
        for (Art art : museum.getArtList()) {
            if (art instanceof Painting) {
                paintingList.add((Painting) art);
            }
        }
        return (int) paintingList.stream().filter(painting -> painting.getStyle() == style).count();
    }
}
