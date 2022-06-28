package com.auctionshortenedurl.user.service;

import com.auctionshortenedurl.user.model.entity.UserEntity;
import com.auctionshortenedurl.user.model.request.UserRequest;

public interface UserService {
    UserEntity signUp(UserRequest userRequest);
}
