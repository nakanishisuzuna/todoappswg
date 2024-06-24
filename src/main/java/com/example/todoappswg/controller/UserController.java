package com.example.todoappswg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoappswg.model.User;
import com.example.todoappswg.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    //@Autowired
    //private AuthenticationManager authenticationManager;


    //private JwtUtil jwtUtil;
    //public UserController(JwtUtil jwtUtil) {
		//this.jwtUtil = jwtUtil;
	//}
    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user/register")
    public void register(@RequestBody User user) {
        userService.register(user);
    }
    
    @PostMapping("/user/login")
    public void login(@RequestBody User user) throws AuthenticationException {
       // authenticationManager.authenticate(
               // new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
    }
    
    //@PostMapping("/user/logout")
    public void logout(@RequestBody User user) {
        userService.logout(user);
    }
    
}
