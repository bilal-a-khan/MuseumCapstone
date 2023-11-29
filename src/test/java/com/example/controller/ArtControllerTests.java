package com.example.controller;

import com.example.model.Art;
import com.example.model.Painting;
import com.example.model.Sculpture;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Sql("classpath:test-data.sql")
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
public class ArtControllerTests {

        @Autowired
        MockMvc mockMvc;
        ObjectMapper mapper = new ObjectMapper();


    @Test
    public void testGettingAllArt() throws Exception {
        int expectedLength = 9;

        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/art")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Art[] arts = mapper.readValue(contentAsString, Art[].class);

        System.out.println("Expected length: " + expectedLength);
        System.out.println("actual length: " + arts.length);

        assertEquals(expectedLength, arts.length);

    }


        @Test
        public void testGettingAllPaintings() throws Exception {
            int expectedLength = 4;

            ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/painting")
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk());

            MvcResult result = resultActions.andReturn();
            String contentAsString = result.getResponse().getContentAsString();

            Painting[] paintings = mapper.readValue(contentAsString, Painting[].class);

            System.out.println("Expected length: " + expectedLength);
            System.out.println("actual length: " + paintings.length);

            assertEquals(expectedLength, paintings.length);
        }

    @Test
    public void testGettingAllSculptures() throws Exception {
        int expectedLength = 5;

        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/sculpture")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Sculpture[] sculptures = mapper.readValue(contentAsString, Sculpture[].class);

        System.out.println("Expected length: " + expectedLength);
        System.out.println("actual length: " + sculptures.length);

        assertEquals(expectedLength, sculptures.length);
    }


    @Test
    public void testGettingOneArt() throws Exception {
        String expectedName = "Mona Lisa";
        int id = 10;

        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/art/"+id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Art art = mapper.readValue(contentAsString, Art.class);

        System.out.println("Expected length: " + expectedName);
        System.out.println("actual length: " + art.getName());

        assertEquals(expectedName, art.getName());
    }

    @Test
    public void testDeleteOneArt() throws Exception {
        int id = 10;
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.delete("/art/"+id))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testCreatePainting() throws Exception{

        Painting painting = new Painting();

        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/painting")
                        .content(mapper.writeValueAsString(painting))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        Painting paintingResult = mapper.readValue(contentAsString, Painting.class);

        System.out.println("Expected length: " + 1);
        System.out.println("actual length: " + paintingResult.getId());

        assertEquals(1,paintingResult.getId());
    }

    @Test
    public void testCreateSculpture() throws Exception{

        Sculpture sculpture = new Sculpture();

        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/sculpture")
                        .content(mapper.writeValueAsString(sculpture))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        Sculpture sculptureResult = mapper.readValue(contentAsString, Sculpture.class);

        System.out.println("Expected length: " + 1);
        System.out.println("actual length: " + sculptureResult.getId());

        assertEquals(1,sculptureResult.getId());
    }

    @Test
    public void testUpdatePainting() throws Exception{

        Painting painting = new Painting();
        painting.setId(10L);
        painting.setName("Changed name");

        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.put("/painting")
                        .content(mapper.writeValueAsString(painting))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        Painting paintingResult = mapper.readValue(contentAsString, Painting.class);

        System.out.println("Expected length: " + painting.getName());
        System.out.println("actual length: " + paintingResult.getName());

        assertEquals(painting.getName(),paintingResult.getName());
    }

    @Test
    public void testUpdateSculpture() throws Exception{

        Sculpture sculpture = new Sculpture();
        sculpture.setId(10L);
        sculpture.setName("Changed name");

        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.put("/sculpture")
                        .content(mapper.writeValueAsString(sculpture))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        Sculpture sculptureResult = mapper.readValue(contentAsString, Sculpture.class);

        System.out.println("Expected length: " + sculpture.getName());
        System.out.println("actual length: " + sculptureResult.getName());

        assertEquals(sculpture.getName(),sculptureResult.getName());
    }

    @Test
    public void testGetArtWithId() throws Exception {
        int testId = 11;
        String expectedName = "Dying Slave";

        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/art/"+testId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Art art = mapper.readValue(contentAsString, Art.class);

        System.out.println("Expected length: " + expectedName);
        System.out.println("actual length: " + art.getName());

        assertEquals(expectedName, art.getName());
    }

        }