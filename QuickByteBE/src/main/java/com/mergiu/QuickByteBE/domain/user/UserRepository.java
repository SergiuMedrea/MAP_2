package com.mergiu.QuickByteBE.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.phoneNumber = ?1")
    Optional<User> findByPhoneNumber(String phoneNumber);
}
