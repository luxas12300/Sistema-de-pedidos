package com.lucas_costa.course.repositories;

import com.lucas_costa.course.entities.Category;
import com.lucas_costa.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
