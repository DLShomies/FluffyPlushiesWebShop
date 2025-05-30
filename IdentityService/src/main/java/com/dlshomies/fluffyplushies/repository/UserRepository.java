package com.dlshomies.fluffyplushies.repository;

import com.dlshomies.fluffyplushies.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Boolean existsByUsernameOrEmail(String username, String email);

    Optional<User> findByUsername(String username);
}
