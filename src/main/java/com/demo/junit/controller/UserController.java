package com.demo.junit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.junit.service.UserService;
import com.demo.junit.user.User;

@Controller
public class UserController {
	 @Autowired
	    private UserService userService;
	    
	    @PostMapping("/register")
	    public ResponseEntity<User> registerUser(@RequestBody User user) {
	        User registeredUser = userService.registerUser(user);
	        return ResponseEntity.ok(registeredUser);
	    }

	    @GetMapping("/{username}")
	    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
	        User user = userService.findUserByUsername(username);
	        if (user != null) {
	            return ResponseEntity.ok(user);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	}
	