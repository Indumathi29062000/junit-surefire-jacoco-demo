package com.demo.junit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.junit.user.User;

@Service
public class UserService {
	  private List<User> userList = new ArrayList<>();
	  public User registerUser(User user) {
	       userList.add(user);
	       return user;
	    }
	  public User findUserByUsername(String username) {
	        return userList.stream()
	                .filter(user -> user.getUsername().equals(username))
	                .findFirst()
	                .orElse(null);
	    }
}
