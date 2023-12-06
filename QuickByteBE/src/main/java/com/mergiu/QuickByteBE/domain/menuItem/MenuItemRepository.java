package com.mergiu.QuickByteBE.domain.menuItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    @Query("SELECT m FROM MenuItem m WHERE m.name = ?1")
    Optional<MenuItem> findMenuItemByName(String name);
}
