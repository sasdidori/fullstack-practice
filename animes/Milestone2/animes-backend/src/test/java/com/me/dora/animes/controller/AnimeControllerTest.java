package com.me.dora.animes.controller;

import com.me.dora.animes.model.Anime;
import com.me.dora.animes.service.AnimeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class AnimeControllerTest {

    @MockBean
    AnimeService animeService;

    @Autowired
    MockMvc mockMvc;

    String url = "/animes";

    @Test
    void create() throws Exception {
        Anime anime = new Anime("JJK", 8);
        String json = """
                {"title": "JJK", "rating": 8}
                """;

        mockMvc.perform(MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk());
        Mockito.verify(animeService).save(anime);
    }

    @Test
    void readAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        Mockito.verify(animeService).readAll();
    }

    @Test
    void readOneByTitle() throws Exception {
        String title = "title";
        String readUrlWithTitle = url + "/" + title;

        Mockito.when(animeService.findByTitle(title)).thenReturn(Optional.of(new Anime("AOT", 9)));
        mockMvc.perform(MockMvcRequestBuilders.get(readUrlWithTitle).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        Mockito.verify(animeService).findByTitle(title);
    }

    @Test
    void update() throws Exception {
        Anime anime = new Anime("AOT", 9);
        String json = """
                {"title": "AOT", "rating": 9}
                """;

        mockMvc.perform(MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk());
        Mockito.verify(animeService).save(anime);
    }

    @Test
    void deleteAll() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete(url).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        Mockito.verify(animeService).deleteAll();
    }

    @Test
    void deleteOnyById() throws Exception {
        String id = "id";
        String deleteById = url + "/" + id;

        mockMvc.perform(MockMvcRequestBuilders.delete(deleteById).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        Mockito.verify(animeService).deleteById(id);
    }
}