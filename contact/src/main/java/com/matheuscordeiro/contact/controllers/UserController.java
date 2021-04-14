package com.matheuscordeiro.contact.controllers;

import com.matheuscordeiro.contact.models.User;
import com.matheuscordeiro.contact.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/authenticate")
    public ResponseEntity<User> authenticate(@RequestBody User user) {
        return ResponseEntity.ok(userService.authenticateOrThrow(user.getUsername(), user.getPassword()));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUserOrThrow(user));
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> getByUser(@PathVariable Long id) {
        return ResponseEntity.of(userService.getByUser(id));
    }
}
