package com.fitness.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fitness.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
