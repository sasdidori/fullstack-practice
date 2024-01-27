package com.me.dora.animes.controller;

import com.me.dora.animes.DTO.Anime;
import com.me.dora.animes.service.AnimeService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("animes")
public class AnimeController {

    private final AnimeService animeService;


    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @PostMapping
    Anime create(@RequestBody Anime anime) {
        return animeService.create(anime);
    }

    @GetMapping
    Set<Anime> readALl() {
        return animeService.readAll();
    }

    @GetMapping("{title}")
    Anime readOneByTitle(@PathVariable String title) throws AnimeNotFoundException  {
        return animeService.readOneByTitle(title)
                .orElseThrow(AnimeNotFoundException::new);
    }

    @PatchMapping
    Anime update(@RequestBody Anime anime) {
        return animeService.update(anime);
    }

    @DeleteMapping
    void deleteAll() {
        animeService.deleteAll();
    }

    @DeleteMapping("{id}")
    void deleteOneById(@PathVariable String id) {
        animeService.deleteOneById(id);
    }

}
