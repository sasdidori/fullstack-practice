package me.dora.animesbackend.configuration;

import me.dora.animesbackend.model.Anime;
import me.dora.animesbackend.repository.AnimeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class RepositoryConfiguration {
    @Bean
    AnimeRepository animeRepository(){
        Set<Anime> animes = new HashSet<>();
        return new AnimeRepository(animes);
    }
}
