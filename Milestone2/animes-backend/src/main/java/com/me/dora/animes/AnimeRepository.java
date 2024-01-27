package com.me.dora.animes;

import com.me.dora.animes.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnimeRepository extends JpaRepository<Anime, String> {
    Optional<Anime> findByTitle(String title);
}
