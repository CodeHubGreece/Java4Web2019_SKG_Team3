package org.regeneration.project.security;

import org.regeneration.project.models.User;
import org.regeneration.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ApiUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("username not found");
        }

        ApiUserDetails userDetails = new ApiUserDetails(user.getUsername(), user.getPassword());
        return userDetails;
    }

}
