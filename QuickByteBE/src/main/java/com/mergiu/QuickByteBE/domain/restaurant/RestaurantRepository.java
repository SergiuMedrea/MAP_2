package com.mergiu.QuickByteBE.domain.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Query("SELECT r from Restaurant r where r.name = ?1")
    Optional<Restaurant> findByName(String name);
}

