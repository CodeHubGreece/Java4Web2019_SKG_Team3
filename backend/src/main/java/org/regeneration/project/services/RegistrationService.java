package org.regeneration.project.services;

import org.regeneration.project.dto.Dto;
import org.regeneration.project.dto.RegistrationDTO;
import org.regeneration.project.models.Citizen;
import org.regeneration.project.models.User;
import org.regeneration.project.models.UserType;
import org.regeneration.project.repositories.CitizenRepository;
import org.regeneration.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private UserRepository userRepository;
    private CitizenRepository citizenRepository;
    private PasswordEncoder passwordEncoder;

    public RegistrationService(@Autowired UserRepository userRepository, @Autowired CitizenRepository citizenRepository,
                               @Autowired PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.citizenRepository = citizenRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Dto registerNewUser(RegistrationDTO newUser) {
        User user = new User(newUser.getFirstName(), newUser.getLastName(), newUser.getEmail(), newUser.getUsername(),
                passwordEncoder.encode(newUser.getPassword()), UserType.CITIZEN);
        User savedUser = userRepository.save(user);
        Citizen citizen = new Citizen(newUser.getSsn(), newUser.getMobileNumber(), savedUser);
        Citizen savedCitizen = citizenRepository.save(citizen);
        return new RegistrationDTO(savedUser.getFirstName(), savedUser.getLastName(),
                savedUser.getEmail(), savedUser.getUsername(), savedUser.getPassword(), savedCitizen.getSsn(),
                savedCitizen.getMobileNumber());
    }
}
