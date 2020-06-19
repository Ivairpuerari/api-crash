package com.aceleradev.api.crash.repository;

import java.util.Optional;

import com.aceleradev.api.crash.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}