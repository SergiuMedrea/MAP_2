package com.mergiu.QuickByteBE.domain.category;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public void addNewCategory(Category category) {
        Optional<Category> categoryOptional = categoryRepository.findByName(category.getName());

        if (categoryOptional.isPresent()) {
            throw new IllegalStateException("Category with name " + category.getName() + " already exists");
        }

        categoryRepository.save(category);
    }

    public void deleteCategory(Long categoryId) {
        boolean exists = categoryRepository.existsById(categoryId);

        if (!exists) {
            throw new IllegalStateException("Category with id " + categoryId + " does not exist");
        }

        categoryRepository.deleteById(categoryId);
    }

    @Transactional
    public void updateCategory(Long categoryId, String name, String description) {
        Category category = categoryRepository.findById(categoryId).
                orElseThrow(() -> new IllegalStateException("Category with id " + categoryId + " does not exist"));

        if (name != null &&
                !name.isEmpty() &&
                !Objects.equals(category.getName(), name)) {
            Optional<Category> categoryOptional = categoryRepository.findByName(name);

            if (categoryOptional.isPresent()) {
                throw new IllegalStateException("Category with name " + name + " already exists");
            }

            category.setName(name);
        }

        if (description != null &&
                !description.isEmpty() &&
                !Objects.equals(category.getDescription(), description)) {
            category.setDescription(description);
        }
    }

}
