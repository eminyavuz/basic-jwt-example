package com.example.jwtexample.repository;

import com.example.jwtexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
 User findByUsername(String username);
}
