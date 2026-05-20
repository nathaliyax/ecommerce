package com.projeto.ecommerce.repositories;

import com.projeto.ecommerce.entities.UserService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserService, UUID> {
    org.apache.catalina.User findByEmail(String email);
}