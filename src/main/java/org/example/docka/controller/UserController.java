package org.example.docka.controller;

import org.example.docka.AppUser;
import org.example.docka.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody AppUser user) {
        try {
            userRepo.save(user);
            return new ResponseEntity<>("User created successfully!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
