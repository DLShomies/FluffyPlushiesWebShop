package com.dlshomies.fluffyplushies.repository;

import com.dlshomies.fluffyplushies.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    List<User> findAllByDeletedFalse();
}
