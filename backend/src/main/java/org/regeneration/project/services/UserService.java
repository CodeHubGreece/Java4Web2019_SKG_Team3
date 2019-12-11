package org.regeneration.project.services;

import org.regeneration.project.models.User;
import org.regeneration.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private  UserRepository userRepository;

    public UserService(@Autowired UserRepository userRepository){this.userRepository = userRepository;}
    //GET ALL USERS
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //POST NEW USER
    public User postNewUser(User newUser){
        return userRepository.save(newUser);
    }

    //GET ONE USER
    public Optional<User> getOneUser(Long id){
        return userRepository.findById(id);
    }

    //UPDATE ONE USER IF EXISTS OR INSERT INTO DB
    public User updateUser(User newUser, Long id){
        return userRepository.findById(id)
                .map(user -> {
                    user.setFirst_name(newUser.getFirst_name());
                    user.setLast_name((newUser.getLast_name()));
                    user.setUsername((newUser.getUsername()));
                    user.setPassword(newUser.getPassword());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return  userRepository.save(newUser);
                });
    }

    //DELETE ONE USER
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
