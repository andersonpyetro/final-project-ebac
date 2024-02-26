package br.com.pyetro.category.controller;

import br.com.pyetro.category.entities.MemeCategory;
import br.com.pyetro.category.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class MemeController {

    private CategoryService categoryService;
    @PostMapping
    public MemeCategory createMemeCategory(@RequestBody MemeCategory memeCategory){
        return categoryService.createMemeCategory(memeCategory);
    }

    @GetMapping
    public Iterable<MemeCategory> findAll(){
        return categoryService.findAll();
    }
    @GetMapping("/{categoryId}")
    public Optional<MemeCategory> findCategoryById(@PathVariable MemeCategory categoryId) {
        return categoryService.findCategoryById(categoryId.getId());
    }

    @PutMapping("/{categoryId}")
    public MemeCategory updateCategory(@PathVariable String categoryId, @RequestBody MemeCategory category) {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable String categoryId) {
        categoryService.deleteCategoryById(categoryId);
    }
}

