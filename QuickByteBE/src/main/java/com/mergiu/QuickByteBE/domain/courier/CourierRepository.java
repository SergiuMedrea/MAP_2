package com.mergiu.QuickByteBE.domain.courier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CourierRepository extends JpaRepository<Courier, Long> {

    @Query("SELECT c FROM Courier c WHERE c.phoneNumber = ?1")
    Optional<Courier> findByPhoneNumber(String phoneNumber);
}
