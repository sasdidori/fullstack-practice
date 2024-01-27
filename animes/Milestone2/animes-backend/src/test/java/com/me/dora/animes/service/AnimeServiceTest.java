package com.me.dora.animes.service;

import com.me.dora.animes.AnimeRepository;
import com.me.dora.animes.model.Anime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;
import java.util.Set;

class AnimeServiceTest {

    AnimeRepository animeRepository = Mockito.mock(AnimeRepository.class);

    AnimeService animeService = new AnimeService(animeRepository);

    Anime anime = new Anime("Jojo", 6);


    @Test
    void save() {

        Mockito.when(animeRepository.save(anime)).thenReturn(anime);

        Anime result = animeService.save(anime);

        Assertions.assertEquals(result, anime);
        Mockito.verify(animeRepository).save(anime);

    }

    //askkk
    @Test
    void readAll() {
        List<Anime> animes = List.of();
        Mockito.when(animeRepository.findAll()).thenReturn(animes);

        Set<Anime> result = animeService.readAll();

        Assertions.assertIterableEquals(result, animes);
        Mockito.verify(animeRepository).findAll();
    }

    @Test
    void findByTitle() {

        Mockito.when(animeRepository.findByTitle(anime.getTitle())).thenReturn(Optional.ofNullable(anime));

        Optional<Anime> result = animeService.findByTitle(anime.getTitle());

        Assertions.assertEquals(result, Optional.of(anime));
        Mockito.verify(animeRepository).findByTitle(anime.getTitle());
    }

    @Test
    void deleteAll() {
        animeService.deleteAll();

        Mockito.verify(animeRepository).deleteAll();
    }

    @Test
    void deleteById() {
        animeService.deleteById(anime.getId());

        Mockito.verify(animeRepository).deleteById(anime.getId());
    }
}