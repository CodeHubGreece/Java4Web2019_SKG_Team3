package org.regeneration.project.controllers;

import org.regeneration.project.models.User;
import org.regeneration.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    public UserController() {

    }

    private User dummyUser(Long id) {
        User user = new User();
        user.setId(id);
        user.setFirstName("George");
        user.setLastName("Kostopoulos");
        user.setEmail("George.Kst@icloud.com");
        user.setUsername("georgekst");
        user.setPassword("somepassword");
        user.setUserType("Patient");
        return user;
    }

    @GetMapping("")
    public List<User> getUsers() {
        return Arrays.asList(dummyUser(1L), dummyUser(2L));
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        System.out.println(id);
        return dummyUser(id);
    }

    @PostMapping("")
    public User createUser(@RequestBody User user) {
        return user;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        System.out.println(id);
        return user;
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable Long id) {
        System.out.println(id);
        return dummyUser(id);
    }
}
