package com.lucas_costa.course.resources;

import com.lucas_costa.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    public ResponseEntity<User> findAll(){
        User u = new User(1L,"Lucas", "email@email", "9999999", "12345");
        return ResponseEntity.ok().body(u);
    }
}
