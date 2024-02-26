package br.com.pyetro.memelandia.controller;

import br.com.pyetro.memelandia.dto.MemeCategoryDTO;
import br.com.pyetro.memelandia.services.NewMemeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class MemeCategoryController {

    private final NewMemeCategoryService memeCategoryService;

    @Autowired
    public MemeCategoryController(NewMemeCategoryService memeCategoryService) {
        this.memeCategoryService = memeCategoryService;
    }

    @PostMapping
    public MemeCategoryDTO createNewCategory(@RequestBody MemeCategoryDTO memeCategoryDTO) {
        return memeCategoryService.createNewCategory(memeCategoryDTO);
    }

    @GetMapping
    public Iterable<MemeCategoryDTO> findAllCategories() {
        return memeCategoryService.findAll();
    }
}
