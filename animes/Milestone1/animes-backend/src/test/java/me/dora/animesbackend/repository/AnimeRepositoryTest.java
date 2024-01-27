package me.dora.animesbackend.repository;

import me.dora.animesbackend.model.Anime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

class AnimeRepositoryTest {
    Anime anime = new Anime("1", "AOT", 9);

    @Test
    void create() {
        Set<Anime> animes = new HashSet<>();
        AnimeRepository animeRepository = new AnimeRepository(animes);

        Anime result = animeRepository.create(anime);
        Assertions.assertNotEquals(anime.id(), result.id());
        Assertions.assertEquals(anime.title(), result.title());
        Assertions.assertEquals(anime.rating(), result.rating());
        Assertions.assertEquals(1, animes.size());
        Assertions.assertTrue(animes.contains(result));
    }

    @Test
    void readAll() {
        Set<Anime> animes = new HashSet<>();
        AnimeRepository animeRepository = new AnimeRepository(animes);

        Set<Anime> result = animeRepository.readAll();

        Assertions.assertEquals(animes, result);
    }

    @Test
    void readOneByTitle() {
        String title = "title";
        Anime other = new Anime("1", title, 4);
        Set<Anime>animes = new HashSet<>();
        animes.add(other);
        animes.add(anime);
        AnimeRepository animeRepository = new AnimeRepository(animes);

        Optional<Anime> result = animeRepository.readOneByTitle(title);

        Optional<Anime> expected = Optional.of(other);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void update() {
        Anime original = new Anime("2", "original", 10);
        Set<Anime> animes = new HashSet<>();
        animes.add(original);
        AnimeRepository animeRepository = new AnimeRepository(animes);
        Anime updated = new Anime("2", "updated", 11);

        Anime result = animeRepository.update(updated);

        Assertions.assertEquals(updated, result);
        Assertions.assertEquals(1, animes.size());
        Anime modified = new ArrayList<>(animes).get(0);
        Assertions.assertEquals(updated, modified);


    }

    @Test
    void deleteAll() {
        Set<Anime> animes = new HashSet<>();
        animes.add(anime);
        AnimeRepository animeRepository = new AnimeRepository(animes);

        animeRepository.deleteAll();

        Assertions.assertEquals(0, animes.size());
    }

    @Test
    void deleteOneById() {
        String id = "3";
        Anime anime2 = new Anime(id, "JJK", 7);
        Set<Anime> animes = new HashSet<>();
        animes.add(anime);
        animes.add(anime2);
        AnimeRepository animeRepository = new AnimeRepository(animes);

        animeRepository.deleteOneById(id);

        Assertions.assertFalse(animes.contains(anime2));
    }
}
