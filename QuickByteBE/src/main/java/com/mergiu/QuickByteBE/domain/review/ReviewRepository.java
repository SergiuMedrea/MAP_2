package com.mergiu.QuickByteBE.domain.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT r FROM Review r WHERE r.id = ?1")
    Review findByReceiptId(Long receiptId);

}
