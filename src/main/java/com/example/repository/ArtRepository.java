package com.example.repository;

import com.example.model.Art;
import com.example.model.Painting;
import com.example.model.Sculpture;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtRepository extends CrudRepository<Art, Long> {
//    @Query("SELECT a FROM Art a WHERE a.artist_id = :id")
//    List<Art> findArtByArtistId(@Param("id") Long id);

    @Query("SELECT p FROM Painting p")
    List<Painting> findAllPaintings();

    @Query("SELECT s FROM Sculpture s")
    List<Sculpture> findAllSculptures();

    //List all the sculptures by a given artist in a given museum
//    @Query("SELECT s FROM Sculpture s WHERE s.artist_id = :artist_id AND s.museum_id = :museum_id")
//    List<Sculpture> findAllSculpturesByArtistAndMuseum(@Param("artist_id") Long artistId, @Param("museum_id") Long museumId);
//
//    //First or last sculpture made by a given artist.
//    @Query(value = "SELECT s FROM Sculpture s WHERE s.artist_id = :artist_id ORDER BY s.year_completed DESC LIMIT 1", nativeQuery = true)
//    Sculpture findFirstSculptureByArtist(@Param("artist_id") Long artistId);
}
