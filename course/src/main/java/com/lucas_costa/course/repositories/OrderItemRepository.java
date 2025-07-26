package com.lucas_costa.course.repositories;

import com.lucas_costa.course.entities.OrderItem;
import com.lucas_costa.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
