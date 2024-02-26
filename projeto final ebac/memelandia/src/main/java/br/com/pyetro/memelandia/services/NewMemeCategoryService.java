package br.com.pyetro.memelandia.services;

import br.com.pyetro.memelandia.dto.MemeCategoryDTO;
import br.com.pyetro.memelandia.feign.FeignClientNewMemeCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class NewMemeCategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewMemeCategoryService.class);

    private final FeignClientNewMemeCategory feignClientNewMemeCategory;

    public NewMemeCategoryService(FeignClientNewMemeCategory feignClientNewMemeCategory) {
        this.feignClientNewMemeCategory = feignClientNewMemeCategory;
    }

    public MemeCategoryDTO createNewCategory(MemeCategoryDTO memeCategoryDTO){
        LOGGER.info("Creating a new meme category");
        return feignClientNewMemeCategory.createNewMemeCategory(memeCategoryDTO);
    }

    public Iterable<MemeCategoryDTO> findAll(){
        LOGGER.info("Find all category");
        return feignClientNewMemeCategory.findAll();
    }
}
