package com.me.dora.animes.service;

import com.me.dora.animes.DTO.Anime;
import com.me.dora.animes.persistence.AnimeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AnimeService {

    private final AnimeRepository animeRepository;

    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public Anime create(Anime anime) {
        return animeRepository.save(anime);
    }

    public Set<Anime> readAll() {
        return new HashSet<>(animeRepository.findAll());
    }

    public Optional<Anime> readOneByTitle(String title) {
        return animeRepository.findByTitle(title);
    }

    public Anime update(Anime anime) {
        return animeRepository.save(anime);
    }

    public void deleteAll() {
        animeRepository.deleteAll();
    }

    public void deleteOneById(String id) {
        animeRepository.deleteById(id);
    }
}
