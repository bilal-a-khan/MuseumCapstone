package com.example.controller;

import com.example.model.Art;
import com.example.model.Painting;
import com.example.model.Sculpture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ArtControllerTests {

//    @Test
//    public void testGetAllArt() {
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<Art[]> response =
//                restTemplate.getForEntity("http://localhost:8080/art", Art[].class);
//        Art[] arts = response.getBody();
//
//        List<Art> artList = Arrays.asList(arts);
//
//        assertEquals(6, artList.size());
//    }

    @Test
    public void testGetAllPaintings() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Painting[]> response =
                restTemplate.getForEntity("http://localhost:8080/painting", Painting[].class);
        Painting[] paintings = response.getBody();

        List<Painting> paintingList = Arrays.asList(paintings);

        assertEquals(4, paintingList.size());
    }

//    @Test
//    public void testGetAllSculptures() {
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<Sculpture[]> response =
//                restTemplate.getForEntity("http://localhost:8080/sculpture", Sculpture[].class);
//        Sculpture[] sculptures = response.getBody();
//
//        List<Sculpture> sculptureList = Arrays.asList(sculptures);
//
//        assertEquals(2, sculptureList.size());
//    }

    @Test
    public void testGetPaintingById() {

        long artId = 10L;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Painting> response = restTemplate.getForEntity("http://localhost:8080/art/" + artId, Painting.class);

        assertEquals(200, response.getStatusCodeValue(), "Status code should be 200 OK");
        assertNotNull(response.getBody(), "Response body should not be null");

        Painting painting = response.getBody();
        assertEquals(artId, painting.getId(), "The ID of the retrieved art should match the requested ID");
    }

    @Test
    public void testGetSculpturesById() {

        long artId = 11L;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Sculpture> response = restTemplate.getForEntity("http://localhost:8080/art/" + artId, Sculpture.class);

        assertEquals(200, response.getStatusCodeValue(), "Status code should be 200 OK");
        assertNotNull(response.getBody(), "Response body should not be null");

        Sculpture sculpture = response.getBody();
        assertEquals(artId, sculpture.getId(), "The ID of the retrieved art should match the requested ID");
    }

//    @Test
//    public void testGetArtById() {
//        assertArtType(10L, Painting.class);
//        assertArtType(11L, Sculpture.class);
//        assertArtType(12L, Sculpture.class);
//        assertArtType(13L, Painting.class);
//        assertArtType(14L, Painting.class);
//        assertArtType(15L, Painting.class);
//    }
//
//    private void assertArtType(Long artId, Class<?> expectedType) {
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<Art> response = restTemplate.getForEntity("http://localhost:8080/art/" + artId, Art.class);
//        assertEquals(200, response.getStatusCodeValue(), "Status code should be 200 OK");
//        assertNotNull(response.getBody(), "Response body should not be null");
//        assertTrue(expectedType.isInstance(response.getBody()), "Expected type does not match the actual type");
//    }


}
