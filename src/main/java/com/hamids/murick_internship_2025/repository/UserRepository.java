package com.hamids.murick_internship_2025.repository;

import com.hamids.murick_internship_2025.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
}


