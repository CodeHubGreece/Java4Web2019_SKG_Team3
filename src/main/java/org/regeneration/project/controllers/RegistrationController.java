package org.regeneration.project.controllers;

import org.regeneration.project.dto.Dto;
import org.regeneration.project.dto.RegistrationDTO;
import org.regeneration.project.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    private RegistrationService registrationService;

    public RegistrationController(@Autowired RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    public Dto registerNewUser(@RequestBody RegistrationDTO newUser) {
        return registrationService.registerNewUser(newUser);
    }
}
