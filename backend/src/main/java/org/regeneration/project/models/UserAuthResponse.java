package org.regeneration.project.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

public class UserAuthResponse {

    private String jwt;

    @Autowired
    private UserDetails userDetails;

    public UserAuthResponse(String jwt, UserDetails userDetails) {
        this.jwt = jwt;
        this.userDetails = userDetails;
    }

    public String getJwt(){
        return jwt;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }
}
