package resources;

import entities.Order;
import services.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/orders")
public class OrderResource {

    @Autowired
    private OrderService service;
    @GetMapping
    @Operation(summary = "Get all OrderResources.")
    public ResponseEntity<List<Order>> findAll(){
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get OrderResource by Id")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping
    @Operation(summary = "Insert Product by Id")
    public ResponseEntity<Order> insert(@RequestBody Order obj){
        service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand().toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete OrderResource by Id")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Update OrderResource by Id")
    public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody Order obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}