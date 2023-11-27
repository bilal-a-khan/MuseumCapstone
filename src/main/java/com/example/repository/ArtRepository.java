package com.example.repository;

import com.example.model.Art;
import com.example.model.Painting;
import com.example.model.Sculpture;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface ArtRepository extends CrudRepository<Art, Long> {
//    @Query("SELECT a FROM Art a WHERE a.artist_id = :id")
//    List<Art> findArtByArtistId(@Param("id") int id);

//    @Query("SELECT p FROM Painting p")
//    List<Painting> findAllPaintings();

//    @Query("SELECT s FROM Sculpture s")
//    List<Sculpture> findAllSculptures();
}
