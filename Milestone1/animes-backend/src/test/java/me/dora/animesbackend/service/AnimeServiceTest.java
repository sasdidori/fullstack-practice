package me.dora.animesbackend.service;

import me.dora.animesbackend.model.Anime;
import me.dora.animesbackend.repository.AnimeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

//behavioural test
class AnimeServiceTest {

    AnimeRepository animeRepository = Mockito.mock(AnimeRepository.class);
    AnimeService animeService = new AnimeService(animeRepository);

    Anime anime = new Anime("1", "AOT", 8);

    @Test
    void create() {
        Mockito.when(animeRepository.create(anime)).thenReturn(anime);

        Anime result = animeService.create(anime);

        Assertions.assertEquals(result, anime);
        Mockito.verify(animeRepository).create(anime);
    }

    @Test
    void readAll() {
        Set<Anime> animes = Set.of();
        Mockito.when(animeRepository.readAll()).thenReturn(animes);

        Set<Anime> result = animeService.readAll();

        Assertions.assertEquals(result, animes);
        Mockito.verify(animeRepository).readAll();
    }

    @Test
    void readOneByTitle() {
        Optional<Anime> expected = Optional.of(anime);
        Mockito.when(animeRepository.readOneByTitle(anime.title())).thenReturn(expected);

        Optional<Anime> result = animeService.readOneByTitle(anime.title());
        Assertions.assertEquals(result, expected);
        Mockito.verify(animeRepository).readOneByTitle(anime.title());
    }

    @Test
    void update() {
        Mockito.when(animeRepository.update(anime)).thenReturn(anime);

        Anime result = animeService.update(anime);

        Assertions.assertEquals(result, anime);
        Mockito.verify(animeRepository).update(anime);
    }

    @Test
    void deleteAll() {
        animeService.deleteAll();

        Mockito.verify(animeRepository).deleteAll();
    }

    @Test
    void deleteOneById() {
        animeService.deleteOneById(anime.id());

        Mockito.verify(animeRepository).deleteOneById(anime.id());
    }
}