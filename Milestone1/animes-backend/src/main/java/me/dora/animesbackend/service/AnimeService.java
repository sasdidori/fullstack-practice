package me.dora.animesbackend.service;

import me.dora.animesbackend.model.Anime;
import me.dora.animesbackend.repository.AnimeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class AnimeService {

    private final AnimeRepository animeRepository;

    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public Anime create(Anime anime){
        return animeRepository.create(anime);
    }

    public Set<Anime> readAll(){
        return animeRepository.readAll();
    }


    public Optional<Anime> readOneByTitle(String title){
        return animeRepository.readOneByTitle(title);
    }

    public Anime update(Anime anime){
        return animeRepository.update(anime);
    }

    public void deleteAll(){
        animeRepository.deleteAll();
    }
    public void deleteOneById(String id){
        animeRepository.deleteOneById(id);
    }

}
