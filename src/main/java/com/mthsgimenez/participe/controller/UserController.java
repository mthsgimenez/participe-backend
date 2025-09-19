package com.mthsgimenez.participe.controller;

import com.mthsgimenez.participe.domain.user.User;
import com.mthsgimenez.participe.domain.user.UserDTO;
import com.mthsgimenez.participe.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO data) {
        return ResponseEntity.ok(service.createUser(data));
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(service.getUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Long id) {
        return ResponseEntity.ok(service.getUserById(id));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") Long id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") Long id, @Valid @RequestBody UserDTO data) {
        return ResponseEntity.ok(service.updateUser(id, data));
    }
}
