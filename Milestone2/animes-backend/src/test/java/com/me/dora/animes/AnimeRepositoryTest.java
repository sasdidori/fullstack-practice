package com.me.dora.animes;

import com.me.dora.animes.controller.AnimeNotFound;
import com.me.dora.animes.model.Anime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
class AnimeRepositoryTest {

    @Autowired
    AnimeRepository animeRepository;

    Anime anime = new Anime("JJK", 9);

    @BeforeEach
    void before() {
        animeRepository.save(anime);
    }

    @AfterEach
    void after() {
        animeRepository.deleteAll();
    }


    @Test
    void findByTitle() throws AnimeNotFound {
        Optional<Anime> result = Optional.of(animeRepository.findByTitle(anime.getTitle()).orElseThrow(AnimeNotFound::new));

        Assertions.assertTrue(true);
        Assertions.assertEquals(anime.getTitle(), result.get().getTitle());
    }
}