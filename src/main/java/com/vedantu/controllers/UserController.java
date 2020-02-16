package com.vedantu.controllers;

import com.vedantu.requests.UserRequest;
import com.vedantu.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;
    /* this is injected from bean created in security config file */

    @Autowired
    JwtUtil jwtUtil;


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@RequestBody UserRequest userReq) throws Exception {
        // this can be accessed by anyone
        System.out.println(userReq.getUsername());
        System.out.println(userReq.getPassword());
        try{
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userReq.getUsername(), userReq.getPassword()));
            System.out.println(auth.getName());
            System.out.println(auth.getAuthorities());
        }catch(Exception e){
            System.out.println(e);
            throw new Exception(e);
        }
        return ResponseEntity.ok("login success!!!");
    }
}

/*
This is basic application. Only we are showing how authentication works with inmemoryauthentication strategy
To generate tokens, and create context, we need to learn about InMemoryUserDetailsManager
But we dont go with that. We go with CustomUserDetailsService. Here we implement tokens and authorization
 */