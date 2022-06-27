package com.auctionshortenedurl.user.service;

import com.auctionshortenedurl.user.model.dto.UserDto;
import com.auctionshortenedurl.user.model.request.UserRequest;

public interface UserService {
    UserDto signUp(UserRequest userRequest);
}
