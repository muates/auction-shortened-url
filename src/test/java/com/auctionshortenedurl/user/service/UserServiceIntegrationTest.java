package com.auctionshortenedurl.user.service;

import static org.junit.jupiter.api.Assertions.*;

import com.auctionshortenedurl.user.model.entity.UserEntity;
import com.auctionshortenedurl.user.model.request.UserRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    public void testSignUp() {
        UserRequest request = new UserRequest();
        request.setUsername("username");
        request.setPassword("password");

        UserEntity response = userService.signUp(request);

        assertNotNull(response);
        assertTrue(response.getUserId() > 0);
    }
}