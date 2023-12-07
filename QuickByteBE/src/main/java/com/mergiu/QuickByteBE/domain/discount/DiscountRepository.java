package com.mergiu.QuickByteBE.domain.discount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
    @Query("select d from Discount d where d.name = ?1")
    Optional<Discount> findByName(String name);
}
