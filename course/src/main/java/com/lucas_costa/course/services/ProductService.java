package com.lucas_costa.course.services;

import com.lucas_costa.course.entities.Product;
import com.lucas_costa.course.repositories.ProductRepository;
import com.lucas_costa.course.services.exceptions.DatabaseException;
import com.lucas_costa.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }

    public Product insert(Product obj){return repository.save(obj);}

    public void delete(Long id){
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(e.getMessage());
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Product update(Long id, Product obj){
        try{
            Product entity = repository.getReferenceById(id);
            updateData(obj, entity);
            return repository.save(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    public Product updateData(Product obj, Product entity){
        entity.setDescription(obj.getDescription());
        entity.setName(obj.getName());
        entity.setPrice(obj.getPrice());
        entity.setImgUrl(obj.getImgUrl());

        return entity;
    }
}
