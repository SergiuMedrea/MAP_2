package com.mergiu.QuickByteBE.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<SimpleUser, Long> {

    @Query("SELECT u FROM SimpleUser u WHERE u.phoneNumber = ?1")
    Optional<SimpleUser> findByPhoneNumber(String phoneNumber);
}
