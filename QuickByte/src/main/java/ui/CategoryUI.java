package ui;

import controller.CategoryController;
import domain.Category;
import repo.inMemory.InMemoryRepo;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CategoryUI {
    private static final CategoryController categoryController = new CategoryController(new InMemoryRepo<>());
    private static final Scanner scanner = new Scanner(System.in);

    public static void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Create Category");
            System.out.println("2. View Categories");
            System.out.println("3. Update Category");
            System.out.println("4. Delete Category");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createCategory();
                    break;
                case 2:
                    viewCategories();
                    break;
                case 3:
                    updateCategory();
                    break;
                case 4:
                    deleteCategory();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createCategory() {
        System.out.print("Enter category name: ");
        String name = scanner.nextLine();
        System.out.print("Enter category description: ");
        String description = scanner.nextLine();

        Category newCategory = new Category(0, name, description);
        Category createdCategory = categoryController.createEntity(newCategory);

        System.out.println("Category created with ID: " + createdCategory.getCategoryID());
    }

    private static void viewCategories() {
        System.out.println("Categories:");
        List<Category> categories = categoryController.getAllEntities();
        for (Category category : categories) {
            System.out.println("ID: " + category.getCategoryID() +
                    ", Name: " + category.getName() +
                    ", Description: " + category.getDescription());
        }
    }

    private static void updateCategory() {
        System.out.print("Enter category ID to update: ");
        int categoryID = scanner.nextInt();
        scanner.nextLine();

        Optional<Category> existingCategory = categoryController.getEntityById(categoryID);
        if (existingCategory.isPresent()) {
            System.out.print("Enter new category name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new category description: ");
            String description = scanner.nextLine();

            Category updatedCategory = new Category(categoryID, name, description);
            categoryController.updateEntity(updatedCategory);
            System.out.println("Category updated successfully.");
        } else {
            System.out.println("Category not found.");
        }
    }

    private static void deleteCategory() {
        System.out.print("Enter category ID to delete: ");
        int categoryID = scanner.nextInt();
        scanner.nextLine();

        boolean deleted = categoryController.deleteEntity(categoryID);
        if (deleted) {
            System.out.println("Category deleted successfully.");
        } else {
            System.out.println("Category not found.");
        }
    }
}
