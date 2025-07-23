package com.lucas_costa.course.repositories;

import com.lucas_costa.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
