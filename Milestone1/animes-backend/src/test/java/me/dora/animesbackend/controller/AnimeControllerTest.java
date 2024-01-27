package me.dora.animesbackend.controller;

import me.dora.animesbackend.model.Anime;
import me.dora.animesbackend.service.AnimeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//testing behaviour
@WebMvcTest(AnimeController.class)
class AnimeControllerTest {

    @MockBean
    AnimeService animeService;

    @Autowired
    MockMvc mockMvc;

    String url = "/animes";


    @Test
    void create() throws Exception {
        Anime anime = new Anime(null, "aot", 8);
        String json = """
        {"title": "aot", "rating": 8}
        """;

        mockMvc.perform(post(url).contentType(APPLICATION_JSON).content(json))
                .andExpect(status().isOk());
        verify(animeService).create(anime);
    }

    @Test
    void readAll() throws Exception {
        mockMvc.perform(get(url).contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(animeService).readAll();
    }

    @Test
    void readOneByTitle() throws Exception {
        String title = "title";
        String readOneUrl = url + "/" + title;

        when(animeService.readOneByTitle(title)).thenReturn(Optional.of(new Anime(null, title, 9)));
        mockMvc.perform(get(readOneUrl).contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(animeService).readOneByTitle(title);
    }

    @Test
    void update() throws Exception {
        Anime anime = new Anime("1", "aot", 8);
        String json = """
        {"id": "1", "title": "aot", "rating": 8}
        """;

        mockMvc.perform(patch(url).contentType(APPLICATION_JSON).content(json))
                .andExpect(status().isOk());
        verify(animeService).update(anime);
    }

    @Test
    void deleteAll() throws Exception {
        mockMvc.perform(delete(url).contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(animeService).deleteAll();
    }

    @Test
    void deleteOneById() throws Exception {
        String id = "id";
        String deleteOneUrl = url + "/" + id;

        mockMvc.perform(delete(deleteOneUrl).contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(animeService).deleteOneById(id);
    }

}