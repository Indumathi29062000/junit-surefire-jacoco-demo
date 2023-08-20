package com.demo.junit.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void testGetUsername() {
        user.setUsername("testuser");
        assertEquals("testuser", user.getUsername());
    }

    @Test
    void testSetUsername() {
        user.setUsername("newuser");
        assertEquals("newuser", user.getUsername());
    }

    @Test
    void testGetPassword() {
        user.setPassword("testpass");
        assertEquals("testpass", user.getPassword());
    }

    @Test
    void testSetPassword() {
        user.setPassword("newpass");
        assertEquals("newpass", user.getPassword());
    }
    
}