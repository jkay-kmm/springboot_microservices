package com.anhtrung.learn_spring.repository;

import com.anhtrung.learn_spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
