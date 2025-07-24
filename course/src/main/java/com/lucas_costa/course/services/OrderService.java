package com.lucas_costa.course.services;

import com.lucas_costa.course.entities.Order;
import com.lucas_costa.course.entities.User;
import com.lucas_costa.course.repositories.OrderRepository;
import com.lucas_costa.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order
    findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }

}
