package br.com.pyetro.memelandia.feign;

import br.com.pyetro.memelandia.dto.MemeCategoryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "new-meme-category", url = "https://localhost:8083")
public interface FeignClientNewMemeCategory {

        @RequestMapping(method = RequestMethod.POST, path = "/category")
        public MemeCategoryDTO createNewMemeCategory(@RequestBody MemeCategoryDTO memeCategoryDTO);
        @RequestMapping(method = RequestMethod.GET, path = "/category")
        public Iterable<MemeCategoryDTO> findAll();
}

