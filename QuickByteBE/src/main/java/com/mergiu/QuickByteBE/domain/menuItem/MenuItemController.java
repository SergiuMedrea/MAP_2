package com.mergiu.QuickByteBE.domain.menuItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menuItems")
public class MenuItemController {

    private final MenuItemService menuItemService;

    @Autowired
    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping
    public List<MenuItem> getMenuItems() {
        return menuItemService.getMenuItems();
    }

    @PostMapping
    public void addNewMenuItem(@RequestBody MenuItem menuItem) {
        menuItemService.addNewMenuItem(menuItem);
    }

    @DeleteMapping("/{menuItemId}")
    public void deleteMenuItem(@PathVariable Long menuItemId) {
        menuItemService.deleteMenuItem(menuItemId);
    }

    @PutMapping("/{menuItemId}")
    public void updateMenuItem(
            @PathVariable Long menuItemId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) int price,
            @RequestParam(required = false) String description) {
        menuItemService.updateMenuItem(menuItemId, name, price, description);
    }
}