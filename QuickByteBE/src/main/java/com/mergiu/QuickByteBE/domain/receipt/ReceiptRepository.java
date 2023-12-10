package com.mergiu.QuickByteBE.domain.receipt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    @Query("SELECT r FROM Receipt r WHERE r.id = ?1")
    Receipt findReceiptById(Long id);
}
