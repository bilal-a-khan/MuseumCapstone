package com.example.repository;

import com.example.model.Art;
import org.springframework.stereotype.Repository;

public interface ArtRepositoryCustom {

    Art findArtById(Long id);

}
