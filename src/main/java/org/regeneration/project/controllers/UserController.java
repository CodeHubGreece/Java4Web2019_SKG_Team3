package org.regeneration.project.controllers;

import org.regeneration.project.dto.Dto;
import org.regeneration.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class UserController {

    private UserService userService;

    public UserController(@Autowired UserService userService){
        this.userService = userService;
    }

    @GetMapping("/user")
    public Dto getLoggedInUser(Principal loggedInUser) {
        return userService.getLoggedInUser(loggedInUser);
    }
}
