package com.me.dora.animes.controller;

import com.me.dora.animes.model.Anime;
import com.me.dora.animes.service.AnimeService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;
@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("animes")
public class AnimeController {

    private final AnimeService animeService;


    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }


    @PostMapping
    Anime create(@RequestBody Anime anime) {
        return animeService.save(anime);
    }

    @GetMapping
    Set<Anime> readAll() {
        return animeService.readAll();
    }

    @GetMapping("{title}")
    Anime readOneByTitle(@PathVariable String title) throws AnimeNotFound {
        return animeService.findByTitle(title)
                .orElseThrow(AnimeNotFound::new);
    }

    @PatchMapping
    Anime update(@RequestBody Anime anime) {
        return animeService.save(anime);
    }

    @DeleteMapping
    void deleteAll() {
        animeService.deleteAll();
    }

    @DeleteMapping("{id}")
    void deleteOnyById(@PathVariable String id) {
        animeService.deleteById(id);
    }
}
