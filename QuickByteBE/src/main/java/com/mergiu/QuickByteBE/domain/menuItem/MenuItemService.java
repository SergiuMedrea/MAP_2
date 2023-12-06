package com.mergiu.QuickByteBE.domain.menuItem;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MenuItemService {

    private final MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public List<MenuItem> getMenuItems() {
        return menuItemRepository.findAll();
    }

    public void addNewMenuItem(MenuItem menuItem) {
        Optional<MenuItem> menuItemOptional = menuItemRepository.findMenuItemByName(menuItem.getName());
        if(menuItemOptional.isPresent())
            throw new IllegalStateException("MenuItem with name " + menuItem.getName() + " already exists");

        menuItemRepository.save(menuItem);
    }

    public void deleteMenuItem(Long menuItemId) {
        boolean exists = menuItemRepository.existsById(menuItemId);

        if (!exists) {
            throw new IllegalStateException("MenuItem with id " + menuItemId + " does not exist");
        }

        menuItemRepository.deleteById(menuItemId);
    }

    @Transactional
    public void updateMenuItem(Long menuItemId, String name, int price, String description) {
        MenuItem menuItem = menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new IllegalStateException("MenuItem with id " + menuItemId + " does not exist"));

        if (name != null && !name.isEmpty() && !Objects.equals(menuItem.getName(), name)) {
            menuItem.setName(name);
        }

        if (price >= 0 && menuItem.getPrice() != price) {
            menuItem.setPrice(price);
        }

        if (description != null && !description.isEmpty() && !Objects.equals(menuItem.getDescription(), description)) {
            menuItem.setDescription(description);
        }

        menuItemRepository.save(menuItem);
    }
}
