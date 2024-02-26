package br.com.pyetro.memelandia.feign;

import br.com.pyetro.memelandia.dto.MemeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "meme-client", url = "http://localhost:8084")
public interface FeignClientMeme {

    @RequestMapping(method = RequestMethod.POST, path = "/memes")
    public MemeDTO createNewMeme(@RequestBody MemeDTO memeDTO);
    @RequestMapping(method = RequestMethod.GET, path = "/memes")
    public Iterable<MemeDTO> findAll();
    @RequestMapping(method = RequestMethod.GET, path = "/memes/random")
    public MemeDTO findRandonMeme();
}
