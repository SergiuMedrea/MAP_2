package repo.inMemory;

import domain.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepo {
    private final List<Category> categories = new ArrayList<>();
    private long nextCategoryID = 1;

    /**
     * Create a new category and add it to the repository
     */
    public Category createCategory(String name, String description) {
        Category newCategory = new Category(nextCategoryID, name, description);
        categories.add(newCategory);
        nextCategoryID++;
        return newCategory;
    }

    /**
     * Retrieve a category by ID | NULL if not found
     */
    public Category getCategoryByID(Long categoryID) {
        return categories.stream()
                .filter(category -> category.categoryID().equals(categoryID))
                .findFirst()
                .orElse(null);
    }

    public List<Category> getAllCategories() {
        return new ArrayList<>(categories);
    }

    /**
     * Update an existing category and return the updated category
     */
    public Category updateCategory(Category updatedCategory) {
        for (int i = 0; i < categories.size(); i++) {
            Category category = categories.get(i);
            if (category.categoryID().equals(updatedCategory.categoryID())) {
                categories.set(i, updatedCategory);
                return updatedCategory;
            }
        }

        return null; // Category not found
    }

    /**
     * Delete a category by ID
     */
    public boolean deleteCategory(Long categoryID) {
        return categories.removeIf(category -> category.categoryID().equals(categoryID));
    }
}
