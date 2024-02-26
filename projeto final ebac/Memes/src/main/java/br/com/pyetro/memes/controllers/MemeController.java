package br.com.pyetro.memes.controllers;

import br.com.pyetro.memes.entities.Meme;
import br.com.pyetro.memes.services.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/memes")
public class MemeController {

    @Autowired
    private MemeService memeService;
    @PostMapping
    public Meme createMeme(@RequestBody Meme meme){
        return memeService.createMeme(meme);
    }

    @GetMapping
    public Iterable<Meme> findAll() {
        return memeService.findAll();
    }

    @GetMapping("/{memeId}")
    public Optional<Meme> findMemeById(@PathVariable Meme meme) {
        return memeService.findMemeById(meme);
    }

    @GetMapping("/random")
    public Optional<Meme> findRandomMeme() {
        return memeService.findRandomMeme();
    }

    @PutMapping("/{memeId}")
    public Meme updateMeme(@PathVariable Meme memeId, @RequestBody Meme meme) {
        return memeService.updateMeme(meme);
    }

    @DeleteMapping("/{memeId}")
    public void deleteMeme(@PathVariable Meme meme) {
        memeService.deleteMemeById(meme);
    }
}

