package com.demo.junit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.demo.junit.user.User;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @Test
    @DisplayName("Test user registration")
    void testRegisterUser() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("testpass");
        User registeredUser = userService.registerUser(user);

        assertNotNull(registeredUser);
        assertEquals("testuser", registeredUser.getUsername());
    }

    @Test
    @DisplayName("Test finding user by username")
    void testFindUserByUsername() {
        User user = new User();
        user.setUsername("user1");
        userService.registerUser(user);

        User foundUser = userService.findUserByUsername("user1");
        assertNotNull(foundUser);
        assertEquals("user1", foundUser.getUsername());
    }

    @Test
    @DisplayName("Test finding non-existent user by username")
    void testFindNonExistentUserByUsername() {
        User foundUser = userService.findUserByUsername("nonexistent");
        assertNull(foundUser);
    }
}
