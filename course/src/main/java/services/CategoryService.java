package services;

import entities.Category;
import repositories.CategoryRepository;
import services.exceptions.DatabaseException;
import services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category
    findById(Long id){
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }

    public Category insert(Category obj){return repository.save(obj);}

    public void delete(Long id){
        try{
            repository.deleteById(id);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(e.getMessage());
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Category update(Category obj, Long id){
        try{
            Category entity = repository.getReferenceById(id);
            updateData(obj, entity);
            return repository.save(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(e.getMessage());
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Category updateData(Category obj, Category entity){
        entity.setName(obj.getName());
        return entity;
    }
}
