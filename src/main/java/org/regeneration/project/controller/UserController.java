package org.regeneration.project.controller;

import org.regeneration.project.service.UserService;
import org.regeneration.project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController{

    private UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getBookById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

//    @PostMapping("/books")
//    public User newBook(@RequestBody User user) {
//        return userService.newBook(user);
//    }

}
