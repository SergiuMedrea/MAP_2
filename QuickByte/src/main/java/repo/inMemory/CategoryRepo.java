package repo.inMemory;

import domain.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CategoryRepo {
    private final List<Category> categories = new ArrayList<>();
    private int nextCategoryID = 1;

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
     * Retrieve a category by ID | Optional.empty() if not found
     */
    public Optional<Category> getCategoryByID(Integer categoryID) {
        return categories.stream()
                .filter(category -> Objects.equals(categoryID, category.categoryID()))
                .findFirst();
    }

    /**
     * Retrieve all categories
     */
    public List<Category> getAllCategories() {
        return new ArrayList<>(categories);
    }

    /**
     * Update an existing category
     */
    public boolean updateCategory(Category updatedCategory) {
        for (int i = 0; i < categories.size(); i++) {
            Category existingCategory = categories.get(i);
            if (Objects.equals(existingCategory.categoryID(), updatedCategory.categoryID())) {
                categories.set(i, updatedCategory);
                return true; // Update successful
            }
        }
        return false; // Category not found
    }

    /**
     * Delete a category by ID
     */
    public boolean deleteCategory(Integer categoryID) {
        return categories.removeIf(category -> Objects.equals(categoryID, category.categoryID()));
    }
}
