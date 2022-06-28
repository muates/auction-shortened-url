package com.auctionshortenedurl.user.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.auctionshortenedurl.user.converter.UserRequestConverter;
import com.auctionshortenedurl.user.model.entity.UserEntity;
import com.auctionshortenedurl.user.model.request.UserRequest;
import com.auctionshortenedurl.user.repository.UserRepository;
import com.auctionshortenedurl.user.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserServiceTest {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserRequestConverter userRequestConverter;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSignUp() {
        UserRequest request = new UserRequest();
        request.setUsername(USERNAME);
        request.setPassword(PASSWORD);

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(USERNAME);
        userEntity.setPassword(PASSWORD);

        UserEntity savedUser = new UserEntity();
        savedUser.setUserId(1L);

        when(userRequestConverter.convert(request)).thenReturn(any());
        when(userRepository.save(userEntity)).thenReturn(savedUser);

        UserEntity response = userService.signUp(request);

        assertNotNull(response);
        assertTrue(response.getUserId() > 0);

        verify(userRequestConverter, times(1)).convert(request);
        verify(userRepository, times(1)).save(any());
    }
}