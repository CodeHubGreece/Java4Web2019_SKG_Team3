package org.regeneration.project.controllers;

import org.regeneration.project.models.User;
import org.regeneration.project.models.UserType;
import org.regeneration.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(@Autowired UserService userService){
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
        user.setUserType(UserType.CITIZEN);
        return user;
    }

    @GetMapping("")
    public List<User> getUsers(){
        return  userService.getAllUsers();
    }

    //Single Item
    @GetMapping("/{id}")
    public Optional<User> getOneUser(@PathVariable Long id){
        return userService.getOneUser(id);
    }

    @PostMapping("")
    public User getNewUser(@RequestBody User newUser){
         return userService.postNewUser(newUser);
    }

    @PutMapping("/{id}")
    public void updateUser(@RequestBody User newUser, @PathVariable Long id){
//        return userService.updateUser(newUser, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
