package com.auctionshortenedurl.auctionshortenedurl.user.service;

import com.auctionshortenedurl.auctionshortenedurl.user.model.dto.UserDto;
import com.auctionshortenedurl.auctionshortenedurl.user.model.request.UserRequest;

public interface UserService {
    UserDto signUp(UserRequest userRequest);
}
