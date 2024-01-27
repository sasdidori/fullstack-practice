package me.dora.animesbackend.controller;

import me.dora.animesbackend.model.Anime;
import me.dora.animesbackend.service.AnimeService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin(origins = "http://localhost:5173")
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
    Set<Anime> readAll() {
        return animeService.readAll();
    }

    @GetMapping("{title}")
    Anime readOneByTitle(@PathVariable String title) throws AnimeNotFound {
        return animeService.readOneByTitle(title)
                .orElseThrow(AnimeNotFound::new);
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
