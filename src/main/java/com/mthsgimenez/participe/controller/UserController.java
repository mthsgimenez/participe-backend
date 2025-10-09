package com.mthsgimenez.participe.controller;

import com.mthsgimenez.participe.domain.user.UserDTO;
import com.mthsgimenez.participe.domain.user.UserResponseDTO;
import com.mthsgimenez.participe.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mthsgimenez.participe.mapper.UserMapper.toUserResponseDTO;
import static com.mthsgimenez.participe.mapper.UserMapper.toUserResponseDTOList;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserDTO data) {
        return ResponseEntity.ok(toUserResponseDTO(service.createUser(data)));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getUsers() {
        return ResponseEntity.ok(toUserResponseDTOList(service.getUsers()));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable("userId") Long id) {
        return ResponseEntity.ok(toUserResponseDTO(service.getUserById(id)));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") Long id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable("userId") Long id, @Valid @RequestBody UserDTO data) {
        return ResponseEntity.ok(toUserResponseDTO(service.updateUser(id, data)));
    }
}
