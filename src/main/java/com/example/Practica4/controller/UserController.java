package com.example.Practica4.controller;

import com.example.Practica4.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private List<User> users = new ArrayList<>();
    private Long userIdCounter = 1L;

    // Crear un nuevo usuario (POST)
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // Verificar si el email ya está en uso
        for (User existingUser : users) {
            if (existingUser.getEmail().equals(user.getEmail())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build(); // Email ya en uso
            }
        }
        // Asignar un ID y agregar el usuario a la lista
        user.setId(userIdCounter++);
        users.add(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    // Leer todos los usuarios (GET)
    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }

    // Leer un usuario por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return ResponseEntity.ok(user);
            }
        }
        return ResponseEntity.notFound().build();
    }

    //Actualizar un usuario (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User newUser) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                user.setName(newUser.getName());
                user.setEmail(newUser.getEmail());
                user.setPassword(newUser.getPassword());
                return ResponseEntity.ok(user);
            }
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar un usuario (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                users.remove(user);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}
