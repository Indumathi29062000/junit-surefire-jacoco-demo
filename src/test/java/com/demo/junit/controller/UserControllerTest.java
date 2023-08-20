package com.demo.junit.controller;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.demo.junit.service.UserService;
import com.demo.junit.user.User;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterUser() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("testpass");

        when(userService.registerUser(user)).thenReturn(user);

        ResponseEntity<User> responseEntity = userController.registerUser(user);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("testuser", responseEntity.getBody().getUsername());
    }

    @Test
    void testGetNonExistentUserByUsername() {
        when(userService.findUserByUsername("nonexistent")).thenReturn(null);

        ResponseEntity<User> responseEntity = userController.getUserByUsername("nonexistent");

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }
}
