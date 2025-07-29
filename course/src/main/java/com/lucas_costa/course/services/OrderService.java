package com.lucas_costa.course.services;

import com.lucas_costa.course.entities.Order;
import com.lucas_costa.course.entities.User;
import com.lucas_costa.course.repositories.OrderRepository;
import com.lucas_costa.course.repositories.UserRepository;
import com.lucas_costa.course.services.exceptions.DatabaseException;
import com.lucas_costa.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }

    public Order insert(Order obj){return repository.save(obj);}

    public void delete(Long id){
        try{
            repository.deleteById(id);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(e.getMessage());
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Order update(Long id, Order obj){
        try{
            Order entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(e.getMessage());
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Order updateData(Order entity, Order obj){
        entity.setPayment(obj.getPayment());
        entity.setOrderStatus(obj.getOrderStatus());
        entity.setClient(obj.getClient());
        return entity;
    }
}
