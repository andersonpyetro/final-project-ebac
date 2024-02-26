package br.com.pyetro.category.services;

import br.com.pyetro.category.entities.MemeCategory;
import br.com.pyetro.category.repositories.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryService.class);

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public MemeCategory createMemeCategory(MemeCategory category) {
        category.createId();
        LOGGER.info("New category created: " + category.getName() + " (ID: " + category.getId() + ")");
        return categoryRepository.save(category);
    }

    public Iterable<MemeCategory> findAll() {
        LOGGER.info("Categories count: " + categoryRepository.count());
        return categoryRepository.findAll();
    }

    public Optional<MemeCategory> findCategoryById(String categoryId){
        LOGGER.info("Finding category by ID: " + categoryId);
        return categoryRepository.findById(categoryId);
    }

    public MemeCategory updateCategory(MemeCategory category){
        try {
            Optional<MemeCategory> existingCategory = categoryRepository.findById(category.getId());
            if(existingCategory.isPresent()){
                MemeCategory categoryUpdate = existingCategory.get();
                categoryUpdate.setName(category.getName());
                categoryUpdate.setDescription(category.getDescription());
                categoryRepository.save(categoryUpdate);
                LOGGER.info("Category updated successfully:  " + category.getId());
                return categoryUpdate;
            } else {
                throw new RuntimeException("Category not found by ID: " + category.getId());
            }
        } catch (Exception e) {
            LOGGER.error("Failed to update category with ID " + category.getId() + ": " + e.getMessage(), e);
            throw new RuntimeException("Error updating category: " + e.getMessage());
        }
    }

    public void deleteCategoryById(String categoryId){
        try {
            categoryRepository.deleteById(categoryId);
            LOGGER.info("Category deleted successfully: " + categoryId);
        } catch (Exception e) {
            LOGGER.error("Failed to delete category with ID " + categoryId + ": " + e.getMessage(), e);
            throw new RuntimeException("Error deleting category: " + e.getMessage());
        }
    }
}

