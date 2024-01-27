package me.dora.animesbackend.repository;

import me.dora.animesbackend.model.Anime;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;


public class AnimeRepository {

    private final Set<Anime> animes;

    public AnimeRepository(Set<Anime> animes) {
        this.animes = animes;
    }

    public Anime create(Anime anime) {
        String id = UUID.randomUUID().toString();
        Anime newAnime = new Anime(id, anime.title(), anime.rating());
        animes.add(newAnime);
        return newAnime;
    }

    public Set<Anime> readAll() {
        return new HashSet<>(animes);
    }

    public Optional<Anime> readOneByTitle(String title) {
        return animes.stream().filter(anime -> anime.title()
                .equals(title))
                .findFirst();
    }

    public Anime update(Anime anime) {
        deleteOneById(anime.id());
        animes.add(anime);
        return anime;
    }

    public void deleteAll() {
        animes.clear();
    }

    public void deleteOneById(String id) {
        animes.removeIf(other -> other.id().equals(id));

    }
}
