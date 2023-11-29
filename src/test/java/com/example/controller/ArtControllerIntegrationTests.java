package com.example.controller;

import com.example.model.Painting;
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
public class ArtControllerIntegrationTests {

        @Autowired
        MockMvc mockMvc;
        ObjectMapper mapper = new ObjectMapper();

        @Test
        public void testGettingAllPaintings() throws Exception {
            int expectedLength = 4;

            ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/art")
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk());

            MvcResult result = resultActions.andReturn();
            String contentAsString = result.getResponse().getContentAsString();

            Painting[] paintings = mapper.readValue(contentAsString, Painting[].class);

            assertEquals(expectedLength, paintings.length);

        }




        }