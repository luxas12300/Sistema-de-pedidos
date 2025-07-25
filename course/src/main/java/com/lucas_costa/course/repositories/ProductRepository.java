package com.lucas_costa.course.repositories;

import com.lucas_costa.course.entities.Product;
import com.lucas_costa.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
