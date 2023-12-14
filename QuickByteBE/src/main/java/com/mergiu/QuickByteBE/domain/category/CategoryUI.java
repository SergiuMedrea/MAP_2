package com.mergiu.QuickByteBE.domain.category;

import com.mergiu.QuickByteBE.ui.EntityUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class CategoryUI implements EntityUI {

    private final CategoryService categoryService;
//    private final CategoryFactory categoryFactory;


    @Autowired
    public CategoryUI(CategoryService categoryService){//, CategoryFactory categoryFactory) {
        this.categoryService = categoryService;
//        this.categoryFactory = categoryFactory;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. List all categories");
            System.out.println("2. Add a new category");
            System.out.println("3. Delete a category");
            System.out.println("4. Update a category");
            System.out.println("5. Back to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    listAllCategories();
                    break;
                case 2:
                    addNewCategory(scanner);
                    break;
                case 3:
                    deleteCategory(scanner);
                    break;
                case 4:
                    updateCategory(scanner);
                    break;
                case 5:
                    return; // Return to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void listAllCategories() {
        List<Category> categories = categoryService.getCategories();
        categories.forEach(System.out::println);
    }

    private void addNewCategory(Scanner scanner) {
        System.out.println("Enter category name:");
        String name = scanner.nextLine();

        System.out.println("Enter category description:");
        String description = scanner.nextLine();

//        Category newCategory = categoryFactory.createCategory(name, description);
//        categoryService.addNewCategory(newCategory);
        System.out.println("Category added successfully.");
    }

    private void deleteCategory(Scanner scanner) {
        System.out.println("Enter category ID to delete:");
        Long categoryId = scanner.nextLong();
        categoryService.deleteCategory(categoryId);
        System.out.println("Category deleted successfully.");
    }

    private void updateCategory(Scanner scanner) {
        System.out.println("Enter category ID to update:");
        Long categoryId = scanner.nextLong();
        scanner.nextLine(); // Consume the newline

        System.out.println("Enter new category name (press Enter to skip):");
        String name = scanner.nextLine();

        System.out.println("Enter new category description (press Enter to skip):");
        String description = scanner.nextLine();

        categoryService.updateCategory(categoryId, name, description);
        System.out.println("Category updated successfully.");
    }
}
