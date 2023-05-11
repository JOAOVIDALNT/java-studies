package com.example.securitydemo.controllers;

import com.example.securitydemo.models.dtos.Login;
import com.example.securitydemo.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {


    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public String login(@RequestBody Login login) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(login.login(), login.password());
        Authentication authenticate =
                this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        var user = (User)authenticate.getPrincipal();
    }


}
