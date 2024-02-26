package br.com.pyetro.memelandia.controller;

import br.com.pyetro.memelandia.dto.MemeDTO;
import br.com.pyetro.memelandia.services.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/memes")
public class MemeController {

    private final MemeService memeService;

    @Autowired
    public MemeController(MemeService memeService) {
        this.memeService = memeService;
    }

    @PostMapping
    public MemeDTO createNewMeme(@RequestBody MemeDTO memeDTO) {
        return memeService.createNewMeme(memeDTO);
    }

    @GetMapping
    public Iterable<MemeDTO> findAllMemes() {
        return memeService.findAll();
    }
}
