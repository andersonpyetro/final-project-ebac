package br.com.pyetro.memelandia.services;

import br.com.pyetro.memelandia.dto.MemeDTO;
import br.com.pyetro.memelandia.feign.FeignClientMeme;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MemeService {

    private FeignClientMeme feignClientMeme;

    private static final Logger LOGGER = LoggerFactory.getLogger(MemeService.class);

    public MemeService(FeignClientMeme feignClientMeme){
        this.feignClientMeme = feignClientMeme;
    }

    public MemeDTO createNewMeme(MemeDTO meme){
        LOGGER.info("creating a new meme");
        return feignClientMeme.createNewMeme(meme);
    }
    public Iterable<MemeDTO> findAll(){
        LOGGER.info("Find all memes");
        return feignClientMeme.findAll();
    }
}
