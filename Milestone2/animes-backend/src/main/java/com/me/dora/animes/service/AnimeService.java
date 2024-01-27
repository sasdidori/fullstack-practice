package com.me.dora.animes.service;

import com.me.dora.animes.AnimeRepository;
import com.me.dora.animes.model.Anime;
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


    public Anime save(Anime anime) {
        return animeRepository.save(anime);
    }

    public Set<Anime> readAll() {
        return new HashSet<>(animeRepository.findAll());
    }

    public Optional<Anime> findByTitle(String title) {
        return animeRepository.findByTitle(title);
    }

    public void deleteAll() {
        animeRepository.deleteAll();
    }

    public void deleteById(String id) {
        animeRepository.deleteById(id);
    }
}
